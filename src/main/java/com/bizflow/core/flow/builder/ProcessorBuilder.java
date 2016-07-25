package com.bizflow.core.flow.builder;

import com.bizflow.core.definition.AbstractDefinition;
import com.bizflow.core.execute.IInvokable;
import com.bizflow.core.flow.config.ProcessorConfig;

public class ProcessorBuilder<P, M extends ProcessorBuilder<P, M, D>, D extends ProcessorConfig> 
	extends AbstractExecutableBuilder<P, M, D>
	implements IProcessorBuilder<P, M, D>, ISimpleInvokableConfigBuilder<P, M, D> {

	@Override
	public M defineName(String defineName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public M fromAbstractDefinition(AbstractDefinition definition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> M invoker(IInvokable<T> invoker) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * TODO 
	 */
}
