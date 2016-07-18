package com.bizflow.core.flow.config;

import com.bizflow.core.flow.builder.BizFlowConfigBuilder;

public class BizFlowConfig extends AbstractConfig{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2133279852695949441L;

	public static BizFlowConfigBuilder builder(String flowName) {
		return new BizFlowConfigBuilder(flowName);
	}

}
