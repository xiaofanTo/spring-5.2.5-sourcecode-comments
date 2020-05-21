package com.xiaohuan.factorybean;

import com.xiaohuan.dao.IndexDao;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * <p>Title: CustomerFactoryBean</p >
 * <p>Description: </p >
 * <p>Company: http://www.taiyuejinfu.com</p >
 * <p>Project: spring</p >
 *
 * @author: xiaohuan
 * @Date: 2020/5/19 2:40 下午
 * @Version: 1.0
 */
//@Component
public class CustomerFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return new IndexDao();
	}

	@Override
	public Class<?> getObjectType() {
		return IndexDao.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
