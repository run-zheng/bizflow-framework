package com.bizflow.core.execute;

public interface IInvoker5<T> extends IInvokable<T>{
	public <A, B, C, D, E>T invoke(A a, B b, C c, D d, E e);
}
