package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.AbstractExecutableConfig;

public class AbstractExecutableBuilder<P, M, D extends AbstractExecutableConfig> 
	extends AbstractConfigBuilder<P, M, D>
	implements IExecutableConfigBuilder<P, M, D>{

	private SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> beforeBuilder;
	private SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> afterBuilder;
	private SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onCompleteBuilder;
	private SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onExceptionBuilder;
	private SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onFinallyBuilder;
	private SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> executerBuilder;
	

	private SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> simpleInvokableBuilder(String name){
		return SimpleInvokableBuilder.<IExecutableConfigBuilder<P, M, D>>createSimpleInvokableBuilder(this, name); 
	}
	@Override
	public M beforeByDefineName(String defineName) {
		before(defineName, defineName);
		return myself();
	}
	@Override
	public M afterByDefineName(String defineName) {
		after(defineName, defineName);
		return myself();
	}
	@Override
	public M onCompleteByDefineName(String defineName) {
		onComplete(defineName, defineName);
		return myself();
	}
	@Override
	public M onExceptionByDefineName(String defineName) {
		onException(defineName, defineName);
		return myself();
	}
	@Override
	public M onFinallyByDefineName(String defineName) {
		onFinally(defineName, defineName);
		return myself();
	}
	@Override
	public M executerByDefineName(String defineName) {
		executer(defineName, defineName);
		return myself();
	}
	@Override
	public M before(String name, String defineName) {
		this.beforeBuilder = simpleInvokableBuilder(name).defineName(defineName); 
		return myself();
	}
	@Override
	public M after(String name, String defineName) {
		this.afterBuilder = simpleInvokableBuilder(name).defineName(defineName);
		return myself();
	}
	@Override
	public M onComplete(String name, String defineName) {
		this.onCompleteBuilder = simpleInvokableBuilder(name).defineName(defineName	);
		return myself();
	}
	@Override
	public M onException(String name, String defineName) {
		this.onExceptionBuilder = simpleInvokableBuilder(name).defineName(defineName);
		return myself();
	}
	@Override
	public M onFinally(String name, String defineName) {
		this.onFinallyBuilder = simpleInvokableBuilder(name).defineName(defineName); 
		return myself();
	}
	@Override
	public M executer(String name, String defineName) {
		this.executerBuilder = simpleInvokableBuilder(name).defineName(defineName);
		return myself();
	}
	@Override
	public M before(String name, String defineName, String alias) {
		this.beforeBuilder = simpleInvokableBuilder(name).defineName(defineName).alias(alias);
		return myself();
	}
	@Override
	public M after(String name, String defineName, String alias) {
		this.afterBuilder  = simpleInvokableBuilder(name).defineName(defineName).alias(alias);
		return myself();
	}
	@Override
	public M onComplete(String name, String defineName, String alias) {
		this.onCompleteBuilder  = simpleInvokableBuilder(name).defineName(defineName).alias(alias);
		return myself();
	}
	@Override
	public M onException(String name, String defineName, String alias) {
		this.onExceptionBuilder  = simpleInvokableBuilder(name).defineName(defineName).alias(alias);
		return myself();
	}
	@Override
	public M onFinally(String name, String defineName, String alias) {
		this.onFinallyBuilder  = simpleInvokableBuilder(name).defineName(defineName).alias(alias);
		return myself();
	}
	@Override
	public M executer(String name, String defineName, String alias) {
		this.executerBuilder  = simpleInvokableBuilder(name).defineName(defineName).alias(alias);
		return myself();
	}
	@Override
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> before(String name) {
		this.beforeBuilder =  simpleInvokableBuilder(name);
		return this.beforeBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> after(String name) {
		this.afterBuilder = simpleInvokableBuilder(name);
		return this.afterBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onComplete(String name) {
		this.onCompleteBuilder = simpleInvokableBuilder(name);
		return this.onCompleteBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onException(String name) {
		this.onExceptionBuilder = simpleInvokableBuilder(name);
		return this.onExceptionBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onFinally(String name) {
		this.onFinallyBuilder = simpleInvokableBuilder(name);
		return this.onFinallyBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> executer(String name) {
		this.executerBuilder =  simpleInvokableBuilder(name);
		return this.executerBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> beforeBuilder() {
		return this.beforeBuilder;
	}
	@Override
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> afterBuilder() {
		return this.afterBuilder;
	}
	@Override
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onCompleteBuilder() {
		return this.onCompleteBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onExceptionBuilder() {
		return this.onExceptionBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> onFinallyBuilder() {
		return this.onFinallyBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<IExecutableConfigBuilder<P, M, D>> executerBuilder() {
		return this.executerBuilder; 
	}
}
