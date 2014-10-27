package com.fusai.exception;
/**
 * @description App全局异常监听器
 * @author 许友爻
 * @date 2014年7月14日下午2:13:01
 * @version 1.0
 */
public interface AppExceptionListener {
	/**
	 * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成. 开发者可以根据自己的情况来自定义异常处理逻辑
	 * @return true:如果处理了该异常信息;否则返回false
	 * */
	boolean handleException(Throwable ex);
}
