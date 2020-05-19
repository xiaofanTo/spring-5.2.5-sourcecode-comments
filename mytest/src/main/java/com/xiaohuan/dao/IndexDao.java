package com.xiaohuan.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

/**
 * <p>Title: IndexDao</p >
 * <p>Description: </p >
 * <p>Company: http://www.taiyuejinfu.com</p >
 * <p>Project: spring</p >
 *
 * @author: xiaohuan
 * @Date: 2020/5/16 11:31 上午
 * @Version: 1.0
 */
@Repository
public class IndexDao implements ApplicationContextAware {
	private ApplicationContext context;
	public void query() {
		System.out.println(context);
		System.out.println("IndexDao query");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
}
