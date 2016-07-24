package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.AbstractExecutableConfig;

public class AbstractExecutableBuilder<P, M extends AbstractExecutableBuilder<P, M, D>, D extends AbstractExecutableConfig> 
	extends AbstractConfigBuilder<P, M, D>
	implements IExecutableConfigBuilder<P, M, D>{

	private SimpleInvokableBuilder<M> beforeBuilder;
	private SimpleInvokableBuilder<M> afterBuilder;
	private SimpleInvokableBuilder<M> onCompleteBuilder;
	private SimpleInvokableBuilder<M> onExceptionBuilder;
	private SimpleInvokableBuilder<M> onFinallyBuilder;
	private SimpleInvokableBuilder<M> executerBuilder;
	

	@SuppressWarnings("unchecked")
	private SimpleInvokableBuilder<M> simpleInvokableBuilder(String name){
		return SimpleInvokableBuilder.createSimpleInvokableBuilder((M)this, name); 
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
	public M customExecuterByDefineName(String defineName) {
		customExecuter(defineName, defineName);
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
	public M customExecuter(String name, String defineName) {
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
	public M customExecuter(String name, String defineName, String alias) {
		this.executerBuilder  = simpleInvokableBuilder(name).defineName(defineName).alias(alias);
		return myself();
	}
	@Override
	public SimpleInvokableBuilder<M> before(String name) {
		this.beforeBuilder =  simpleInvokableBuilder(name);
		return this.beforeBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<M> after(String name) {
		this.afterBuilder = simpleInvokableBuilder(name);
		return this.afterBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<M> onComplete(String name) {
		this.onCompleteBuilder = simpleInvokableBuilder(name);
		return this.onCompleteBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<M> onException(String name) {
		this.onExceptionBuilder = simpleInvokableBuilder(name);
		return this.onExceptionBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<M> onFinally(String name) {
		this.onFinallyBuilder = simpleInvokableBuilder(name);
		return this.onFinallyBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<M> customExecuter(String name) {
		this.executerBuilder =  simpleInvokableBuilder(name);
		return this.executerBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<M> beforeBuilder() {
		return this.beforeBuilder;
	}
	@Override
	public SimpleInvokableBuilder<M> afterBuilder() {
		return this.afterBuilder;
	}
	@Override
	public SimpleInvokableBuilder<M> onCompleteBuilder() {
		return this.onCompleteBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<M> onExceptionBuilder() {
		return this.onExceptionBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<M> onFinallyBuilder() {
		return this.onFinallyBuilder; 
	}
	@Override
	public SimpleInvokableBuilder<M> customExecuterBuilder() {
		return this.executerBuilder; 
	}
}
