package com.bizflow.core.definition;

import java.util.concurrent.TimeUnit;

import com.bizflow.common.TimeOut;
import com.bizflow.enums.Scope;

/**
 * 如果dataProvider提供了alias，那么alias作为返回值的对象缓存key， 
 * 如果没有，alias等于注解的value，alias=name
 * @author zhengrun 2016年6月30日
 *
 */
public class DataProviderDefinition extends AbstractDefinition{
	private Boolean isAsync = Boolean.FALSE; 
	private Scope scope = Scope.FLOW; 
	private TimeOut timeOut = TimeOut.DEFAULT_TIMEOUT; 
	private Boolean isGlobal = Boolean.FALSE; 
	
	
	public Boolean isGlobal(){
		return this.isGlobal; 
	}
	public void setIsGlobal(Boolean isGlobal) {
		this.isGlobal = isGlobal;
	}
	public Scope getScope() {
		return scope;
	}
	
	public void setScope(Scope scope) {
		this.scope = scope;
	}
	
	public TimeOut getTimeOut() {
		return timeOut;
	}
	
	public void setTimeOut(TimeOut timeOut) {
		this.timeOut = timeOut;
	}
	public void setTimeOut(long timeOut, TimeUnit timeUnit){
		TimeOut atimeOut = new TimeOut(); 
		atimeOut.setTimeOut(timeOut);
		atimeOut.setTimeUnit(timeUnit);
		this.setTimeOut(atimeOut);
	}
	public Boolean isAsync() {
		return isAsync;
	}
	public void setIsAsync(Boolean isAsync) {
		this.isAsync = isAsync;
	}
}
