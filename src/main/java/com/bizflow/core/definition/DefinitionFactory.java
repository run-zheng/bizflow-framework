package com.bizflow.core.definition;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.bizflow.annotation.AutoInject;
import com.bizflow.annotation.BizFlowBuilder;
import com.bizflow.annotation.BizHandler;
import com.bizflow.annotation.DataProvider;
import com.bizflow.annotation.NotRequire;
import com.bizflow.annotation.Parameter;
import com.bizflow.annotation.Processor;
import com.bizflow.core.InjectNameGenerator;
import com.bizflow.core.context.FlowContext;
import com.bizflow.core.flow.builder.BizFlowConfigBuilder;
import com.bizflow.exception.RegisterException;

/**
 * 创建definition的工厂， 用枚举实现单例简单点做
 * @author zhengrun 2016年7月6日
 *
 */
public enum DefinitionFactory {
	INSTANCE; 

	private static final Logger logger = LoggerFactory.getLogger(DefinitionFactory.class); 
	
	public BizFlowDefinition createBizFlowConfigDefition(Method method){
		logger.debug("handler biz flow builder processor: " + method.getDeclaringClass().getName() + " --> " + method.getName());
		BizFlowBuilder flowBuilder = method.getAnnotation(BizFlowBuilder.class); 
		AbstractProcessorSimpleInfo simpleInfo = AbstractProcessorSimpleInfo.simpleInfo(flowBuilder); 
		BizFlowDefinition definition = createBizFlowDefinition(method, flowBuilder, simpleInfo);
		return definition; 
	}
	
	/**
	 * 创建并注册BizFlowDefintion
	 * @param method
	 * @param flowBuilder
	 * @param simpleInfo
	 */
	private BizFlowDefinition createBizFlowDefinition(Method method, BizFlowBuilder flowBuilder,
			AbstractProcessorSimpleInfo simpleInfo) {
		Class<?> returnType = method.getReturnType();
		Type type = method.getGenericReturnType(); 
		logger.debug(String.format("%-80s %s", "	return type:"+ returnType.getName() ,	" genericType: " + type));
		
		if(StringUtils.isEmpty(flowBuilder.value())){
			throw new IllegalArgumentException("Biz Flow's value should not be empty"); 
		}
		
		if(returnType.isAssignableFrom(BizFlowConfigBuilder.class)){
			throw new RegisterException("BizFlowBuilder's return type must be "
					+ "instance of FlowConfig or subtype of FlowConfig");
		}
		
		BizFlowDefinition definition = createFlowBuilderDefinition(method, simpleInfo);
		processFlowBuilderMethodParameter(method, returnType, definition);
		return definition; 
	}
	
	/**
	 * 处理BizFlowBuilder的方法参数
	 * @param method
	 * @param returnType
	 * @param definition
	 */
	private void processFlowBuilderMethodParameter(Method method, Class<?> returnType, BizFlowDefinition definition) {
		Class<?>[] parameterTypes = method.getParameterTypes(); 
		Type[] types = method.getGenericParameterTypes();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations(); 
		if(parameterTypes != null && parameterTypes.length > 0 ) {
			processParameterSetting(definition, true, parameterTypes, types, parameterAnnotations);
		}
	}
	
	/**
	 * 创建BizFlowDefinition
	 * @param method
	 * @param simpleInfo
	 * @return
	 */
	private BizFlowDefinition createFlowBuilderDefinition(Method method, AbstractProcessorSimpleInfo simpleInfo) {
		BizFlowDefinition definition = new BizFlowDefinition(); 
		fillAbstraceDefinition(definition, method, simpleInfo.name(), 
				simpleInfo.alias() , simpleInfo.description());
		return definition;
	}
	
	
	/**
	 * 从注解了BizHandler的方法创建ProcessorDefition
	 * @param method
	 * @return
	 */
	public ProcessorDefinition createBizHandlerProcessorDefinition(Method method){
		logger.debug("handler bizhandler processor : "+ method.getDeclaringClass().getName()+" --> "+ method.getName());
		BizHandler processor = method.getAnnotation(BizHandler.class);
		AbstractProcessorSimpleInfo simpleInfo = AbstractProcessorSimpleInfo.simpleInfo(processor); 
		ProcessorDefinition definition = createProcessorDefinition(method, simpleInfo, "BizHandler Processor");
		definition.setBizHandler(Boolean.TRUE);
		definition.setFlowName(processor.flowName());
		return definition; 
	}
	/**
	 * 从注解了Processor的方法创建ProcessorDefinition
	 * @param method
	 * @return
	 */
	public ProcessorDefinition createProcessorDefinition(Method method){
		Assert.notNull(method);
		logger.debug("handler processor : "+ method.getDeclaringClass().getName()+" --> "+ method.getName());
		Processor processor = method.getAnnotation(Processor.class);
		Assert.notNull(processor);
		AbstractProcessorSimpleInfo simpleInfo = AbstractProcessorSimpleInfo.simpleInfo(processor); 
		ProcessorDefinition definition = createProcessorDefinition(method, simpleInfo, "Processor");
		return definition; 
	}
	
