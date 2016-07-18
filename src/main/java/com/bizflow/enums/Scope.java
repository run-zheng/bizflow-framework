package com.bizflow.enums;

public enum Scope {
	/**
	 * 优先级最高的自动注入查找范围的cache
	 */
	STEP, 
	/**
	 * 第二优先级的自动注入查找范围，也就是整个flow的context
	 */
	FLOW, 
	/**
	 * 第三优先级的自动注入查找范围，也就是ThreadLocal
	 */
	THREAD, 
	/**
	 * 最低优先级的自动注入查找范围，整个应用声明周期
	 */
	GLOBAL
}
