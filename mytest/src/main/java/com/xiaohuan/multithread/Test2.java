package com.xiaohuan.multithread;

import java.io.IOException;

/**
 * <p>Title: Test2</p >
 * <p>Description: </p >
 * <p>Company: http://www.taiyuejinfu.com</p >
 * <p>Project: spring</p >
 *
 * @author: xiaohuan
 * @Date: 2020/5/19 5:34 下午
 * @Version: 1.0
 */
public class Test2 {

	private static Test1 model = new Test1();


	public static class producer extends Thread{

		public producer(String name){
			this.setName(name);
		}

		@Override
		public void run() {

			try {
				model.producerIng();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static class consumer extends Thread{

		public consumer(String name){
			this.setName(name);
		}

		@Override
		public void run() {

			try {
				model.consumerIng();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {

//		for (int i = 0; i < 3; i++) {
//
//			new producer(String.valueOf(i)).start();
//		}
//
//		for (int i = 3; i < 6; i++) {
//
//			new consumer(String.valueOf(i)).start();
//		}
		new consumer("consumer--").start();
		new producer("prodycer--").start();
		System.in.read();
	}
}
