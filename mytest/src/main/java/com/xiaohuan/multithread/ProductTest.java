package com.xiaohuan.multithread;

/**
 * <p>Title: ProductTest</p >
 * <p>Description: </p >
 * <p>Company: http://www.taiyuejinfu.com</p >
 * <p>Project: spring</p >
 *
 * @author: xiaohuan
 * @Date: 2020/5/19 6:08 下午
 * @Version: 1.0
 */
public class ProductTest {

	public static void main(String[] args) {

		Clerk clerk = new Clerk();
		Producter producter = new Producter(clerk);
		Consumer consumer = new Consumer(clerk);
		Thread thread1 = new Thread(producter);
		thread1.setName("生产者");
		Thread thread2 = new Thread(consumer);
		thread2.setName("消费者");
		thread1.start();
		thread2.start();

	}

	public static class Clerk {
		// 产品数量
		int productNums = 0;

		// 利用下城,增加产品数量,店员获取到的数量达到100个后，将不会继续增加。就等待消费者来取东西了
		public synchronized void addProduct() {

			if (productNums >= 100) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				productNums = productNums + 1;
				System.out.println(Thread.currentThread().getName() + ":" + "添加了第" + productNums + "个产品");
				notify();// 产品数量没到上线，通知其他线程来进行存或则取
			}
		}

		public synchronized void getProduct() {
			if (productNums <= 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(Thread.currentThread().getName() + ":" + "买走了第" + productNums + "个产品");
				productNums = productNums - 1;
				notifyAll();// 产品数量没到下线，通知其他线程来进行存或则取
			}
		}
	}

	// 生产者要执行的线程
	public static class Producter implements Runnable {

		private Clerk clerk;

		public Producter(Clerk clerk) {
			this.clerk = clerk;
		}

		@Override
		public void run() {
			while (true) {
				try {
					// 不知道什么时候生产者回来添加产品,所以用一个随机时间来让进行线程随眠,来模仿生产者来访的不定时
					Thread.sleep((int) (Math.random() * 10) * 100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				clerk.addProduct();
			}
		}
	}

	// 消费者需要执行的线程
	public static class Consumer implements Runnable {

		private Clerk clerk;

		public Consumer(Clerk clerk) {
			this.clerk = clerk;
		}

		@Override
		public void run() {

			while (true) {
				try {
					// 不知道什么时候消费者回来添加产品,所以用一个随机时间来让进行线程随眠,来模仿消费者来访的不定时
					Thread.sleep((int) (Math.random() * 10) * 100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				clerk.getProduct();
			}
		}
	}
}
