package com.cai.mall.exception;

public class MallException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MallException() {
		
	}
	
	public MallException(String msg) {
		super(msg);
	}
}
