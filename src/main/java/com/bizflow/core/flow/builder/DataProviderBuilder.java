package com.bizflow.core.flow.builder;

import java.util.concurrent.TimeUnit;

import org.springframework.util.Assert;

import com.bizflow.core.execute.IInvoker;
import com.bizflow.core.flow.config.DataProviderConfig;
import com.bizflow.enums.Scope;

public class DataProviderBuilder extends AbstractDefinitionInvokableBuilder<BizFlowConfigBuilder, DataProviderBuilder, DataProviderConfig>{
	
	public static DataProviderBuilder createBuilder(BizFlowConfigBuilder parentBuilder,String name){
		Assert.notNull(parentBuilder);
		Assert.notNull(name);
		return new DataProviderBuilder(parentBuilder, name); 
	}
	public DataProviderBuilder(BizFlowConfigBuilder parentBuilder, String providerName) {
		parentBuilder(parentBuilder); 
		data(new DataProviderConfig());
		name(providerName);
		data().setLazy(Boolean.TRUE); 
	}
	
	public DataProviderBuilder lazy(Boolean isLazy){
		data().setLazy(isLazy); 
		return myself(); 
	}

	@Override
	public BizFlowConfigBuilder end() {
		BizFlowConfigBuilder bizFlowConfigBuilder = super.end();
		return bizFlowConfigBuilder.addDataProviderBuilder(this);
	}


	public <T> DataProviderBuilder provider(IInvoker<T> invoker) {
		invoker(invoker);
		return myself(); 
	}


	public DataProviderBuilder asyc() {
		data().asyc(); 
		return myself();
	}


	public DataProviderBuilder asyc(Boolean asyc) {
		data().setAsyc(asyc);
		return myself();
	}


	public DataProviderBuilder scope(Scope scope) {
		data().setScope(scope);
		return myself();
	}


	public DataProviderBuilder timeOut(long timeOut, TimeUnit timeUnit) {
		data().setTimeOut(timeOut, timeUnit);
		return myself();
	}
	
	public DataProviderBuilder timeOut(long timeOut) {
		data().setTimeOut(timeOut);
		return myself();
	}


	public DataProviderBuilder global() {
		data().global();
		return myself();
	}
	
	public DataProviderBuilder global(Boolean global) {
		data().setGlobal(global);
		return myself();
	}
}
