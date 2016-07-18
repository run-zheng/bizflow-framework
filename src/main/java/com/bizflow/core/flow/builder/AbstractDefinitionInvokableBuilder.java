package com.bizflow.core.flow.builder;

import org.springframework.util.Assert;

import com.bizflow.core.definition.AbstractDefinition;
import com.bizflow.core.execute.IInvokable;
import com.bizflow.core.flow.config.AbstractDefinitionInvokableConfig;

public class AbstractDefinitionInvokableBuilder<P, M, D extends AbstractDefinitionInvokableConfig> 
	extends AbstractConfigBuilder<P, M, D> 
	implements IDefinitionConfigBuilder<P, M, D>, IInvokerConfigBuilder<P, M, D>{
	
	public <T> M invoker(IInvokable<T> invoker) {
		data().setInvoker(invoker); 
		return myself();
	}
	
	public M defineName(String defineName){
		Assert.notNull(defineName);
		data().setDefineName(defineName);
		return myself(); 
	}
	
	public M fromAbstractDefinition(AbstractDefinition definition){
		Assert.notNull(definition);	
		data().fromAbstractDefinition(definition);
		return myself(); 
	}
}
