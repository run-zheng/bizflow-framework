package com.bizflow.core.flow;

import java.util.Map;

import org.springframework.util.Assert;

import com.bizflow.core.definition.BizFlowDefinition;
import com.bizflow.exception.RegisterException;
import com.google.common.collect.Maps;

/**
 * 流程配置定义注册中心
 * @author zhengrun 2016年7月5日
 *
 */
public class BizFlowDefinitionRegistry {
	private Map<String, BizFlowDefinition> bizFlowBuilderMap = Maps.newConcurrentMap(); 
	public void registerBizFlowDefinition(BizFlowDefinition definition) {
		Assert.notNull(definition);
		if(bizFlowBuilderMap.containsKey(definition.getName())){
			throw new RegisterException("Already have Biz Flow Builder named "
					+ definition.getName() 
					+ " in  registry"); 
		}
		this.bizFlowBuilderMap.put(definition.getName(), definition); 
	}
	
	public BizFlowDefinition getBizFlowDefinition(String name){
		return this.bizFlowBuilderMap.get(name);
	}

}