	/**
	 * 创建并注册ProcessorDefinition
	 * @param method
	 * @param simpleInfo
	 * @param processorType
	 * @return
	 */
	private ProcessorDefinition createProcessorDefinition(Method method, AbstractProcessorSimpleInfo simpleInfo,
			String processorType) {
		Class<?> returnType = method.getReturnType();
		Type type = method.getGenericReturnType(); 
		logger.debug(String.format("%-80s %s", "	return type:"+ returnType.getName() ,	" genericType: " + type));
		
		if(StringUtils.isEmpty(simpleInfo.name())){
			throw new IllegalArgumentException(processorType+"' value should not be empty"); 
		}
		
		ProcessorDefinition processorDefinition = createProcessorDefinition(method, simpleInfo); 
		processProcessorParameter(method, processorDefinition);
		return processorDefinition; 
	}
	
	
	private ProcessorDefinition createProcessorDefinition(Method method, AbstractProcessorSimpleInfo simpleInfo) {
		ProcessorDefinition processorDefinition = new ProcessorDefinition();
		fillAbstraceDefinition(processorDefinition, method, simpleInfo.name(), 
				simpleInfo.alias() , simpleInfo.description());
		return processorDefinition;
	}
	
	private void processProcessorParameter(Method method, ProcessorDefinition processorDefinition) {
		Class<?>[] parameterTypes = method.getParameterTypes(); 
		Type[] types = method.getGenericParameterTypes();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations(); 
		if(parameterTypes != null && parameterTypes.length > 0 ) {
			processParameterSetting(processorDefinition, true, 
				parameterTypes, types, parameterAnnotations);
		}
	}
	

	/**
	 * 根据注解的方法创建DataProviderDefinition
	 * @param method
	 * @return
	 */
	public DataProviderDefinition createDataProviderDefinition(Method method){
		Assert.notNull(method);
		logger.debug("handler data provider : "+ method.getDeclaringClass().getName()+" --> "+ method.getName());
		
		DataProvider dataProvider = method.getAnnotation(DataProvider.class); 
		
		Assert.notNull(dataProvider);
		
		Class<?> returnType = method.getReturnType();
		Type type = method.getGenericReturnType(); 
		logger.debug(String.format("%-80s %s", "	return type:"+ returnType.getName() ,	" genericType: " + type));
		
		if(StringUtils.isEmpty(dataProvider.value())){
			throw new IllegalArgumentException("Data Provider's value should not be empty"); 
		}
		//生成dataProvider的名称
		String dataProviderName = dataProvider.value(); 
		if(StringUtils.isEmpty(dataProviderName)){
			dataProviderName =InjectNameGenerator.generateBeanName(returnType); 
		}
		
		DataProviderDefinition definition = createDataProviderDefinition(method, dataProvider, dataProviderName);
		processDataProviderMethodParameter(method, returnType, definition);
		return definition; 
	}

	/**
	 * 创建DataProviderDefinition
	 * @param method
	 * @param dataProvider
	 * @param dataProviderName
	 * @return
	 */
	private DataProviderDefinition createDataProviderDefinition(Method method, 
			DataProvider dataProvider, String dataProviderName) {
		DataProviderDefinition definition = new DataProviderDefinition();
		fillAbstraceDefinition(definition, method, dataProviderName, StringUtils.isEmpty(dataProvider.alias()) ?
				dataProviderName : dataProvider.alias(), dataProvider.description()); 
		definition.setIsGlobal(dataProvider.global());
		definition.setIsAsync(dataProvider.async());
		definition.setScope(dataProvider.scope());
		definition.setTimeOut(dataProvider.timeOut(), dataProvider.timeUnit());
		return definition;
	}
	
	/**
	 * 解析DataProvider的参数
	 * @param method
	 * @param returnType
	 * @param definition
	 */
	private void processDataProviderMethodParameter(Method method, Class<?> returnType,
			DataProviderDefinition definition) {
		boolean requireInjectContext = false; 
		boolean hasContext = false; 
		if(returnType.isAssignableFrom(void.class)){
			requireInjectContext = true; 
		}
		Class<?>[] parameterTypes = method.getParameterTypes(); 
		Type[] types = method.getGenericParameterTypes();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations(); 
		if(parameterTypes != null && parameterTypes.length > 0 ) {
			hasContext = processParameterSetting(definition, hasContext, 
				parameterTypes, types, parameterAnnotations);
		}

		if(requireInjectContext && !hasContext){
			throw new RegisterException("Void return type data provider requires inject FlowContext"); 
		}
	}
	
