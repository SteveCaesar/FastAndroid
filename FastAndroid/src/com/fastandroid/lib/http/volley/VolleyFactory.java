package com.fastandroid.lib.http.volley;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;

import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.fastandroid.common.AndroidVersionUtils;
/**
 * @description 网络请求队列的生产工厂
 * @author 许友爻
 * @date 2014年6月17日 下午12:16:06
 * @version 1.0
 */
public class VolleyFactory{
	/**
	 * 创建一个默认的网络请求队列实例
	 * @param context 应用全局上下文对象
	 * @param diskCache 本地缓存
	 * @return A started {@link RequestQueue} instance.
	 */
	public static RequestQueue newRequestQueue(Context context,
			DiskBasedCache diskCache) {
		String userAgent = "volley/0";
		try {
			String packageName = context.getPackageName();
			PackageInfo info = context.getPackageManager().getPackageInfo(
					packageName, 0);
			userAgent = packageName + "/" + info.versionCode;
		} catch (NameNotFoundException e) {
		}
		HttpStack stack;
		if (AndroidVersionUtils.hasGingerbread()) {
			stack = new HurlStack();
		} else {
			// Prior to Gingerbread, HttpUrlConnection was unreliable.
			// See:
			// http://android-developers.blogspot.com/2011/09/androids-http-clients.html
			stack = new HttpClientStack(
					AndroidHttpClient.newInstance(userAgent));
		}

		Network network = new BasicNetwork(stack);
		
		RequestQueue queue = new RequestQueue(diskCache, network);
		queue.start();
		return queue;
	}
}
