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

/**
 * 工厂后置处理器，改变context中基础的bean factory的属性
 * 对于定制系统管理员配置文件很有用，这些文件重写了在application context中的bean属性
 * See {@link PropertyResourceConfigurer} 它的开箱即用解决方案的具体实现满足了此类需求
 *
 * BeanFactory可能修改或者相互影响bean definitions，但是不会实例化bean
 * 这样做可能导致bean实例化过早，对容器产生侵入以及其他副作用
 *
 * 如果需要与Bean实例交互，考虑使用{@link BeanPostProcessor}来代替
 *
 * <h3>注册</h3>
 * ApplicationContext自动注册BeanFactoryPostProcessor的beans，并且在随后的bean的创建中应用它
 * BeanFactoryPostProcessor也可以在ConfigurableApplicationContext手动注册
 *
 * <h3>排序</h3>
 * 自动注册的根据{@link org.springframework.core.PriorityOrdered}和{@link org.springframework.core.Ordered} 来排序
 * 手动注册的根据注册顺序进行排序
 * @see BeanPostProcessor
 * @see PropertyResourceConfigurer
 */
@FunctionalInterface
public interface BeanFactoryPostProcessor {

	/**
	 * 在application context内部bean标准初始化之后进行修改
	 * 所有的bean definitions将被加载，但是没有bean会被实例化
	 * 这样可以重写或者添加bean属性即使这个bean不是懒加载
	 * @throws org.springframework.beans.BeansException in case of errors
	 */
	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