	private AbstractDefinition fillAbstraceDefinition(AbstractDefinition definition, 
			Method method, String name, String alias, String description){
		if(!method.isAccessible()){
			if(Modifier.isPublic(method.getModifiers())){
				method.setAccessible(true);
			}else {
				throw new RegisterException("method can't access");
			}
		}
		Class<?> declareingClass = method.getDeclaringClass(); 
		definition.setBeanNameAndType(declareingClass); 
		definition.setMethod(method);
		definition.setIsStaticMethod(Modifier.isStatic(method.getModifiers()));
		definition.setClazz(declareingClass);
		definition.setName(name);
		definition.setAlias(alias);
		definition.setDescription(description);
		definition.setReturnType(method.getReturnType());
		
		return definition;
	}
	

	private boolean processParameterSetting(AbstractDefinition definition, boolean hasContext,
			Class<?>[] parameterTypes, Type[] types, Annotation[][] parameterAnnotations) {
		for(int i = 0; i < parameterTypes.length; i++){
			Class<?> parameterType = parameterTypes[i];
			Type type = types[i];
			logger.debug(String.format("%-80s %s", "	parameter type:"+ parameterType.getName() ,	" genericType: " + type));
			ParameterSetting parameterSetting = new ParameterSetting(); 
			parameterSetting.setIndex(i);
			parameterSetting.setType(parameterType);
			if(parameterAnnotations[i] != null) {
				for(int j = 0; j < parameterAnnotations[i].length; j++){
					Annotation annotation = parameterAnnotations[i][j];
					processParameterAnnotation(parameterSetting, annotation);
				}
			}
			if(StringUtils.isEmpty(parameterSetting.getAnnotatedName())){
				String typeString = type.toString(); 
				if(typeString.startsWith("class") && !typeString.startsWith("class [")
					|| typeString.startsWith("interface")){
					//如果是类或接口，直接将类或接口的端名称作为
					String candidateName = InjectNameGenerator.generateBeanName(parameterType);; 
					parameterSetting.setName(candidateName);
					/*parameterSetting.setAnnotatedName(candidateName);*/
				}else {
					throw new RegisterException("Array/Collection/Map/GenericType/GenericTypeArray"
							+ " requires annotated name");
				}
			}
			/*if(!StringUtils.isEmpty(parameterSetting.getAnnotatedName()) 
				&& parameterSetting.isAutoInject()){
				throw new RegisterException(); 
			}*/
			/*if(StringUtils.isEmpty(parameterSetting.getName())){
				parameterSetting.setName(ClassUtils.getShortName(parameterType));
			}*/
			
			if(parameterTypes[i].isAssignableFrom(FlowContext.class)){
				hasContext = true;
			}
			
			definition.addParameterSetting(parameterSetting);
		}
		return hasContext;
	}
	

	private void processParameterAnnotation(ParameterSetting parameterSetting, Annotation annotation) {
		if(annotation != null){
			if(annotation instanceof Parameter){
				Parameter parameter = (Parameter)annotation; 
				parameterSetting.setName(parameter.value());
				parameterSetting.setAnnotatedName(parameter.value());
				parameterSetting.setRequire(parameter.require());
			}
			if(annotation instanceof NotRequire){
				parameterSetting.setRequire(Boolean.TRUE);
			}
			if(annotation instanceof AutoInject){
				AutoInject autoInject = (AutoInject)annotation; 
				parameterSetting.setAutoInject(autoInject.value());
			}
		}
	}
	
	private static abstract class AbstractProcessorSimpleInfo{
		public abstract String name(); 
		public abstract String alias(); 
		public abstract String description(); 
		
		public static AbstractProcessorSimpleInfo simpleInfo(final BizFlowBuilder bizFlowBuilder){
			return new AbstractProcessorSimpleInfo() {
				@Override
				public String name() {
					return bizFlowBuilder.value();
				}
				
				@Override
				public String description() {
					return bizFlowBuilder.description();
				}
				
				@Override
				public String alias() {
					return bizFlowBuilder.value();
				}
			};
		}
		
		public static AbstractProcessorSimpleInfo simpleInfo(final BizHandler processor){
			return new AbstractProcessorSimpleInfo() {
				@Override
				public String name() {
					return processor.value();
				}
				
				@Override
				public String description() {
					return processor.description();
				}
				
				@Override
				public String alias() {
					return processor.value();
				}
			};
		}
		
		public static AbstractProcessorSimpleInfo simpleInfo(final Processor processor){
			return new AbstractProcessorSimpleInfo() {
				@Override
				public String name() {
					return processor.value();
				}
				
				@Override
				public String description() {
					return processor.description();
				}
				
				@Override
				public String alias() {
					return processor.value();
				}
			};
		}
	}
}
