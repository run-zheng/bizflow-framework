package com.bizflow.core;

import java.beans.Introspector;

import org.springframework.util.ClassUtils;

public class InjectNameGenerator {
	public static String generateBeanName(Class<?> type){
		 String typeShortName = ClassUtils.getShortName(type.getName());
		 return Introspector.decapitalize(typeShortName);
	}
}
