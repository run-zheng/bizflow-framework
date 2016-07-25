package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.IConfig;

public interface IConfigBuilder<P, M, D extends IConfig> extends IBuilder<P, M, D>{
	public String name(); 
	public M name(String name); 
	public M alias(String alias); 
	public M description(String description);
}
