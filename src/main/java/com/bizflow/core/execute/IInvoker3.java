package com.bizflow.core.execute;

public interface IInvoker3<T> extends IInvokable<T>{
	public <A, B, C> T invoke(A a, B b, C c);
}
