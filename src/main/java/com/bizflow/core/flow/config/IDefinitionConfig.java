package com.bizflow.core.flow.config;

import com.bizflow.core.definition.AbstractDefinition;

public interface IDefinitionConfig {

	String getDefineName();

	void setDefineName(String defineName);

	void fromAbstractDefinition(AbstractDefinition definition);

}