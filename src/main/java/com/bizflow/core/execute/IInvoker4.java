package com.bizflow.core.execute;

public interface IInvoker4<T> extends IInvokable<T>{
	public <A, B, C, D> T invoke(A a, B b, C c, D d);
}
