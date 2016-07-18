package com.bizflow.core.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
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

import com.alibaba.fastjson.JSON;
import com.bizflow.TestCase;
import com.bizflow.annotation.DataProvider;
import com.bizflow.annotation.Parameter;
import com.bizflow.core.FlowManagerBean;
import com.bizflow.core.context.FlowContext;
import com.bizflow.core.data.DataProviderRegistry;
import com.bizflow.core.definition.DataProviderDefinition;
import com.bizflow.enums.Scope;
import com.google.common.collect.Lists;

public class FlowManagerBeanTest extends TestCase{

	@Test
	public void testAnnotation() {
		FlowManagerBean flowManagerBean = new FlowManagerBean(); 
		flowManagerBean.setScanPackages("com.bizflow");
		flowManagerBean.postProcessBeanDefinitionRegistry(null);
		
		DataProviderRegistry registry = getField(flowManagerBean, "dataProviderRegistry", DataProviderRegistry.class);  
		//assertTrue(registry.getAllProviderCount() == 4); 
		
		String provider1 = "provider1";
		DataProviderDefinition definition = registry.getProviderDefinition("provider1");
		assertNotNull(definition); 
		assertEquals(definition.getName(), provider1);
		assertEquals(definition.getAlias(), provider1);
		assertTrue(!definition.isAsync());
		assertEquals(definition.getScope(), Scope.FLOW);
		assertTrue(!definition.isGlobal());
		assertEquals(definition.getTimeOut().getTimeOut(), 0); 
		assertEquals(definition.getTimeOut().getTimeUnit(), TimeUnit.SECONDS);
		
		String provider2 = "provider2";
		definition = registry.getProviderDefinition("provider2");
		assertNotNull(definition); 
		assertEquals(definition.getName(), provider2);
		assertEquals(definition.getAlias(), "provider2-1");
		assertTrue(!definition.isAsync());
		assertEquals(definition.getScope(), Scope.STEP);
		assertTrue(definition.isGlobal());
		assertEquals(definition.getTimeOut().getTimeOut(), 120); 
		assertEquals(definition.getTimeOut().getTimeUnit(), TimeUnit.SECONDS);
	
		assertEquals(definition, registry.getProviderDefinition("provider2-1"));
		
		String provider3 = "provider3";
		definition = registry.getProviderDefinition(provider3);
		assertNotNull(definition); 
		assertEquals(definition.getName(), provider3);
		assertEquals(definition.getAlias(), provider3);
		assertTrue(!definition.isAsync());
		assertEquals(definition.getScope(), Scope.FLOW);
		assertTrue(!definition.isGlobal());
		assertEquals(definition.getTimeOut().getTimeOut(), 0); 
		assertEquals(definition.getTimeOut().getTimeUnit(), TimeUnit.SECONDS);
		
		System.out.println(JSON.toJSONString(definition));

	}
	
	@DataProvider("provider1")
	public Date provider1(){
		return null; 
	}

	@DataProvider(value="provider2", alias="provider2-1",
			scope=Scope.STEP, timeOut=120, global=true)
	public void provider2(FlowContext ctx){
		
	}
	
	@DataProvider("provider3")
	public <T> String provider3(@Parameter("data")T data,@Parameter("dataList") List<T> dataList,
			@Parameter("arrayList")ArrayList arrayList,@Parameter("objList")ArrayList<Object> objList,  
			@Parameter("strList") List<String> strList,@Parameter("sMap") Map<String, Object> sMap, 
			@Parameter("tMap")Map<String, T> tMap,@Parameter("tArray") T[] tArray,
			@Parameter("sArray") String[] sArray, 	String test, 
			FlowManagerBeanTest testBean,@Parameter("beans") FlowManagerBeanTest[] beans){
		return ""; 
	}
	
	@Test 
	public void testReflectionScanAnnotation(){
		FilterBuilder filter = new FilterBuilder(); 
		List<URL> urlList = Lists.newArrayList(); 
		filter.includePackage("com.bizflow.core"); 
		urlList.addAll(ClasspathHelper.forPackage("com.bizflow"));
		Reflections reflections = new Reflections(new ConfigurationBuilder()
				.setUrls(urlList)
				.filterInputsBy(filter)
				.setScanners(
					new SubTypesScanner()
						/*.filterResultsBy(filter)*/, 
					new TypeAnnotationsScanner()
						/*.filterResultsBy(filter)*/, 
					new FieldAnnotationsScanner()
						/*.filterResultsBy(filter)*/, 
					new MethodAnnotationsScanner()
						/*.filterResultsBy(filter)*/,
					new MethodParameterScanner(), 
					new MethodParameterNamesScanner(), 
					new MemberUsageScanner()
				)
			); 
		Set<Method> dataHandler = reflections.getMethodsAnnotatedWith(DataProvider.class); 
		assertTrue(dataHandler.size() >= 1);
	}


}
