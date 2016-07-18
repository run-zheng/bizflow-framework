package com.bizflow.core.definition;

public class ProcessorDefinition extends AbstractDefinition{
	private Boolean async = Boolean.FALSE; 
	private Boolean bizHandler = Boolean.FALSE; 
	private String flowName; 
	
	public void setBizHandler(Boolean bizHandler) {
		this.bizHandler = bizHandler;
	}
	
	public Boolean isBizHandler(){
		return this.bizHandler; 
	}
	
	public String getFlowName() {
		return flowName;
	}
	
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	
	public void setAsync(Boolean async) {
		this.async = async;
	}
	
	public Boolean isAsync(){
		return this.async; 
	}
	
}
