package com.bizflow.annotation;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.Set;

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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bizflow.core.context.FlowContext;
import com.google.common.collect.Lists;

public class AnnotationTest {

	@Test
	public void testAnnotations(){
		FilterBuilder filter = new FilterBuilder(); 
		List<URL> urlList = Lists.newArrayList(); 
		filter.includePackage("com.bizflow.annotation"); 
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
		Set<Class<?>> clazzSet = reflections.getTypesAnnotatedWith(Component.class, true); 
		assertTrue(clazzSet.size() == 2);
		
		Set<Method> methodSet = reflections.getMethodsAnnotatedWith(Processor.class);
		assertTrue(methodSet.size() == 1);
		
		Component annotation = AA.class.getAnnotation(Component.class); 
		assertTrue(annotation == null); 
		
		try {
			//@Inherited只针对类型有效
			Method method = TestIntImpl.class.getMethod("test", null);
			Processor processor = method.getAnnotation(Processor.class);
			assertTrue(processor == null);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} 
	
		Component annotation2 = B.class.getAnnotation(Component.class);
		assertTrue(annotation2 == null);
		Service annotation3 = B.class.getAnnotation(Service.class);
		assertTrue(annotation3 != null );
	}
	
	@Component
	public static class A {
	}
	
	
	public static class AA extends A{
		
	}
	
	@Component
	public static class AA2 extends A{
		
	}
	
	@Service
	public static class B {
	}
	
	public static class TestTest{
		//@DataProvider("abc")
		public void test1(FlowContext context){
		}
	}

	public static class Test2 extends TestTest{
		@Override
		public void test1(FlowContext context) {
			super.test1(context);
		}
	}
	
	public static interface TestInt {
		@Processor("afsdf")
		public void test(); 
		
	}
	
	public static class TestIntImpl implements TestInt{
		@Override
		public void test() {
			// TODO Auto-generated method stub
			
		}
	}
	
}
