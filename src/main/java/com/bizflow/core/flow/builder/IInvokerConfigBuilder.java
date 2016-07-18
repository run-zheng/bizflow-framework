package com.bizflow.core.flow.builder;

import com.bizflow.core.execute.IInvokable;

public interface IInvokerConfigBuilder<P, M, D>  {
	public <T> M invoker(IInvokable<T> invoker); 
}
