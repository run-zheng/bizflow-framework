package com.bizflow.core.flow.builder;

import com.bizflow.core.flow.config.AbstractGroupConfig;

/**
 * 暂时用jdk7， 使用jdk8的话，不用写那么多继承类^_^!
 * @author zhengrun 2016年7月22日
 *
 * @param <P>
 * @param <M>
 * @param <D>
 */
public class AbstractGroupBuilder<P, M, D extends AbstractGroupConfig> extends AbstractExecutableBuilder<P, AbstractGroupBuilder<P, ?, D>, D>{

}
