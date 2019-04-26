package com.xms.javase.day13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo03Thread {
	String name;//实例变量
	static int age;//静态变量
	
	//static Object obj=new Object();
//	static Lock lock=new ReentrantLock();
	
	/*
	 * 买衣服
	 * 
	 * 顾客----线程
	 * 商场----公共资源
	 * 
	 * 
	 */
	public static void main(String[] args){
		final Demo03Thread demo=new Demo03Thread();
		
		
		Thread t1=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//买衣服
				demo.buy("A");
			}
		};
		Thread t2=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//买衣服
				demo.buy("B");
			}
		};
		
		
		t1.start();
		t2.start();
		
	}
	
	//商场---公共资源
	
	public  void buy(String name){
		
		try {
			System.out.println(name+"进入商场");
			Thread.sleep(2000);
			
			System.out.println(name+"挑选衣服");
			
			synchronized (this) {
				System.out.println(name+"进入试衣间");
				System.out.println(name+"正在试衣服");
				Thread.sleep(3000);
				System.out.println(name+"试完衣服，走出试衣间");
			}
			 
			System.out.println(name+"结账");
			Thread.sleep(1000);
			System.out.println(name+"走出商场");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
