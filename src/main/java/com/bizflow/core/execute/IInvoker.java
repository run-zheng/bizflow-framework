package com.bizflow.core.execute;

public interface IInvoker<T> extends IInvokable<T>{
	public T invoke();
}
