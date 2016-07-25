package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.AbstractGroupConfig;
import com.bizflow.core.flow.config.ProcessorConfig;

public interface IGroupConfigBuilder<P, M extends IGroupConfigBuilder<P, M, D>, D extends AbstractGroupConfig> 
	extends IBuilder<P, M, D>{
	public M processorByDefineName(String defineName); 
	public M processor(String name, String defineName); 
	public M processor(String name, String defineName, String alias); 
	
	public SimpleInvokableBuilder<M> invokableProcessor(String name); 
	public <PM extends ProcessorBuilder<M, PM, ProcessorConfig>>
		ProcessorBuilder<M, PM, ProcessorConfig> processor(String name);
	
	/**
	 * TODO 
	 */
	//sendMessageProcessor();
	//receiveMessageProcessor(); 
	//syncReceiveMessageProcessor(); 
	//httpProcessor() 
	
	//sequenceProcessorGroup(); 
	//parellalProcessorGroup(); 
	//alternateProcessorGroup(); 
	//subFlow(); 
	//subFlowBuilder();
}
