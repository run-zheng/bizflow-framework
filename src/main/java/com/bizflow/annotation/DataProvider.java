package com.bizflow.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import com.bizflow.enums.Scope;

/**
 * 用来注解一个方法为数据提供者，数据的标识名称为value指定的
 * @author zhengrun 2016年6月25日
 *
 */
/*@Inherited*/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataProvider {
	/**
	 * 不提供名称，则默认用返回值类型短名称的作为名称
	 * @return
	 */
	String value(); 
	/**
	 * 别名，如果提供了别名,可以用别名访问
	 * @return
	 */
	String alias() default "";
	/**
	 * 描述，可以是中文描述，以便后续流程信息输出的阅读方便
	 * @return
	 */
	String description() default ""; 
	/**
	 * 默认使用时，才会实际调用数据提供者的方法(采用future)
	 * @return
	 */
	/*boolean lazy() default true;*/ 
	
	/**
	 * 是否异步获取（RxJava消息系统提供处理）
	 * @return
	 */
	boolean async() default false;
	
	/**
	 * 缓存的范围
	 * @return
	 */
	Scope scope() default Scope.FLOW; 
	
	boolean global() default false; 
	/**
	 * 失效时间
	 * @return
	 */
	long timeOut() default 0;
	
	/**
	 * 失效时间单位
	 * @return
	 */
	TimeUnit timeUnit() default TimeUnit.SECONDS; 
}
