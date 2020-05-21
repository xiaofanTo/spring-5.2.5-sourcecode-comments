package com.xiaohuan;

import com.xiaohuan.dao.BaseDao;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>Title: MyFactoryBean</p >
 * <p>Description: </p >
 * <p>Company: http://www.taiyuejinfu.com</p >
 * <p>Project: spring</p >
 *
 * @author: xiaohuan
 * @Date: 2020/5/19 2:19 下午
 * @Version: 1.0
 */
@Component
public class MyFactoryBean implements InvocationHandler, FactoryBean {

//	Class clazz;
//
//	public MyFactoryBean(Class clazz) {
//		this.clazz = clazz;
//	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy");
		return null;
	}

	@Override
	public Object getObject() throws Exception {
		BaseDao baseDao = (BaseDao) Proxy.newProxyInstance(BaseDao.class.getClassLoader(), new Class[]{BaseDao.class}, this);
		return baseDao;
	}

	@Override
	public Class<?> getObjectType() {
		return BaseDao.class;
	}
}
