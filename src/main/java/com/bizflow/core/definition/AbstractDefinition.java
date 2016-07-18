package com.bizflow.core.definition;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.bizflow.core.InjectNameGenerator;
import com.bizflow.enums.BeanType;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 元素定义抽象类
 * @author zhengrun 2016年7月1日
 *
 */
public abstract class AbstractDefinition {
	@SuppressWarnings("unchecked")
	private static final Set<Class<? extends Annotation>> SPRING_BEAN_ANNOTATIONS = Sets.newHashSet(Component.class, 
			Service.class, Repository.class, Controller.class);
	
	/**
	 * 名称
	 */
	private String name; 
	/**
	 * 别名，默认不填等于name，用于显示，所以可以设置中文名称
	 */
	private String alias; 
	/**
	 * 描述
	 */
	private String description; 
	/**
	 * 所在的方法
	 */
	private Method method; 
	/**
	 * 是否是静态方法
	 */
	private Boolean isStaticMethod = Boolean.FALSE; 
	/**
	 * 所在的类
	 */
	private Class<?> clazz;
	/**
	 * 返回值类型， 不能为泛型
	 */
	private Class<?> returnType; 
	private String beanName;  //如果Bean声明时，指定了beanName，那么beanName优先用于查找Bean
							//否则，利用beanType -> clazz 去查找Bean
	private BeanType beanType; 
	
	/**
	 * 参数列表信息
	 */
	private List<ParameterSetting> parameterSettings = Lists.newArrayList(); 

	public BeanType getBeanType() {
		return beanType;
	}
	
	public void setBeanType(BeanType beanType) {
		this.beanType = beanType;
	}
	
	public Boolean isStaticMethod(){
		return this.isStaticMethod; 
	}
	
	public void setIsStaticMethod(Boolean isStaticMethod) {
		this.isStaticMethod = isStaticMethod;
	}
	
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public Class<?> getReturnType() {
		return returnType;
	}
	public void setReturnType(Class<?> returnType) {
		this.returnType = returnType;
	}

	public List<ParameterSetting> getParameterSettings() {
		return Collections.unmodifiableList(parameterSettings);
	}
	
	public void addParameterSetting(ParameterSetting parameterSetting){
		this.parameterSettings.add(parameterSetting);
	}
	
	public boolean removeParameterSetting(ParameterSetting parameterSetting){
		return this.parameterSettings.remove(parameterSetting);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	} 
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 根据Bean类型是否是spring的bean，设置beanType和beanName
	 * @param beanType
	 */
	public void setBeanNameAndType(Class<?> beanType) {
		Assert.notNull(beanType);
		
		Annotation[] annotations = beanType.getAnnotations();
		boolean isSpringBean = false; 
		for (Annotation annotation : annotations) {
			if(SPRING_BEAN_ANNOTATIONS.contains(annotation.annotationType())){
				if(annotation instanceof Service){
					this.setBeanName(((Service)annotation).value());
					isSpringBean = true; 
				}else if(annotation instanceof Controller){
					this.setBeanName(((Controller)annotation).value());
					isSpringBean = true; 
				}else if(annotation instanceof Repository){
					this.setBeanName(((Repository)annotation).value());
					isSpringBean = true; 
				}else if(annotation instanceof Component){
					this.setBeanName(((Component)annotation).value());
					isSpringBean = true; 
				}
				if(isSpringBean){
					this.setBeanType(BeanType.SpringBean);
					if(StringUtils.isEmpty(this.getBeanName())){
						this.setBeanName(InjectNameGenerator.generateBeanName(beanType));
					}
					break; 
				}
			}
		}
		if(!isSpringBean){
			this.setBeanType(BeanType.InvokableBean);
		}
	}
}
