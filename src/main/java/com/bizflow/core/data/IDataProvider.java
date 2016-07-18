package com.bizflow.core.data;

public interface IDataProvider<T> {
	public T provider(Object... args); 
}
