package com.bizflow.core.data;

import java.util.Map;

import org.springframework.util.Assert;

import com.bizflow.core.definition.DataProviderDefinition;
import com.bizflow.exception.RegisterException;
import com.google.common.collect.Maps;

public class DataProviderRegistry {
	private Map<String, DataProviderDefinition> globalProviderRegistry = Maps.newConcurrentMap(); 
	private Map<String, DataProviderDefinition> flowProviderRegistry = Maps.newConcurrentMap(); 
	
	public boolean registerProvider(DataProviderDefinition definition){
		Assert.notNull(definition);
		if(definition.isGlobal()){
			checkAndRegisterDefinition(definition, globalProviderRegistry, "globel");
		}else {
			checkAndRegisterDefinition(definition, flowProviderRegistry, "flow");
		}
		return true; 
	}

	private void checkAndRegisterDefinition(DataProviderDefinition definition,
			Map<String, DataProviderDefinition> registry, String type) {
		checkNameInRegistry(registry, definition.getName(), type);
		registry.put(definition.getName(), definition); 
		if(!definition.getName().equals(definition.getAlias())){
			checkNameInRegistry(registry, definition.getAlias(), type);
			registry.put(definition.getAlias(), definition); 
		}
	}

	private void checkNameInRegistry(Map<String, DataProviderDefinition> registry, String name, String type) {
		if(registry.containsKey(name)){
			throw new RegisterException("Already have a provider named "
				+ name 
				+ " in "+type+" provider registry"); 
		}
	}
	
	public int getAllProviderCount(){
		return this.globalProviderRegistry.size() + this.flowProviderRegistry.size(); 
	}
	
	public int getGlobalProviderCount(){
		return this.globalProviderRegistry.size(); 
	}
	
	public int getFlowProviderRgistry(){
		return this.flowProviderRegistry.size(); 
	}

	public DataProviderDefinition getProviderDefinition(String name) {
		if(this.flowProviderRegistry.get(name) != null){
			return this.flowProviderRegistry.get(name); 
		}
		return this.globalProviderRegistry.get(name);
	}
}
