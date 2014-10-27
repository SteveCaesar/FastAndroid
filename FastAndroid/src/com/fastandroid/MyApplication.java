package com.fastandroid;

import java.io.File;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Timer;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.ImageLoader;
import com.fastandroid.common.DiskUtils;
import com.fastandroid.lib.cache.BitmapMemoryCache;
import com.fastandroid.lib.config.PreferenceConfig;
import com.fastandroid.lib.db.TASQLiteDatabasePool;
import com.fastandroid.lib.http.volley.VolleyFactory;
import com.fastandroid.lib.log.TALogger;
import com.fastandroid.lib.netstate.NetChangeObserver;
import com.fastandroid.lib.netstate.NetWorkUtil;
import com.fastandroid.lib.netstate.NetworkStateReceiver;
import com.fastandroid.lib.netstate.NetWorkUtil.NetType;

/**
 * @Description 生命周期最长的对象，从应用的创建到应用的彻底结束，通过继承此类来完成基础设施的初始化
 * @author 许友爻
 * @date 2014年6月13日 下午4:25:13
 * @version 1.0
 */
public class MyApplication extends Application {
	// 全局常量定义
	/** app的本地缓存 类型：{@link File} */
	public static final String APP_DISK_CACHEDIR = "app_disk_cachedir";
	/** app的版本名称 类型：{@link String} */
	public static final String APP_VERSION_NAME = "app_version_name";
	/** app的版本码 类型：{@link Integer} */
	public static final String APP_VERSION_CODE = "app_version_code";

	private final String TAG = MyApplication.class.getName();
	/** 当前Application的引用 */
	protected static MyApplication mInstance;
	/** 本地缓存网络数据的最大存储空间 单位：KB */
	private int maxDiskStorageSize = 20 * 1024;
	/** 内存缓存图片最大的存储空间 单位：KB */
	private int maxMemoryStorageSize = 5 * 1024;
	/** App异常崩溃处理器 */
	private UncaughtExceptionHandler uncaughtExceptionHandler;
	/** 网络请求队列 */
	private RequestQueue mRequestQueue;
	/** 图片内存缓存 */
	private BitmapMemoryCache bitmapMemoryCache;
	/** 图片加载器 */
	private ImageLoader mImageLoader;
	/** 缓存数据，多用于数据传递，数据不使用后，请务必将其从此集合中移除，防止内存泄漏发生 */
	protected HashMap<String, Object> appData;
	/** 应用程序Activity管理器 */
	private TAAppManager mAppManager;
	/** 配置文件 */
	private PreferenceConfig config;
	@Override
	public final void onCreate() {
		onPreCreateApplication();
		doOncreate();
		onAfterCreateApplication();
	}

	/** 初始化参数 在onPreCreateApplication后执行,重写方法需要在第一行调用父类此方法 */
	public void initParameters() {
		this.appData = new HashMap<String, Object>();
		appData.put(APP_DISK_CACHEDIR, DiskUtils.getDiskCacheDir(this));
		// 获取当前APP的versionCode&versionName
		try {
			PackageInfo pi = getPackageManager().getPackageInfo(
					getPackageName(), 0);
			appData.put(APP_VERSION_NAME, pi.versionName);
			appData.put(APP_VERSION_CODE, pi.versionCode);
		} catch (NameNotFoundException e) {
			TALogger.e(TAG, e.getMessage());
		}
	}

	/**
	 * Application被创建时执行此方法
	 */
	private void doOncreate() {
		initParameters();
		this.mInstance = this;
		this.config = new PreferenceConfig("config", Context.MODE_PRIVATE);
		NetChangeObserver netChangeObserver = new NetChangeObserver() {
			@Override
			public void onConnect(NetType type) {
				MyApplication.this.onConnect(type);
			}

			@Override
			public void onDisConnect() {
				MyApplication.this.onDisConnect();
			}
		};
		NetworkStateReceiver receiver = NetworkStateReceiver.getReceiver();
		// 注册网络连接变化的观察者
		receiver.registerObserver(netChangeObserver);
		// 注册网络变化广播
		NetWorkUtil.registerNetworkStateReceiver(receiver, this);
		// activity管理器初始化
		mAppManager = TAAppManager.getAppManager();
		DiskBasedCache diskCache = new DiskBasedCache(
				(File) this.appData.get(APP_DISK_CACHEDIR),
				maxDiskStorageSize * 1024);
		// 网络请求队列初始化
		mRequestQueue = VolleyFactory.newRequestQueue(this, diskCache);
		// 图片加载器初始化
		bitmapMemoryCache = new BitmapMemoryCache(maxMemoryStorageSize);
		mImageLoader = new ImageLoader(mRequestQueue, bitmapMemoryCache);
	}

