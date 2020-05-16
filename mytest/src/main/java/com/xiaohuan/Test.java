package com.xiaohuan;

import com.xiaohuan.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(IndexDao.class);
		context.refresh();
		IndexDao dao = context.getBean(IndexDao.class);
		dao.query();
	}
}
