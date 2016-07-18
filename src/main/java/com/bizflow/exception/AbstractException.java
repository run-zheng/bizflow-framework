package com.bizflow.exception;

public class AbstractException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 757960708682930928L;

	public AbstractException() {
		super(); 
	}
	
	public AbstractException(String message){
		super(message); 
	}
	
	public AbstractException(String message, Throwable throwable){
		super(message, throwable); 
	}
	
	public AbstractException(Throwable throwable){
		super(throwable); 
	}
	
	@Override
	public synchronized Throwable fillInStackTrace() {
		return super.fillInStackTrace();
		//return this; 
	}

}
