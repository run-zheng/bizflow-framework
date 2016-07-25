package com.bizflow.core.flow.config;

import com.bizflow.core.definition.AbstractDefinition;
import com.bizflow.core.execute.IInvokable;

public class ProcessorConfig extends AbstractExecutableConfig implements IDefinitionInvokableConfig{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7116423383616543020L;
	
	private SimpleInvokableConfig simpleInvokableConfig = new SimpleInvokableConfig();

	@Override
	public String getDefineName() {
		return simpleInvokableConfig.getDefineName();
	}

	@Override
	public void setDefineName(String defineName) {
		this.simpleInvokableConfig.setDefineName(defineName);
	}

	@Override
	public void fromAbstractDefinition(AbstractDefinition definition) {
		this.simpleInvokableConfig.fromAbstractDefinition(definition);
	}

	@Override
	public IInvokable<?> getInvoker() {
		return this.simpleInvokableConfig.getInvoker(); 
	}

	@Override
	public void setInvoker(IInvokable<?> invoker) {
		this.simpleInvokableConfig.setInvoker(invoker);
	} 
	
	
	/**
	 * TODO 
	 */
}
