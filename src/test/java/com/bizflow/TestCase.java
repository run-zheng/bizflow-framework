package com.bizflow;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.springframework.util.ReflectionUtils;

public class TestCase {
	
	@SuppressWarnings("unchecked")
	public <D, F> F getField(D data, String fieldName, Class<F> fieldType){
		Field field = ReflectionUtils.findField(data.getClass(), fieldName, fieldType); 
		if(Modifier.isPrivate(field.getModifiers()) 
			|| Modifier.isProtected(field.getModifiers())){
			field.setAccessible(true);
		}
		return (F) ReflectionUtils.getField(field, data);
		
	}
}
