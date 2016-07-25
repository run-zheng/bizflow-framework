package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.ProcessorConfig;

public interface IProcessorBuilder<P, M extends IProcessorBuilder<P, M, D>, D extends ProcessorConfig> 
	extends IBuilder<P, M, D>{
	/**
	 * TODO 
	 */
}
