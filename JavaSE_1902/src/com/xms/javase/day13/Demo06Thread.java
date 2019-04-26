package com.xms.javase.day13;
/**
 * 多线程之间的协同工作
 * 	下载图片，下载附件展示图片
 * 
 * load----下载线程(下载图片，下载附件)
 * show---展示线程(展示图片)
 * 
 * 先下载图片，图片下载完后，随机展示图片或者下载附件
 * (下载图片)与(下载附件展示图片)是同步
 * 下载和附件展示图片是异步
 * 
 * 
 * wait():使当前线程进入等待阻塞状态，需要使用线程唤醒的方法，将其释放，
 * 释放后会进入Runnable状态，如果没有线程阻塞释放的方法，则会一致阻塞下去
 * 
 * notify():唤醒当前等待线程中的某一个线程(随机)，
 * 
 * notifyAll():唤醒当前等待队列中的所有线程，
 * wait和sleep的区别:
 * 1.两个方法都是进入阻塞状态的方法
 * 2.sleep:使当前线程进入阻塞状态指定毫秒，等到指定毫秒后，然后自动释放，进入Runnable状态等待分配时间片
 * wait:使当前线程进入阻塞状态，而这个状态会一直持续下去，直到对应的方法将其唤醒，才会释放，此时才会进入Runnable状态，等待分配时间片
 * @author Administrator
 *
 */
public class Demo06Thread {
	public static void method1(){

		final Object obj=new Object();
		boolean flag=false;
		final Thread load=new Thread(){
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("开始下载图片。。。。");
			for (int i =0; i <=100; i++) {
				System.out.println("图片已下载"+i+"%");
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("图片下载完毕！！！！");
			
			/*
			 * 在該位置將展示線程啟動，
			 * 
			 */
			/*
			 * 在Java编译手册中规定，在使用这两个方法时，需要加上相应的synchronized 来保证等待和唤醒的安全
			 */
			synchronized (obj) {
				obj.notify();
			}
			System.out.println("下载附件");
			for (int i = 0; i <=100; i++) {
				try {
					System.out.println("附件已下载"+i+"%");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("附件下载完成");
		}
		
	};
	Thread show =new Thread(){
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				/*
				 * 这里是等待下载线程结束后，再执行展示线程
				 * 在该位置应该等待下载线程中的图片下载完成 
				 * 然后再启动
				 * 
				 */
				synchronized (obj) {
					obj.wait();
				}
//				load.join();
				System.out.println("开始展示图片");
				
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("展示完毕");
		}
	};
	
	load.start();
	show.start();

	}
	
	/*
	 * 创建两个线程
	 * 一个打印(A-Z)
	 * 一个打印数字
	 */
	
	public static void method2(){
		final Object obj=new Object();
		//打印(A-Z)的线程
		Thread t1=new Thread(){
			@Override
			public void run() {
				
				for(int i=65;i<=90;i++){
				
					System.out.print((char)i);
					if(i%2==0){
//							Thread.sleep(1000);
						try {
							synchronized (obj) {
								obj.wait();
							}
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
				
			}
		};
		//打印数字的线程
		Thread t2=new Thread(){
			@Override
			public void run() {
				for(int i=1;i<14;i++){
					
					System.out.print(i);
					
					try {
						Thread.sleep(1000);
						synchronized (obj) {
							obj.wait();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t2.setDaemon(true);
		t1.start();
		t2.start();
		
	}
	
	public static void main(String[] args) {
		method1();
//		method2();
	}
}
