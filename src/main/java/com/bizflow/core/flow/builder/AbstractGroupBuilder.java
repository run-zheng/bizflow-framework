package com.bizflow.core.flow.builder;

import com.bizflow.core.execute.IInvoker;
import com.bizflow.core.flow.config.AbstractGroupConfig;
import com.bizflow.core.flow.config.ProcessorConfig;

/**
 * 暂时用jdk7， 使用jdk8的话，不用写那么多继承类^_^!
 * @author zhengrun 2016年7月22日
 *
 * @param <P>
 * @param <M>
 * @param <D>
 */
public class AbstractGroupBuilder<P, M extends AbstractGroupBuilder<P, M, D>, D extends AbstractGroupConfig> 
	extends AbstractExecutableBuilder<P, M, D>
	implements IGroupConfigBuilder<P, M, D>{

	@Override
	public M processorByDefineName(String defineName) {
		//TODO 
		return myself();
	}

	@Override
	public M processor(String name, String defineName) {
		//TODO 
		return myself();
	}

	@Override
	public M processor(String name, String defineName, String alias) {
		//TODO 
		return myself();
	}

	public <T> M processor(String name, IInvoker<T> invoker) {
		//TODO 
		return myself(); 
	}
	
	@Override
	public SimpleInvokableBuilder<M> invokableProcessor(String name) {
		//TODO
		return null;
	}

	@Override
	public <PM extends ProcessorBuilder<M, PM, ProcessorConfig>> 
		ProcessorBuilder<M, PM, ProcessorConfig> processor(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
