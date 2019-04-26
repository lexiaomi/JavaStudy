
package com.xms.javase.day13;
/**
 * 多线程访问公共资源出现的安全问题
 * 	在临界值发生的安全问题：
 * 		1.多线程共享实例变量
 * 		2.多线程共享静态变量
 * 解决方式：异步操作变成同步操作
 * 
 * 	
 * 
 * @author Administrator
 *
 */
public class Demo05Thread {
	static Object obj=new Object();
	static int beans=100;
	public static void main(String[] args) {
		Thread t1=new Thread(){
			@Override
			public void run() {
				while(true){
					System.out.println("t1在抢"+getBeans());
				}
			}
		};
		Thread t2=new Thread(){
			@Override
			public void run() {
				while(true){                             
					System.out.println("t2在抢"+getBeans());
				}
			}
		};
		t1.start();
		t2.start();
		
	}
	
	public  static int getBeans(){
		synchronized (obj) {
			if(beans==0){
				throw new RuntimeException("没有豆子");                                                                                     
			}
			/*
			 * 出让当前线程的时间片，使当前线程重新进入Runnable状态
			 * 等待分配时间片，提高多线程并发的出错率
			 * 
			 */
			Thread.yield();
			
			return beans--;
		}
		
		
	}
}
