package com.bizflow.core.flow.config;

import java.io.Serializable;

/**
 * 抽象配置类
 * @author zhengrun 2016年7月5日
 *
 */
public class AbstractConfig implements Serializable, IConfig{
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
	
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.config.IConfig#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.config.IConfig#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.config.IConfig#setAlias(java.lang.String)
	 */
	@Override
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.config.IConfig#getAlias()
	 */
	@Override
	public String getAlias() {
		return alias;
	}
	
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.config.IConfig#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.config.IConfig#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	} 
}

