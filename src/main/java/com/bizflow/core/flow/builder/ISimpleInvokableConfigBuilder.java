package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.AbstractDefinitionInvokableConfig;

public interface ISimpleInvokableConfigBuilder<P, M, D extends AbstractDefinitionInvokableConfig> 
	extends IConfigBuilder<P, M, D>, 
		IDefinitionConfigBuilder<P, M, D>, 
		IInvokerConfigBuilder<P, M, D>{
	
}
