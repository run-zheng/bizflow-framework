package com.bizflow.core;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MemberUsageScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.MethodParameterNamesScanner;
import org.reflections.scanners.MethodParameterScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.util.Assert;

import com.bizflow.annotation.BizFlowBuilder;
import com.bizflow.annotation.BizHandler;
import com.bizflow.annotation.DataProvider;
import com.bizflow.annotation.Processor;
import com.bizflow.core.data.DataProviderRegistry;
import com.bizflow.core.definition.BizFlowDefinition;
import com.bizflow.core.definition.DataProviderDefinition;
import com.bizflow.core.definition.DefinitionFactory;
import com.bizflow.core.definition.ProcessorDefinition;
import com.bizflow.core.flow.BizFlowDefinitionRegistry;
import com.bizflow.core.processor.ProcessorRegistry;
import com.google.common.collect.Lists;

public class FlowManagerBean implements BeanDefinitionRegistryPostProcessor, PriorityOrdered, ApplicationContextAware {
	private static final Logger logger = LoggerFactory.getLogger(FlowManagerBean.class); 
	
	
	private static final String DEFAULT_SCAN_SPLIT_TOKEN = ","; 
	private ApplicationContext applicationContext;
	
	private String scanPackages; 
	private String scanSplitToken; 
	
	private DataProviderRegistry dataProviderRegistry; 
	private ProcessorRegistry processorRegistry; 
	private BizFlowDefinitionRegistry bizFlowConfigRegistry; 
	
	public void setScanSplitToken(String scanSplitToken) {
		this.scanSplitToken = scanSplitToken;
	}
	public void setScanPackages(String scanPackages) {
		this.scanPackages = scanPackages;
	}
	
	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE + 1;
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		Assert.hasText(this.scanPackages);
		String[] scanPackageArrs = this.scanPackages.split(scanSplitToken == null ? DEFAULT_SCAN_SPLIT_TOKEN : this.scanSplitToken);
		FilterBuilder filter = new FilterBuilder(); 
		List<URL> urlList = Lists.newArrayList(); 
		for (String scanPackage : scanPackageArrs) {
			filter.includePackage(scanPackage);
			urlList.addAll(ClasspathHelper.forPackage(scanPackage));
		}
		Reflections reflections = new Reflections(new ConfigurationBuilder()
				.setUrls(urlList)
				.filterInputsBy(filter)
				.setScanners(
					new SubTypesScanner(), 
					new TypeAnnotationsScanner(), 
					new FieldAnnotationsScanner(), 
					new MethodAnnotationsScanner(),
					new MethodParameterScanner(), 
					new MethodParameterNamesScanner(), 
					new MemberUsageScanner()
				)
			); 
		////////初始化DataProviderRegistry
		this.dataProviderRegistry = new DataProviderRegistry(); 
		this.processorRegistry = new ProcessorRegistry(); 
		this.bizFlowConfigRegistry = new BizFlowDefinitionRegistry(); 
		//数据处理器
		handleDataProviderAnnotation(reflections);
		//普通处理器
		handleProcessorAnnotation(reflections);
		//业务流程起点处理器
		handleBizHandlerProcessorAnnotation(reflections);
		//流程构建器
		handleBizFlowBuilderAnnotation(reflections);
	
		//初始化Flow  
		//Parameter   convertor 
		
		//并行处理器集合 ParallelHandlerGroup  
		//顺序处理器集合 SequenceHandlerGroup 
		//分支处理器集合 BranchHandlerGroup 
		
		////////注册Flow
	}
	/**
	 * 流程构建器的注解处理
	 * @param reflections
	 */
	private void handleBizFlowBuilderAnnotation(Reflections reflections) {
		Set<Method> flowBuilders = reflections.getMethodsAnnotatedWith(BizFlowBuilder.class);
		for (Method method : flowBuilders) {
			BizFlowDefinition definition = DefinitionFactory.INSTANCE.createBizFlowConfigDefition(method);
			bizFlowConfigRegistry.registerBizFlowDefinition(definition);
			logger.debug("register biz flow : " );
		}
	}
	
	
	/**
	 * BizHandler注解处理
	 * @param reflections
	 */
	private void handleBizHandlerProcessorAnnotation(Reflections reflections){
		Set<Method> processMethod = reflections.getMethodsAnnotatedWith(BizHandler.class); 
		for (Method method : processMethod) {
			ProcessorDefinition definition = DefinitionFactory.INSTANCE.createBizHandlerProcessorDefinition(method);
			processorRegistry.registerProcessor(definition);
			logger.debug("register bizhandler processor: "+definition.getName());
		}
	}
	

	/**
	 * 解析普通处理器的注解
	 * @param reflections
	 */
	private void handleProcessorAnnotation(Reflections reflections) {
		Set<Method> processMethod = reflections.getMethodsAnnotatedWith(Processor.class); 
		for (Method method : processMethod) {
			ProcessorDefinition definition = DefinitionFactory.INSTANCE.createProcessorDefinition(method);
			processorRegistry.registerProcessor(definition);
			logger.debug("register processor: "+definition.getName());
		}
	}
	
	/**
	 * 数据提供者注解处理
	 * @param reflections
	 */
	private void handleDataProviderAnnotation(Reflections reflections) {
		Set<Method> dataHandler = reflections.getMethodsAnnotatedWith(DataProvider.class); 
		for (Method method : dataHandler) {
			DataProviderDefinition definition = DefinitionFactory.INSTANCE.createDataProviderDefinition(method);
			dataProviderRegistry.registerProvider(definition);
		}
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext; 
	}
	

}
