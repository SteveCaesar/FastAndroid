package com.fastandroid.lib.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.fastandroid.MyApplication;
import com.fastandroid.common.AndroidVersionUtils;
import com.fastandroid.lib.log.TALogger;
import com.fastandroid.mvc.model.RecyclingBitmapDrawable;

/**
 * @description 图片L1(内存)缓存
 * @author 许友爻
 * @date 2014年7月14日下午2:37:11
 * @version 1.0
 */
public class BitmapMemoryCache implements ImageCache {
	/* 默认内存最大缓存占据多少空间，单位：KB。 */
	public final int defmaxCacheSizeInKB = 5 * 1024;// 5M
	/* 内存中强引用容器 */
	private LruCache<String, BitmapDrawable> mCache;
	/* 内存中软引用容器 */
	private HashMap<String, SoftReference<Bitmap>> mReusableBitmaps;

	/**
	 * 初始化图片缓存对象
	 * 
	 * @param maxCacheSizeInKB
	 *            设置内存最大缓存占据多少空间，单位：KB。0则使用系统默认大小
	 * */
	public BitmapMemoryCache(int maxCacheSizeInKB) {
		mReusableBitmaps = new HashMap<String, SoftReference<Bitmap>>();
		if (maxCacheSizeInKB <= 0)
			maxCacheSizeInKB = defmaxCacheSizeInKB;
		mCache = new LruCache<String, BitmapDrawable>(maxCacheSizeInKB) {
			/**
			 * 计算图片在内存中所占的字节数
			 * */
			@Override
			protected int sizeOf(String key, BitmapDrawable value) {
				final int bitmapSize = getBitmapSize(value.getBitmap()) / 1024;
				TALogger.i(this, "计算内存中图片size---" + bitmapSize + "kb");
				return bitmapSize == 0 ? 1 : bitmapSize;
			}

			/*
			 * 移除LruCache中对象时回调的方法
			 */
			protected void entryRemoved(boolean evicted, String key,
					BitmapDrawable oldValue, BitmapDrawable newValue) {
				if (RecyclingBitmapDrawable.class.isInstance(oldValue)) {// 如果成立，当前的版本一定是3.0以下
					// 标记此图片不再被缓存，通知系统回收
					((RecyclingBitmapDrawable) oldValue).setIsCached(false);
				} else {
					// 将超出设置的最大内存限制的图片放入软引用容器
					mReusableBitmaps.put(key, new SoftReference<Bitmap>(
							oldValue.getBitmap()));
				}
				TALogger.i(this, "从LRUCache中移出图片:" + oldValue.toString());
			}
		};
	}

	public BitmapMemoryCache() {
		this(0);
	}

	@Override
	public Bitmap getBitmap(String url) {
		BitmapDrawable drawable = mCache.get(url);
		if (drawable == null) {
			SoftReference<Bitmap> sf = mReusableBitmaps.get(url);
			if (sf == null)
				return null;
			Bitmap bitmap = sf.get();// 从软引用中获取此对象的引用
			mReusableBitmaps.remove(url);// 移除此对象的软引用
			if (bitmap != null)
				putBitmap(url, bitmap);
			return bitmap;
		}
		return drawable.getBitmap();
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		BitmapDrawable drawable;
		if (bitmap != null) {
			Resources mResources = MyApplication.getApplication()
					.getResources();
			if (AndroidVersionUtils.hasHoneycomb()) {// 判断android版本是否为3.0以上
				drawable = new BitmapDrawable(mResources, bitmap);
			} else {
				drawable = new RecyclingBitmapDrawable(mResources, bitmap);
				((RecyclingBitmapDrawable) drawable).setIsCached(true);
			}

			if (mCache != null) {
				mCache.put(url, drawable);
			}
		}
	}

	@SuppressLint("NewApi")
	public static int getBitmapSize(Bitmap bitmap) {
		// From KitKat onward use getAllocationByteCount() as allocated bytes
		// can potentially be
		// larger than bitmap byte count.
		if (AndroidVersionUtils.hasKitKat()) {
			return bitmap.getAllocationByteCount();
		}

		if (AndroidVersionUtils.hasHoneycombMR1()) {
			return bitmap.getByteCount();
		}

		// Pre HC-MR1
		return bitmap.getRowBytes() * bitmap.getHeight();
	}
}
