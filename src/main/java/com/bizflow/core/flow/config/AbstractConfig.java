package com.bizflow.core.flow.config;

import java.io.Serializable;

/**
 * 抽象配置类
 * @author zhengrun 2016年7月5日
 *
 */
public class AbstractConfig implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4595304463367381389L;
	/**
	 * 配置名称，如果有对应的definition，默认与definition的name对应， 
	 *  如果设置了defineName, 那么name可以不予definition的name对应
	 */
	private String name; 
	
	/**
	 * 用于显示的名称，默认等于definition的alias,如果没有definition，默认等于name
	 */
	private String alias; 
	
	/**
	 * 描述
	 */
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getAlias() {
		return alias;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
}

