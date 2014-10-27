package com.fastandroid;

import java.util.Stack;

import com.fastandroid.lib.log.TALogger;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
/**
 * @Description app管理类
 * @author 许友爻
 * @date 2014年6月13日 下午4:25:13
 * @version 1.0
 */
public class TAAppManager {
	private static TAAppManager instance;
	private Stack<Activity> activityStack;

	private TAAppManager() {
		activityStack = new Stack<Activity>();
	}

	/**
	 * 获取单一实例
	 */
	public static TAAppManager getAppManager() {
		if (instance == null) {
			instance = new TAAppManager();
		}
		return instance;
	}
	/**
	 * 销毁单一实例
	 * */
	public void destroyInstance(){
		finishAllActivity();
		activityStack=null;
		instance=null;
	}

	/**
	 * 添加Activity到堆栈
	 */
	public void addActivity(Activity activity) {
		activityStack.add(activity);
	}

	/**
	 * 获取当前Activity（堆栈中最后一个压入的）
	 */
	public Activity currentActivity() {
		Activity activity = activityStack.lastElement();
		return activity;
	}

	/**
	 * 结束当前Activity（堆栈中最后一个压入的）
	 */
	public void finishCurrentActivity() {
		Activity activity = activityStack.lastElement();
		finishActivity(activity);
	}

	/**
	 * 结束指定的Activity
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 移除指定的Activity
	 */
	public void removeActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity = null;
		}
	}

	/**
	 * 结束指定类名的Activity
	 */
	public void finishActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	/**
	 * 结束所有Activity
	 */
	public void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				activityStack.get(i).finish();
			}
		}
		activityStack.clear();
	}

	/**
	 * 退出应用程序
	 * 
	 * @param context
	 *            上下文
	 * @param isBackground
	 *            是否保留后台运行。true保留，false停止虚拟机释放所有资源
	 */
	public void exitApp(Context context, Boolean isBackground) {
		try {
			finishAllActivity();
			ActivityManager activityMgr = (ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE);
			activityMgr.killBackgroundProcesses(context.getPackageName());
		} catch (Exception e) {
			TALogger.e(TAAppManager.this, e.getMessage());
		} finally {
			// 注意，如果您有后台程序运行，请不要支持此句子
			if (!isBackground) {
				System.exit(0);
			}
		}
	}
}