package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.AbstractConfig;

public abstract class AbstractConfigBuilder<P, M, D extends AbstractConfig> extends AbstractBuilder<P, M, D> implements IConfigBuilder<P, M, D>{
	@Override
	public String name() {
		return this.data().getName(); 
	}
	
	@Override
	public M alias(String alias) {
		this.data().setAlias(alias);
		return myself();
	}
	
	@Override
	public M name(String name) {
		this.data().setName(name);
		return myself(); 
	}
	
	@Override
	public M description(String description) {
		this.data().setDescription(description);
		return myself(); 
	}
	
	
}
