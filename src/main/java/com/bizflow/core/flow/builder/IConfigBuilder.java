package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.AbstractConfig;

public interface IConfigBuilder<P, M, D extends AbstractConfig> {
	public String name(); 
	public M name(String name); 
	public M alias(String alias); 
	public M description(String description);
}
