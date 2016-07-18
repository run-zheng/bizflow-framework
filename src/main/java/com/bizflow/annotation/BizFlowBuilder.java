package com.bizflow.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来注解一个返回值为FlowConfigBuilder的流程构建方法
 * @author zhengrun 2016年6月25日
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BizFlowBuilder {
	/**
	 * 流程名称
	 * @return
	 */
	String value();
	
	String description() default "";  
}
