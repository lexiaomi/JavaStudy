package com.xms.javase.day13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * 多线程并发引发的安全问题
 * 
 * 		多个线程"同时"访问操作同一个资源(临界资源)引发的安全问题
 * 解决方案：
 * 		将异步操作变成同步操作(有先后顺序)
 * 解决措施：加锁
 * 		引入一个关键字：synchronized---将异步变成同步
 * 		 static方法：
 * 			1.可以将锁加在方法上  弊端：影响程序执行效率
 * 			2.加在同步代码块上，保证锁的是同步代码块(和对象类型无关)
 * 		非static方法
 * 			1.可以将锁加在方法上，弊端：影响程序执行效率
 * 			2.加在需要同步的代码块上，保证锁的是同一个对象
 * 				锁的是this---指代当前调用的方法
 * 常见的临界资源：
 * 		1.多线程共享实例变量：
 * 		2.多线程共享静态资源变量：
 * 
 * @author Administrator
 *
 */
public class Demo02Thread {
	String name;//实例变量
	static int age;//静态变量
	
	static Object obj=new Object();
	static Lock lock=new ReentrantLock();
	
	/*
	 * 买衣服
	 * 
	 * 顾客----线程
	 * 商场----公共资源
	 * 
	 * 
	 */
	public static void main(String[] args){
		
		Thread t1=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//买衣服
				buy("A");
			}
		};
		Thread t2=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//买衣服
				buy("B");
			}
		};
		
		
		t1.start();
		t2.start();
		
		try {
			t2.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//商场---公共资源
	
	public  static void buy(String name){
		
		try {
			System.out.println(name+"进入商场");
			Thread.sleep(2000);
			
			System.out.println(name+"挑选衣服");
			
//			synchronized (obj) {
//				System.out.println(name+"进入试衣间");
//				
//				System.out.println(name+"正在试衣服");
//				Thread.sleep(3000);
//				System.out.println(name+"试完衣服，走出试衣间");
//			}
			lock.lock();
			System.out.println(name+"进入试衣间");
			System.out.println(name+"正在试衣服");
			Thread.sleep(3000);
			System.out.println(name+"试完衣服，走出试衣间");
			 
			lock.unlock();
			System.out.println(name+"结账");
			Thread.sleep(1000);
			System.out.println(name+"走出商场");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
