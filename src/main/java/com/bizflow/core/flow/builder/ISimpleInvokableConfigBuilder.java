package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.IDefinitionInvokableConfig;

public interface ISimpleInvokableConfigBuilder<P, M, D extends IDefinitionInvokableConfig> 
	extends IConfigBuilder<P, M, D>, 
		IDefinitionConfigBuilder<P, M, D>, 
		IInvokerConfigBuilder<P, M, D>{
	
}
