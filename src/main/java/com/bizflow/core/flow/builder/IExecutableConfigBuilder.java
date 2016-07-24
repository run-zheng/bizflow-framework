package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.AbstractExecutableConfig;

public interface IExecutableConfigBuilder<P, M extends IExecutableConfigBuilder<P, M, D>, D extends AbstractExecutableConfig> {
	public M beforeByDefineName(String defineName); 
	public M afterByDefineName(String defineName); 
	public M onCompleteByDefineName(String defineName); 
	public M onExceptionByDefineName(String defineName); 
	public M onFinallyByDefineName(String defineName); 
	public M customExecuterByDefineName(String defineName); 
	
	public M before(String name, String defineName); 
	public M after(String name, String defineName);
	public M onComplete(String name, String defineName);
	public M onException(String name, String defineName); 
	public M onFinally(String name, String defineName); 
	public M customExecuter(String name, String defineName);
	
	public M before(String name, String defineName, String alias); 
	public M after(String name, String defineName, String alias);
	public M onComplete(String name, String defineName, String alias);
	public M onException(String name, String defineName, String alias); 
	public M onFinally(String name, String defineName, String alias); 
	public M customExecuter(String name, String defineName, String alias);
	
	public SimpleInvokableBuilder<M> before(String name); 
	public SimpleInvokableBuilder<M> after(String name);
	public SimpleInvokableBuilder<M> onComplete(String name);
	public SimpleInvokableBuilder<M> onException(String name); 
	public SimpleInvokableBuilder<M> onFinally(String name); 
	public SimpleInvokableBuilder<M> customExecuter(String name);

	public SimpleInvokableBuilder<M> beforeBuilder(); 
	public SimpleInvokableBuilder<M> afterBuilder(); 
	public SimpleInvokableBuilder<M> onCompleteBuilder(); 
	public SimpleInvokableBuilder<M> onExceptionBuilder();  
	public SimpleInvokableBuilder<M> onFinallyBuilder();  
	public SimpleInvokableBuilder<M> customExecuterBuilder(); 
}