	/**
	 * doOncreate方法执行前调用此方法
	 */
	protected void onPreCreateApplication() {

	}

	/**
	 * doOncreate方法执行结束后调用此方法
	 */
	protected void onAfterCreateApplication() {

	}

	/**
	 * 设置 App异常崩溃处理器
	 * 
	 * @param uncaughtExceptionHandler
	 */
	public void setUncaughtExceptionHandler(
			UncaughtExceptionHandler uncaughtExceptionHandler) {
		this.uncaughtExceptionHandler = uncaughtExceptionHandler;
	}

	/**
	 * 网络连接断开时调用
	 */
	public void onDisConnect() {

	}

	/**
	 * 网络连接接入网络时调用
	 */
	protected void onConnect(NetType type) {

	}

	/**
	 * 获取一个网络请求队列
	 * */
	public RequestQueue getRequestQueue() {
		return this.mRequestQueue;
	}

	/**
	 * 获取一个图片内存缓存
	 * */
	public BitmapMemoryCache getBitmapMemoryCache() {
		return bitmapMemoryCache;
	}

	/**
	 * 获取一个图片加载器
	 * */
	public ImageLoader getImageLoader() {
		return this.mImageLoader;
	}

	/**
	 * 获取Application
	 */
	public static MyApplication getApplication() {
		return mInstance;
	}

	// /**
	// * 释放资源
	// * */
	// public void release() {
	// this.imageLoader = null;
	// this.mRequestQueue = null;
	// this.map = null;
	// this.uncaughtExceptionHandler = null;
	// AppException.dstroyInstance();
	// this.mInstance = null;
	//
	// }

	/**
	 * 获取activity管理器
	 * */
	public TAAppManager getAppManager() {
		return mAppManager;
	}

	/**
	 * 获取数据库连接池
	 * 
	 * @param dbName
	 *            数据库名字
	 * @param dbVersion
	 *            版本
	 * @param isWrite
	 *            打开数据库如果是 isWrite为true,则磁盘满时抛出错误
	 * */
	public TASQLiteDatabasePool getSQLiteDatabasePool(String dbName,
			int dbVersion, boolean isWrite) {
		// 数据库连接池初始化
		TASQLiteDatabasePool mSQLiteDatabasePool = TASQLiteDatabasePool
				.getInstance(this, dbName, dbVersion, isWrite);
		mSQLiteDatabasePool.createPool();
		return mSQLiteDatabasePool;
	}

	/**
	 * 设置本地缓存网络数据的最大存储空间 单位：KB
	 * */
	public void setMaxDiskStorageSize(int maxDiskStorageSize) {
		this.maxDiskStorageSize = maxDiskStorageSize;
	}

	/**
	 * 设置内存缓存图片最大的存储空间 单位：KB
	 * */
	public void setMaxMemoryStorageSize(int maxMemoryStorageSize) {
		this.maxMemoryStorageSize = maxMemoryStorageSize;
	}

	/**
	 * 退出应用程序
	 * 
	 * @param isBackground
	 *            是否保留后台运行。true保留，false停止虚拟机释放所有资源
	 */
	public void exitApp(Boolean isBackground) {
		mAppManager.exitApp(this, isBackground);
	}

	/**
	 * @return 获取应用的本地配置类
	 */
	public PreferenceConfig getConfig() {
		return this.config;
	}

	public HashMap<String, Object> getAppData() {
		return appData;
	}

	public void setAppData(HashMap<String, Object> appData) {
		this.appData = appData;
	}
	/**
	 * 获得Dalvik虚拟机的Java Object Heap的最大值。
	 * */
	public int getMemoryClass(Context context) {
		return ((ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
	}
}
