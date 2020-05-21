package com.xiaohuan;

import com.sun.tools.javac.code.Attribute;
import com.xiaohuan.dao.BaseDao;
import com.xiaohuan.dao.IndexDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * <p>Title: test</p >
 * <p>Description: </p >
 * <p>Company: http://www.taiyuejinfu.com</p >
 * <p>Project: spring</p >
 *
 * @author: xiaohuan
 * @Date: 2020/5/16 11:27 上午
 * @Version: 1.0
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BaseDao dao = (BaseDao) context.getBean("baseDao");
		dao.query();
		AppConfig appConfig = (AppConfig) context.getBean("appConfig");
		System.out.println("test");


		context.refresh();
//		context.register(AppConfig.class);
//		context.refresh();
//		IndexDao dao = context.getBean(IndexDao.class);
//		dao.query();


		//ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext();

	}
}
