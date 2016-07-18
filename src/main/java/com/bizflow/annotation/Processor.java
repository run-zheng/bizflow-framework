package com.bizflow.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来注解一个通用处理器
 * @author zhengrun 2016年6月25日
 *
 */
/*@Inherited*/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Processor {
	String value();
	String description() default ""; 
}
