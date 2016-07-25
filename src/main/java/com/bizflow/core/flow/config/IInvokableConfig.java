package com.bizflow.core.flow.config;

import com.bizflow.core.execute.IInvokable;

public interface IInvokableConfig {

	IInvokable<?> getInvoker();

	void setInvoker(IInvokable<?> invoker);

}