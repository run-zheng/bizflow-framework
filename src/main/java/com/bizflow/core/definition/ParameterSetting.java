package com.bizflow.core.definition;
/**
 * 参数查找顺序annotatedName > type > name 
 * name = 方法上的参数名称，如果优化编译，可能获取到的是argX形式的名称
 * 
 * 在jdk7中无法获取到参数名称，目前版本，暂时不实现参数名称功能，默认等于annotatedName, 
 * 如果没有等于type的类短名称
 * 
 * annotatedName存在，直接注入，不做autoInject
 *  
 * @author zhengrun 2016年6月27日
 *
 */
public class ParameterSetting {
	private int index; 
	private String name; 
	private boolean require; 
	private Class<?> type; 
	private String annotatedName;
	private boolean autoInject; 
	
	public boolean isAutoInject() {
		return autoInject;
	}
	
	public void setAutoInject(boolean autoInject) {
		this.autoInject = autoInject;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isRequire() {
		return require;
	}
	public void setRequire(boolean require) {
		this.require = require;
	}
	public Class<?> getType() {
		return type;
	}
	public void setType(Class<?> type) {
		this.type = type;
	}
	public String getAnnotatedName() {
		return annotatedName;
	}
	public void setAnnotatedName(String annotatedName) {
		this.annotatedName = annotatedName;
	} 
}
