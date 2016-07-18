package com.bizflow.exception;

public class RegisterException extends AbstractException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3261976232104520944L;

	public RegisterException() {
		super(); 
	}
	
	public RegisterException(String message){
		super(message); 
	}
	
	public RegisterException(String message, Throwable throwable){
		super(message, throwable); 
	}
	
	public RegisterException(Throwable throwable){
		super(throwable); 
	}
}
