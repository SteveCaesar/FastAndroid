package com.fastandroid.lib.netstate;

import com.fastandroid.lib.netstate.NetWorkUtil.NetType;

/**
 * @Description 是检测网络改变的观察者
 * @author 许友爻
 * @date 2014年6月12日
 * @version 1.0
 */
public interface NetChangeObserver {
	/**
	 * 网络连接连接时调用
	 */
	public void onConnect(NetType type);

	/**
	 * 断开网络连接时调用
	 */
	public void onDisConnect();
}
