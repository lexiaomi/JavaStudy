package com.xms.javase.day12;
/**
 * Thread:
 * 	线程：
 * 	进程：操作系统中运行的一个任务
 * 	进程是包含了某些共同资源的内存区域，操作利用进程把其他的工作化为一些功能单元
 * 	
 * 	进程中包含的一个或者多个的执行单元叫做线程，线程只能归属一个进程，并且只能访问该进程所拥有的资源
 * 
 * 1.一个进程至少有一个进程
 * 2.线程的划分尺度要小于进程，使得多线程的并发性高，另外进程在执行过程中拥有独立的内存单元，而多个线程共享
 * 	      该线程单元，从而大大提高了，程序的运行效率和资源利用率
 * 3.多线程的意义在于一个应用程序中，有多个执行部分可以同时执行，但是操作系统并没有将多个线程看做独立的应用来实现
 * 	      调度和管理以及分配资源
 * 
 * 线程使用场景：
 * 	   1.线程通常在一个应用程序中，有需要同时完成多个任务的情况，
 * 			那么我们可以将每个任务定义为一个线程，使得它们一同工作
 * 	   2.也可以使用单一线程完成但是可以达到更快的完成
 * 
 * 
 * 并发原理：
 * 		多个线程"同时"运行只是我们感官上的一种表现，事实上是并发执行
 * 		   线程调度(os)将时间片尽可能均匀划分成很多时间片，随机分配给每一个线程，
 * 		获得时间片的线程被CPU执行，其他线程全部等待，所以微观上是走走停停，宏观上都是在运行，
 * 			这种现象叫做并发，但是不是绝对意义上的"同时发生"
 * 
 * 
 * 如何创建线程：
 * 	1.继承Thread
 * 	2.实现Runnable接口  ----任务接口(比较常用)
 *  3.创建线程池
 * 
 * 同步：有先后顺序的执行方法
 * 
 * 异步：各自执行各自的内容（任务），互不干扰，可以一起进行，
 * 
 * @author Administrator
 *
 */
public class Demo04Thread {
	public static void main(String[] args) {
		//同步执行，有先后顺序
//		
//		Thread1 t1=new Thread1();
//		Thread2 t2=new Thread2();
		/*
		 * 启动线程
		 * 不是调用run方法，而是调用线程中的start()方法
		 * 并不是谁先start，谁就执行，而是需要分配到对应的时间片，分配到时间片的线程才正式开始执行任务
		 */
		
		//t1.start();
		//t2.start();
		
		Runnable1 run1=new Runnable1();
		Runnable run2=new Runnable2();
		//创建线程，用线程搭载任务队列
		Thread tt1=new Thread(run1);
		Thread tt2=new Thread(run2);
		tt1.start();
		tt2.start();
	}
}

//继承Thread类

class Thread1 extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("你好吗？"+Thread.currentThread().getPriority()+i);
		}
		
	}
	
}
class Thread2 extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("我很好，你呢！！！"+Thread.currentThread().getName()+"----"+i);
		}
		
	}
	
}


//实现Runnable接口----任务类

class Runnable1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			System.out.println("你好吗？"+Thread.currentThread().getPriority()+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


class Runnable2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			System.out.println("我很好，你呢！！！"+Thread.currentThread().getPriority()+"----"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
