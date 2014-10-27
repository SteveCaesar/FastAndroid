package com.fastandroid.exception;

/**
 * @description 低存储空间的异常
 * @author 许友爻
 * @date 2014年7月14日下午2:23:01
 * @version 1.0
 */
public class LowSpaceException extends RuntimeException {
	public LowSpaceException(String ex) {
		super(ex);
	}
}
