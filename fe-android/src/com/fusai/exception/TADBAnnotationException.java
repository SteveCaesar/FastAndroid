package com.fusai.exception;
/**数据库注解错误*/
public class TADBAnnotationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TADBAnnotationException() {
		super();
	}

	public TADBAnnotationException(String detailMessage) {
		super(detailMessage);
	}
}
