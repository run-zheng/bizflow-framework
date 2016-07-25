package com.bizflow.core.flow.builder;

public abstract class AbstractBuilder<P, M, D> implements IBuilder<P, M, D> {
	private P parentBuilder; 
	private M myself; 
	private D data; 
	
	protected M myself(M myself){
		this.myself = myself; 
		return this.myself; 
	}

	protected M myself(){
		return myself; 
	}
	
	protected M parentBuilder(P parentBuilder){
		this.parentBuilder = parentBuilder; 
		return myself;  
	}
	
	protected P parentBuilder(){
		return parentBuilder;
	}
	
	protected M data(D data){
		return myself; 
	}
	
	protected D data(){
		return data; 
	}
	
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.builder.IBuilder#build()
	 */
	@Override
	public D build(){
		/**
		 * TODO 用于处理defineName 和alias的逻辑  抽成另外protected方法
		 */
		return data; 
	}
	
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.builder.IBuilder#end()
	 */
	@Override
	public P end(){
		return this.parentBuilder(); 
	}
}
