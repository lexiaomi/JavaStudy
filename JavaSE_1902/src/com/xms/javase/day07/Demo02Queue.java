package com.xms.javase.day07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列：Queue;
 * 	是一种特殊的线性结构，他限制了对线性表的访问，
 * 	从一端进，一端出
 * 	结构特点：先进先出
 * 
 * @author Administrator
 *
 */
public class Demo02Queue {
	public static void method1(){
		/*
		 * 选择linkedList作为实现类，主要是因为Queue经常要做添加和删除的操作，LinkedList在这方面的性能较为优越
		 */
		Queue<String> qu=new LinkedList<String>();
		//入队操作，把元素添加到队尾
		/*
		 * offer():
		 * 入队操作，将元素添加队尾
		 * 返回值为boolean类型
		 */
		boolean of1 = qu.offer("qwer1");
		boolean of2 = qu.offer("qwer2");
		boolean of3 = qu.offer("qwer3");
		
		System.out.println(qu);
		
		//出队操作
		/*
		 * poll():
		 * 取出队首，取出后，队列中就没有元素了
		 * 返回值：为取出对应泛型的元素
		 * 注意：按照顺序取出队首元素才能取出之后的元素
		 * 
		 */
		
		String s1 = qu.poll();
		System.out.println(s1);
		System.out.println(qu);

		/*
		 * peek():
		 * 该方法只是取出队首的引用，不做出队操作
		 * 
		 */
		String p1= qu.peek();
		System.out.println(p1);
		System.out.println(qu);
		
		/*
		 * 队列的遍历：一次性的
		 */
		System.out.println("--------------");
		while(qu.size()>0){
			String p2=qu.poll();
			System.out.println(p2);
		}
		
		System.out.println(qu);

	}
	
	public static void method2(){
		
	}
	public static void main(String[] args) {
		method1();
	}
}
