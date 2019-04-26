package com.xms.javase.day14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：
 * 		ExecutorsService是Java提供的管理线程池的接口
 * 	
 * 	当一个程序中若大量创建线程，并在任务结束时销毁，会给系统造成过度的资源消耗，
 * 	从而导致系统奔溃，为此我们应该使用线程池解决这个问题
 * 	线程池的作用：
 * 		1.控制线程的数量
 * 		2.重用线程
 * 			
 * 创建线程池的方式：
 * 		Executors.newCachedThreadPool(int threadFactory)
 * 		创建可根据需要创建新线程的线程池，但是在以前构造的线程可用是，将重用它们
 * 		Executors.newFixedThreadPool(int nThreads)----比较常用
 * 		创建一个可重用的固定线程的线程池，以无界队列的方式来运行这些线程
 * 		newScheduledThreadPool(int corePoolSize)
 * 		创建一个线程池，他可安排在给定延迟后运行或者定期执行
 * 
 * 		newSingleThreadExecutor() 
 * 		创建一个使用单个 线程的 线程池，以无界队列方式来运行该线程。
 * 		
 * 
 * @author Administrator
 *
 */
public class Demo01Thread {
	public static void main(String[] args) {
		
		//创建线程池的对象
		ExecutorService pool=Executors.newFixedThreadPool(2);
		//创建任务，创建匿名内部类
		Runnable run1=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i <=5; i++) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		};
		Runnable run2=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i <=5; i++) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		};
		
		//将任务纳入到线程池中
		/*
		 * 
		 * excute(Runnable run)
		 * 该方法将指定任务纳入到当前的线程池
		 * 进行统一的管理(任务搭载，启动线程)
		 */
		
		pool.execute(run1); 
		pool.execute(run2); 
		
	}
}
