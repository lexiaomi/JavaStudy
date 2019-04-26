package com.xms.javase.day12;
/**
 * 异常捕捉机制：
 * 	 EXception：代码逻辑有问题(需要处理)
 * 		RuntimeException:运行时异常，不一定会捕获
 * 		NON-RuntimeException:非运行时异常，这个是
 * 	 Error：编译或者系统错误
 * 所有异常不要抛给main方法
 * 	如果抛给main,程序会直接停止运行
 * @author Administrator
 *
 */
public class Demo01Exception {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("整个程序开始了");
		System.out.println("程序1开始了");
		System.out.println("程序1正在执行");
		System.out.println("程序1结束了");
		try {
			/*
			 * 
			 * try块中出现异常，被虚拟机捕获到，而且程序员做了相应的处理，如果是捕获则会在对应的catch中是从上到下便利对相应
			 * 的错误类型，直到遍历与之相同的错位类型位置，整个遍历结束，跳出try-catch块，
			 * 
			 */
			System.out.println("程序2开始了");
			System.out.println("程序2正在执行");
			String str="";
			System.out.println("程序2结束了");
			System.out.println(str.length());
		} catch (Exception e) {
			// TODO: handle exception
			//注意：在catch块中，异常类型的排序是从上到下，顺序为从小到大
			e.printStackTrace();
		}
		System.out.println("程序3开始了");
		System.out.println("程序3正在执行");
		System.out.println("程序3结束了");
		System.out.println("整个程序结束了");
	}

}
