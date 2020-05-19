package com.xiaohuan;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * <p>Title: MyBeanFactoryPostProcessor</p >
 * <p>Description: </p >
 * <p>Company: http://www.taiyuejinfu.com</p >
 * <p>Project: spring</p >
 *
 * @author: xiaohuan
 * @Date: 2020/5/19 11:41 上午
 * @Version: 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor, ImportBeanDefinitionRegistrar {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {

	}
}
