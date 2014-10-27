package com.fastandroid.exception;

import java.lang.Thread.UncaughtExceptionHandler;

import android.content.Context;

import com.fastandroid.MyApplication;

/**
 * @description App全局异常对象，可以设置异常监听器，没有设置则执行默认处理行为。
 * @author 许友爻
 * @date 2014年7月14日下午2:13:01
 * @version 1.0
 */
public class AppException implements UncaughtExceptionHandler {
	public static final String TAG = "CrashHandler";
	private static AppException instance;
	private Context mContext;
	private Thread.UncaughtExceptionHandler mDefaultHandler;
	private AppExceptionListener appExceptionListener;

	private AppException(Context context) {
		init(context);
	}

	/**
	 * 获取单例对象
	 * */
	public static AppException getInstance(Context context) {
		if (instance == null) {
			instance = new AppException(context);
		}
		return instance;
	}

	/**
	 * 单例对象内部引用赋值为null，让GC去回收
	 * */
	public static void dstroyInstance() {
		instance = null;
	}

	private void init(Context context) {
		mContext = context;
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		if (appExceptionListener != null) {
			if (!appExceptionListener.handleException(ex)) {
				if (mDefaultHandler != null) {
					mDefaultHandler.uncaughtException(thread, ex);
				} else {
					((MyApplication) (MyApplication.getApplication())).exitApp(false);
				}
			}
		} else if (mDefaultHandler != null) {
			mDefaultHandler.uncaughtException(thread, ex);
		} else {
			((MyApplication) (MyApplication.getApplication())).exitApp(false);
		}
	}

	/**
	 * 获取处理异常的监听器
	 * 
	 * @return 返回处理异常的对象，不存在返回null
	 * */
	public AppExceptionListener getAppExceptionListener() {
		return appExceptionListener;
	}

	/**
	 * 设置处理异常的监听器
	 * */
	public void setAppExceptionListener(
			AppExceptionListener handleExceptionListener) {
		this.appExceptionListener = handleExceptionListener;
	}

}
