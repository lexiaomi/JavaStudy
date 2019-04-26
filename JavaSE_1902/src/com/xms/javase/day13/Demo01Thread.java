package com.xms.javase.day13;
/**
 * 线程的方法
 * @author Administrator
 *
 */
public class Demo01Thread {
	/*
	 * 
	 * void join():（让线程同步，有先后顺序）
	 * 该方法用于等待当前线程结束
	 * 会抛出异常
	 * 
	 * 下载图片，下载附件
	 * 先将图片下载完，然后再下载附件
	 * 建立两个线程
	 * 
	 * 下载线程----load
	 * 展示线程----show
	 * 
	 * 如果想要下载线程执行任务库后再启动展示线程，则需要在展示线程前写入load.join()
	 * 可以达到是这两个线程先下载后展示
	 * 
	 * 
	 */
	
	public static void  method1(){
		/*
		 * method1()方法中定义了一个内部类
		 * 该内部类若想引用该方法中其他的局部变量，则该变量需要使用final修饰
		 * 
		 */
		
		final Thread load=new Thread(){
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("开始下载图片。。。。");
				for (int i =0; i <=100; i++) {
					System.out.println("已下载"+i+"%");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("图片下载完毕！！！！");
			}
			
		};
		Thread show =new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					/*
					 * 这里是等待下载线程结束后，再执行展示线程
					 * 
					 */
					load.join();
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
	
	public static void main(String[] args) {
		method1();
	}
}
