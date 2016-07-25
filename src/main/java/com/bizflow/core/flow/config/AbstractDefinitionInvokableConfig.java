package com.bizflow.core.flow.config;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.bizflow.core.definition.AbstractDefinition;
import com.bizflow.core.execute.IInvokable;

public class AbstractDefinitionInvokableConfig extends AbstractConfig implements IDefinitionInvokableConfig{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3827562729776480101L;
	/**
	 * 定义名称，如果有对应的definition的话，对应definition的name
	 */
	private String defineName; 
	private IInvokable<?> invoker; 
	
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.config.IInvokableConfig#getInvoker()
	 */
	@Override
	public IInvokable<?> getInvoker() {
		return invoker;
	}
	
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.config.IInvokableConfig#setInvoker(com.bizflow.core.execute.IInvokable)
	 */
	@Override
	public  void setInvoker(IInvokable<?> invoker) {
		this.invoker = invoker;
	}
	
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.config.IDefinitionConfig#getDefineName()
	 */
	@Override
	public String getDefineName() {
		return defineName;
	}
	
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.config.IDefinitionConfig#setDefineName(java.lang.String)
	 */
	@Override
	public void setDefineName(String defineName) {
		this.defineName = defineName;
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
		if(StringUtils.isEmpty(this.getDefineName())){
			this.setDefineName(name);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.bizflow.core.flow.config.IDefinitionConfig#fromAbstractDefinition(com.bizflow.core.definition.AbstractDefinition)
	 */
	@Override
	public void fromAbstractDefinition(AbstractDefinition definition){
		Assert.notNull(definition);
		if(!StringUtils.isEmpty(definition.getName() )){
			if(StringUtils.isEmpty(getName())){
				setName(definition.getName());
			}
			setDefineName(definition.getName());
		}
		if(StringUtils.isEmpty(getAlias())){
			setAlias(definition.getAlias());
		}
		if(StringUtils.isEmpty(getDescription())){
			setDescription(definition.getDescription());
		}
	}
}
