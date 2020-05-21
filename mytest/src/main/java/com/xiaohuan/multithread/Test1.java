package com.xiaohuan.multithread;

/**
 * <p>Title: Test1</p >
 * <p>Description: </p >
 * <p>Company: http://www.taiyuejinfu.com</p >
 * <p>Project: spring</p >
 *
 * @author: xiaohuan
 * @Date: 2020/5/19 5:34 下午
 * @Version: 1.0
 */

import java.util.LinkedList;


public class Test1 {
	//最大的数量
	private static final Integer maxCount = 5;
	//最大的数量
	private static final Integer minCount = 0;
	//弹夹总数量
	private  LinkedList<Integer> list = new LinkedList<>();

	//生产者
	public void producerIng() throws Exception {
		while (true) {
			Thread.sleep((int) (Math.random() * 10) * 100);
			synchronized (list) {
				if (list.size() < maxCount) {
					list.addLast(1);
					System.out.println(Thread.currentThread().getName() + "成功压入了一颗子弹=====现在的子弹数量" + list.size());
					list.notifyAll();
				} else {
					list.wait();
				}
			}

		}

	}

	//消费者
	public  void consumerIng() throws Exception {
		while (true) {
			Thread.sleep((int) (Math.random() * 10) * 100);
			synchronized (list) {
				if (list.size() > minCount) {
					list.removeFirst();
					System.out.println(Thread.currentThread().getName() + "成功射出了一发子弹======现在的子弹数量" + list.size());
					list.notifyAll();
				} else {
					list.wait();
				}
			}
		}

	}


}
