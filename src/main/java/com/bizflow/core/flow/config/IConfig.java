package com.bizflow.core.flow.config;

public interface IConfig {

	String getName();

	void setName(String name);

	void setAlias(String alias);

	String getAlias();

	String getDescription();

	void setDescription(String description);

}