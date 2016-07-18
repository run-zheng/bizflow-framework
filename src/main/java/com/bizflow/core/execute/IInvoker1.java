package com.bizflow.core.execute;

public interface IInvoker1<T> extends IInvokable<T>{
	public <A> T invoke(A a);
}
