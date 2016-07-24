package com.bizflow.core.config;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.bizflow.core.definition.ProcessorDefinition;
import com.bizflow.core.execute.IInvoker;
import com.bizflow.core.execute.IInvoker7;
import com.bizflow.core.flow.builder.BizFlowConfigBuilder;
import com.bizflow.core.flow.config.BizFlowConfig;
import com.bizflow.enums.Scope;

public class BizFlowConfigBuilderTest {
	@Test 
	public void testFlowConfigBuilder(){
		BizFlowConfigBuilder configer = BizFlowConfig.builder("test");
		
		configer
			.dataProviderByDefineName("defineName")
			.dataProvider("providerName", "defineName")
			.dataProvider("providerName", "defineName", "alias") 
			.dataProvider("providerName", new IInvoker<String>(){
				@Override
				public String invoke() {
					return null;
				}
			}) 
			.dataProvider("providerName")
				.defineName("defineName")
				.alias("会员")
				.description("通过会员Id获取会员信息，提供@Parameter(\"customerId名称的\")注解")
				.provider(new IInvoker<String>(){
					@Override
					public String invoke() {
						return null;
					}
				})
				.asyc().asyc(Boolean.FALSE)
				.scope(Scope.FLOW)
				.timeOut(60, TimeUnit.SECONDS)
				.timeOut(60)
				.global().global(Boolean.TRUE)
				.end() 
			.processors()
				.before("")
					.name("")
					.alias("")
					.description("")
					.defineName("")
					.invoker(new IInvoker7<String>(){
						@Override
						public <BizFlow, FlowConfig, DataProvider, Pattern, 
								BeanType, BigDecimal, ProcessorGroupType> String invoke(
								BizFlow a, FlowConfig b, DataProvider c, Pattern d, 
								BeanType e, BigDecimal f, ProcessorGroupType g) {
							return null;
						}
					})
					.fromAbstractDefinition(new ProcessorDefinition())
					.end()
				.before("", "")
				.before("", "", "")
				.beforeBuilder().end()
				.beforeByDefineName("processorName")
				.afterByDefineName("")
				.onCompleteByDefineName("")
				.onExceptionByDefineName("")
				.onExceptionByDefineName("")
				.onFinallyByDefineName("")	
				.customExecuterByDefineName("")
				.end()
			.processors("groupName")
				.processorByDefineName("defineName")
				.processor("processName", "defineName")
				.processor("processName", "defineName", "alias")
				.processor("processName", new IInvoker<String>() {
					@Override
					public String invoke() {
						return null;
					}
				})
				.end()
/*			.processors("groupName")
				.end()*/
			///////////////////////////////////////////
			///////////////////////////////////////////////
			//TODO  add handlableConfigBuilder handlerConfigBuilder//
			//TODO  to handle before after onComplete,onException, onFinally//
			//////////////////////////////////////////////
			////////////////////////////////////////////////
			
			/*	.processor("processName")
				.processor("processName", "alias")
				.processor("processName", "alias", "description")
				.processor("processName", new IInvoker<String>(){
					@Override
					public String invoke() {
						return null;
					}
				})
				.before("processorName")
				.before("processorName", new IInvoker<String>(){
						@Override
						public String invoke() {
							return null;
						}
					})
				.after("processorName", new IInvoker<String>(){
						@Override
						public String invoke() {
							return null;
						}
					})
				.before("processorName")
				.after("")
				.onComplete("")
				.onException("")
				.onException("")
				.onFinally("")
			////////////////////////////////////////
				.processor()
					.processorName("")
					.alias("")
					.description("")
					.process(new IInvoker<String>(){
						@Override
						public String invoke() {
							return null;
						}
					})
					.end(); 
				.processor()
					.process("")
					.alias("")
					.description("")
					////////////////////////////////////////////////////////
					.before("processorName")
					.after("processorName", new IInvoker<String>(){
						@Override
						public String invoke() {
							return null;
						}
					})
					.onComplete("")
					.onException("")
					.onFinally("")
					///////////////////////////////////////////////////////
					.process(new IInvoker<String>(){
						@Override
						public String invoke() {
							return null;
						}
					})
					///////////////////////////
					.async()
					.retry(3, 1000, timeOut TimeUnit.MILLISECONDS)
					.end() 
				.sendMessageProcessor()
				.receiveMessageProcessor()
				.httpProcessor()
				.sequenceProcessorGroup("")
					.processor("")
					.processor("")
					.end()
				.parellalProcessorGroup("") //name, alias, description
					.processor("") //
					.processor("")
					.asyncProcessor("")
					//////////////////////////////////////
					.noWait()
					.anyDoneReturn()
					.anyDoneReturn("", "")
					.allDoneReturn()
					.wait("", "", "").doneReturn()
					.end()
				.alternateProcessor("") //name, alias, description
					.loop()
						condition("")
							.processor()
							.processor()
						.end()
					.end() 
					.condition("")	//name, alias, description
						.processor()
						.processor()
						.end()
					.condition("", new IInvoker<Boolean>(){
							@Override
							public Boolean invoke() {
								// TODO Auto-generated method stub
								return null;
							}
						})
						.processor()
						.end()
					.end()
				.subFlow("")
					
				.subFlowBuilder("debitGoOn")
					.processor()
					.end()
				.end() 
			.build()
				*/;
			//runtime 用于记录每个bizflow的执行过程 
			//processor execute 
			//   flowlastStepId flowId parentFlowId parameters returnValue context  
			//  
	}

	private void dataProvider(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testMind(){
		/*bizflow("")
			.processor("", IStepProcessA.class)
			.processor("", IStepProcessB.class)
			.subBizFlow("")
				.processor("", IStepProcessA.class)
			.onException("")
				.goOn("")
				.end
			.end("")*/
	}
}
