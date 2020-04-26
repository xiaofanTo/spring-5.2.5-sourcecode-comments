/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;
import org.springframework.lang.Nullable;

/**
 * 工厂hook函数，用来对新的bean实例进行修改
 * 例如，检查标记接口或者用代理进行包装
 *
 * 一般情况下，实现标记接口通过实现{@link #postProcessBeforeInitialization}
 * 然而，用代理对bean进行包装通常实现{@link #postProcessAfterInitialization}
 *
 * ApplicationContext能从它的bean definitions中自动检测出BeanPostProcessor并且
 * 应用这些后处理器在随后的bean的创建的时候
 *
 * BeanFactory允许手动注册这些post-processors，应用它们在创建bean factory的时候
 *
 * <h3>排序</h3>
 * 在ApplicationContext自动检测出来的BeanPostProcessor会根据
 * {@link org.springframework.core.PriorityOrdered} 和
 * {@link org.springframework.core.Ordered}进行排序
 *
 * 相反的，在BeanFactory中通过手动注册的BeanPostProcessor的顺序由注册顺序控制
 * @see InstantiationAwareBeanPostProcessor
 * @see DestructionAwareBeanPostProcessor
 * @see ConfigurableBeanFactory#addBeanPostProcessor
 * @see BeanFactoryPostProcessor
 */
public interface BeanPostProcessor {

	/**
	 * 在bean初始化之前调用，bean已经进行了属性注入
	 * 此处指的初始化是InitializingBean's {@code afterPropertiesSet}或者init-method
	 * 返回的bean可能是原始的bean的一个包装器
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return the bean instance to use, either the original or a wrapped one;
	 * if {@code null}, no subsequent BeanPostProcessors will be invoked
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
	 */
	@Nullable
	default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	/**
	 * 在初始化之后调用
	 * 如果是FactoryBean，这个方法会被调用当FactoryBean实例化或者FactoryBean创建objects的时候（从Spring 2.0起）
	 * 在{@link InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation}方法触发短路后也会调用此回调
	 *
	 * 注意如果返回值为null  那么之后的BeanPostProcessor将不会调用
	 */
	@Nullable
	default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
