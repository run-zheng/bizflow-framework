package com.bizflow.core.flow.builder;

public interface IBuilder<P, M, D> {

	/**
	 * 如果需要后期构建，覆盖build方法
	 * @return
	 */
	D build();

	/**
	 * 切换回父构建器
	 * @return
	 */
	P end();

}