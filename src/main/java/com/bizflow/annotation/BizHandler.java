package com.bizflow.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来注解一个流程起点的节点
 * @author zhengrun 2016年6月25日
 *
 */
/*@Inherited*/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BizHandler {
	/**
	 * 节点名称
	 * @return
	 */
	String value();
	/**
	 * 如果flowName为空，那么节点名称默认为流程名称
	 * @return
	 */
	String flowName(); 
	
	String description() default "";
}
