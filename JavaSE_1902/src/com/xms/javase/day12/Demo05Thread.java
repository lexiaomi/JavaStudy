package com.xms.javase.day12;

import java.lang.Thread.State;

public class Demo05Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread t1=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				for (int i = 0; i < 50; i++) {
					System.out.println("你好");
				}
			}
		};
		t1.start();
		/*
		 * currentThread()
		 * 	查看当前的线程，返回值为Thread类型
		 * 	Thread[main,5,main]  
		 * 		   线程名  线程优先级  当前的线程组
		 */
		Thread t=Thread.currentThread();
		System.out.println(t);
		
		/*
		 * 
		 * 
		 * getId() :获取当前线程的标识符
		 * 返回值为long类型，获取的id为
		 * 系统随机分配，不重复
		 */
		
		
		long id = t.getId();
		System.out.println(id);
		
		/*
		 * getName():
		 *	返回当前线程的名称，返回值为String类型
		 */
		String name = t.getName();
		System.out.println(name);
		
		/*
		 * getPriority():返回当前线程的优先级
		 * 
		 * 
		 *线程的优先级(1-10)：等级越高。cpu优先分配时间片的概率越大,1为最低，10为最高
		 *线程的切换是由线程调度控制，无法通过代码来干涉，可以提高线程的优先级来最大化的改善线程获取时间片的概率
		 *
		 *改变线程的优先级： setPriority(int n)
		 *--n(1-10)
		 *
		 *还有三个常量
		 *	最高等级: Thread.MAX_PRIORITY 10
		 *	最低等级: Thread.MIN_PRIORITY 1
		 *	正常等级: Thread.NORM_PRIORITY 5
		 */
		int priority = t.getPriority();//获取线程的优先级
		System.out.println(priority);
		
		t.setPriority(10);//设置线程优先级
		int pri2 = t.getPriority();
		System.out.println(pri2);
		
		/*
		 * getState():
		 * 获取线程状态，返回值为.Thread.State类型（线程状态）
		 * 
		 */
		State state = t.getState();
		System.out.println(state);
		
		/*
		 * isAlive():
		 * 判断线程是否处于活动状态
		 * 返回值boolean类型 true：活动状态   false:停止
		 */
		boolean alive = t.isAlive();
		System.out.println(alive);
		
		boolean daem = t1.isDaemon();
		System.out.println(daem);
		
	}

}

