package com.bizflow.core.execute;

public interface IInvoker2<T> extends IInvokable<T>{
	public <A, B> T invoke(A a, B b);
}
