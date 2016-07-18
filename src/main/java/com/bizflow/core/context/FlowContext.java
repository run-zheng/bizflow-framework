package com.bizflow.core.context;

import org.springframework.context.ApplicationContext;

public class FlowContext {
	private ApplicationContext context; 
	
	public ApplicationContext getSpringContext() {
		return context;
	}
	public void setSpringContext(ApplicationContext context) {
		this.context = context;
	}
}
