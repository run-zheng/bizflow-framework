package com.bizflow.core.processor;

import java.util.Map;

import org.springframework.util.Assert;

import com.bizflow.core.definition.ProcessorDefinition;
import com.bizflow.exception.RegisterException;
import com.google.common.collect.Maps;

public class ProcessorRegistry {
	private Map<String, ProcessorDefinition> processorDefinitionMap = Maps.newConcurrentMap();
	private Map<String, ProcessorDefinition> bizeHandlerMap = Maps.newConcurrentMap(); 
	
	public boolean registerProcessor(ProcessorDefinition processorDefinition){
		Assert.notNull(processorDefinition);
		if(processorDefinitionMap.containsKey(processorDefinition.getName())){
			throw new RegisterException("Already have processor named "
					+ processorDefinition.getName() 
					+ " in  registry"); 
		}
		this.processorDefinitionMap.put(processorDefinition.getName(), processorDefinition);
		if(processorDefinition.isBizHandler()){
			bizeHandlerMap.put(processorDefinition.getName(), processorDefinition); 
		}
		return true; 
	}
	
	public ProcessorDefinition getProcessorDefinition(String name){
		return this.processorDefinitionMap.get(name);
	}
}
