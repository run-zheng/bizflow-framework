package com.bizflow.exception;

public class ConfigException extends AbstractException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1577729720345604829L;

	public ConfigException() {
		super(); 
	}
	
	public ConfigException(String message){
		super(message); 
	}
	
	public ConfigException(String message, Throwable throwable){
		super(message, throwable); 
	}
	
	public ConfigException(Throwable throwable){
		super(throwable); 
	}
}
