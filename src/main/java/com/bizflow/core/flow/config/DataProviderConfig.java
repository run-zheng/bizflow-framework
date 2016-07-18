package com.bizflow.core.flow.config;

import java.util.concurrent.TimeUnit;

import com.bizflow.common.TimeOut;
import com.bizflow.enums.Scope;

public class DataProviderConfig extends AbstractDefinitionInvokableConfig{

	/**
	 * 
	 */
	private static final long serialVersionUID = 987283486894705754L;
	private Boolean lazy = Boolean.TRUE; 
	private Scope scope = Scope.FLOW;
	private Boolean async = Boolean.FALSE; 
	private TimeOut timeOut = TimeOut.DEFAULT_TIMEOUT; 
	private Boolean global = Boolean.FALSE; 
	
	public void setScope(Scope scope){
		this.scope = scope; 
	}
	public Scope getScope() {
		return scope;
	}
	
	public void setLazy(Boolean isLazy) {
		this.lazy = isLazy; 
	} 
	public void lazy(){
		this.lazy = Boolean.TRUE; 
	}
	
	public Boolean isLazy(){
		return this.lazy; 
	}

	public void asyc() {
		this.async = Boolean.TRUE; 
	}
	
	public void setAsyc(Boolean asyc){
		this.async = asyc; 
	}
	public Boolean isAsync(){
		return this.async; 
	}
	
	public TimeOut getTimeOut() {
		return timeOut;
	}
	
	public void setTimeOut(TimeOut timeOut) {
		this.timeOut = timeOut;
	}
	
	public void global(){
		this.global = Boolean.TRUE; 
	}
	
	public Boolean isGlobal(){
		return this.global; 
	}
	
	public void setGlobal(Boolean global){
		this.global = global; 
	}
	
	public void setTimeOut(long timeOut, TimeUnit timeUnit) {
		setTimeOut(new TimeOut(timeOut, timeUnit));
	}
	
	public void setTimeOut(long timeOut) {
		setTimeOut(new TimeOut(timeOut));
	}
	
}
