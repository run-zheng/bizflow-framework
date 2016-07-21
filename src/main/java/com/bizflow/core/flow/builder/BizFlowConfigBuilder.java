package com.bizflow.core.flow.builder;

import com.bizflow.core.execute.IInvoker;
import com.bizflow.core.flow.config.AbstractGroupConfig;
import com.bizflow.core.flow.config.BizFlowConfig;

public class BizFlowConfigBuilder extends AbstractConfigBuilder<BizFlowConfigBuilder, BizFlowConfigBuilder, BizFlowConfig>{

	public BizFlowConfigBuilder(String flowName) {
		myself(this); 
		data(new BizFlowConfig());
		name(flowName); 
	}

	public BizFlowConfigBuilder dataProvider(String providerName, String defineName) {
		dataProvider(providerName)
			.defineName(defineName);
		return  myself();
	}

	public BizFlowConfigBuilder dataProvider(String providerName, String defineName, String alias) {
		dataProvider(providerName)
			.defineName(defineName)
			.alias(alias);
		return myself();
	}

	public <T> BizFlowConfigBuilder dataProvider(String providerName, IInvoker<T> invoker) {
		dataProvider(providerName)
			.invoker(invoker);
		return myself();
	}

	public DataProviderBuilder dataProvider(String providerName) {
		return DataProviderBuilder.createBuilder(this, providerName);
	}

	public BizFlowConfigBuilder dataProviderByDefineName(String defineName) {
		dataProvider(defineName, defineName);
		return myself(); 
	}

	BizFlowConfigBuilder addDataProviderBuilder(DataProviderBuilder dataProviderBuilder){
		//TODO 添加DataProviderBuilder 
		return myself(); 
	}

	public AbstractGroupBuilder<BizFlowConfigBuilder, AbstractGroupBuilder<?, ?, ?>, AbstractGroupConfig> processors() {
		// 默认sequence processor group 
		return null;
	}

	public AbstractGroupBuilder<BizFlowConfigBuilder,  AbstractGroupBuilder<?, ?, ?>, AbstractGroupConfig> processors(String string) {
		// 默认sequence processor group
		return null;
	}
}
