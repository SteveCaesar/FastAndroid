/**
 * 
 */
package com.example.demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;

import com.fastandroid.exception.AppException;
import com.fastandroid.exception.AppExceptionListener;
import com.fastandroid.lib.db.TASQLiteDatabasePool;
import com.fastandroid.lib.log.TALogger;
import com.fastandroid.lib.netstate.NetWorkUtil.NetType;

/**
 * @author 许友爻
 * @date 2014年6月23日 下午2:13:00
 * @version 1.0
 */
public class MyApplication extends com.fastandroid.MyApplication {
	private final String dbName="xionghaizi";
	private final int dbVersion=1;
	@Override
	protected void onConnect(NetType type) {
		TALogger.i(this, "手机接入网络.."+type.name());
	}

	@Override
	public void onDisConnect() {
		TALogger.i(this, "手机网络断开..");
	}

	@Override
	protected void onAfterCreateApplication() {
		TALogger.i(this, "onAfterCreateApplication");
		// 注册App异常崩溃处理器(由于里面有弹dialog所以得传activity)
		registerAppExceptionHandler();
	}

	/**
	 * 注册APP奔溃异常的处理器
	 * */
	private void registerAppExceptionHandler() {
		AppException appException = AppException.getInstance(this);
		appException.setAppExceptionListener(new AppExceptionListener() {
			@Override
			public boolean handleException(Throwable ex) {
				if (ex == null) {
					return true;
				}
				new Thread() {
					@Override
					public void run() {
						Looper.prepare();
						new AlertDialog.Builder(getAppManager().currentActivity())
								.setTitle("系统提示")
								.setCancelable(false)
								.setMessage("程序崩溃了...")
								.setPositiveButton("我知道了",
										new OnClickListener() {
											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {
												TALogger.d(this, "确定了");
												exitApp(false);
											}
										}).create().show();
						Looper.loop();
					}
				}.start();
				return true;
			}
		});
		// 注册App异常崩溃处理器
		Thread.setDefaultUncaughtExceptionHandler(appException);
	}
	
	public TASQLiteDatabasePool getSQLiteDatabasePool() {
		return super.getSQLiteDatabasePool(dbName, dbVersion,false);
	}
}
