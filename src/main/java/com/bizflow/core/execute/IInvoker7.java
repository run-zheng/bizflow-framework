package com.bizflow.core.execute;

public interface IInvoker7<T> extends IInvokable<T>{
	public <A, B, C, D, E, F, G> T invoke(A a, B b, C c, D d, E e, F f, G g);
}
