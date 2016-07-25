package com.bizflow.core.flow.builder;

import com.bizflow.core.definition.AbstractDefinition;

public interface IDefinitionConfigBuilder<P, M, D> extends IBuilder<P, M, D>{
	public M defineName(String defineName); 
	public M fromAbstractDefinition(AbstractDefinition definition); 

}
