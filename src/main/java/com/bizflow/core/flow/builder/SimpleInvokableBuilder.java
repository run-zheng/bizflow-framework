package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.SimpleInvokableConfig;

public class SimpleInvokableBuilder<P> extends AbstractDefinitionInvokableBuilder<P, SimpleInvokableBuilder<P>, SimpleInvokableConfig>{
	
	public static <P> SimpleInvokableBuilder<P> createSimpleInvokableBuilder(P parent, String name){
		return new SimpleInvokableBuilder<P>(parent, name);
	}
	
	public SimpleInvokableBuilder(P parent, String name) {
		parentBuilder(parent);
		data(new SimpleInvokableConfig()); 
		name(name);
	}
}
