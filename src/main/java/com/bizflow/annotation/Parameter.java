package com.bizflow.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于注解方法参数
 * @author zhengrun 2016年7月1日
 *
 */
/*@Inherited*/
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Parameter {
	String value() default ""; 
	String description() default ""; 
	boolean require() default true; 
}
