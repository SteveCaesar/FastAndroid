package com.fastandroid.lib.log;

/**
 * @description 是一个日志的接口
 * @author 许友爻
 * @date 2014年6月18日 下午1:41:46
 * @version 1.0
 */
public interface ILogger
{
	void v(String tag, String message);

	void d(String tag, String message);

	void i(String tag, String message);

	void w(String tag, String message);

	void e(String tag, String message);

	void open();

	void close();

	void println(int priority, String tag, String message);
}
