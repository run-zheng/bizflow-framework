package com.bizflow.common;

import java.util.concurrent.TimeUnit;

public class TimeOut {
	public static final TimeOut DEFAULT_TIMEOUT = new TimeOut(); 
	
	private long timeOut = 0; 
	private TimeUnit timeUnit = TimeUnit.SECONDS; 
	
	public TimeOut() {
	}
	public TimeOut(long timeOut){
		this(timeOut, TimeUnit.SECONDS);
	}
	
	public TimeOut(long timeOut, TimeUnit timeUnit){
		setTimeOut(timeOut);
		setTimeUnit(timeUnit);
	}
	
	
	
	public long getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(long timeOut) {
		this.timeOut = timeOut;
	}
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}
	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}
}
