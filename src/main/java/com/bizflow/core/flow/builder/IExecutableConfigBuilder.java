package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.AbstractExecutableConfig;

public interface IExecutableConfigBuilder<P, M, D extends AbstractExecutableConfig> {
	public M beforeByDefineName(String defineName); 
	public M afterByDefineName(String defineName); 
	public M onCompleteByDefineName(String defineName); 
	public M onExceptionByDefineName(String defineName); 
	public M onFinallyByDefineName(String defineName); 
	public M executerByDefineName(String defineName); 
	
	public M before(String name, String defineName); 
	public M after(String name, String defineName);
	public M onComplete(String name, String defineName);
	public M onException(String name, String defineName); 
	public M onFinally(String name, String defineName); 
	public M executer(String name, String defineName);
	
	public M before(String name, String defineName, String alias); 
	public M after(String name, String defineName, String alias);
	public M onComplete(String name, String defineName, String alias);
	public M onException(String name, String defineName, String alias); 
	public M onFinally(String name, String defineName, String alias); 
	public M executer(String name, String defineName, String alias);
	
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> before(String name); 
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> after(String name);
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onComplete(String name);
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onException(String name); 
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onFinally(String name); 
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> executer(String name);

	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> beforeBuilder(); 
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> afterBuilder(); 
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onCompleteBuilder(); 
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onExceptionBuilder();  
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onFinallyBuilder();  
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> executerBuilder(); 
}
