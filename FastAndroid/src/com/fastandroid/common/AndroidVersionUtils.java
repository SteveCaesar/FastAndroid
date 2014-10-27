package com.fastandroid.common;

import android.os.Build;
/**
 * @Description android版本检测工具
 * @author 许友爻
 * @date 2014年7月14日下午3:59:21
 * @version 1.0
 */
public class AndroidVersionUtils {
	/**
	 * 判断当前android版本是否是2.2以上(包含2.2本身)
	 * 
	 * @return 如果是返回true，如果不是返回false
	 * */
	public static boolean hasFroyo() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
	}

	/**
	 * 判断当前android版本是否是2.3以上(包含2.3本身)
	 * 
	 * @return 如果是返回true，如果不是返回false
	 * */
	public static boolean hasGingerbread() {
		return Build.VERSION.SDK_INT >= 9;
	}

	/**
	 * 判断当前android版本是否是3.0以上(包含3.0本身)
	 * 
	 * @return 如果是返回true，如果不是返回false
	 * */
	public static boolean hasHoneycomb() {
		return Build.VERSION.SDK_INT >= 11;
	}

	/**
	 * 判断当前android版本是否是3.1以上(包含3.1本身)
	 * 
	 * @return 如果是返回true，如果不是返回false
	 * */
	public static boolean hasHoneycombMR1() {
		return Build.VERSION.SDK_INT >= 12;
	}

	/**
	 * 判断当前android版本是否是4.1以上(包含4.1本身)
	 * 
	 * @return 如果是返回true，如果不是返回false
	 * */
	public static boolean hasJellyBean() {
		return Build.VERSION.SDK_INT >= 16;
	}

	/**
	 * 判断当前android版本是否是4.4以上(包含4.4本身)
	 * 
	 * @return 如果是返回true，如果不是返回false
	 * */
	public static boolean hasKitKat() {
		return Build.VERSION.SDK_INT >= 19;
	}
}
