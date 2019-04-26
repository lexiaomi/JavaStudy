package com.xms.javase.day07;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 栈：其实也叫双端队列
 * 	用来记录一组可追溯的数据
 * 	
 * 	原则：先进后出
 * 
 * 
 */
public class Demo03Deque {
	
	public static void method1(){
		//创建双端队列
		Deque<Integer> de=new LinkedList<Integer>();
		//入栈
		//压栈
		de.push(1);
		de.push(2);
		de.push(3);
		de.push(4);
		de.push(5);
		System.out.println(de);
		//出栈
		/*
		 * pop():
		 * 取出栈顶元素，同时将元素从栈中移除
		 * 返回值为对应泛型的栈顶元素
		 * 
		 */
		Integer p1 = de.pop();
		System.out.println(p1);
		System.out.println(de);
		
		/*
		 * peek();
		 * 取出元素，不做出栈操作
		 */
		Integer p2=de.peek();
		System.out.println(p2);
		System.out.println(de);
		
		//栈的遍历---一次性的
		Iterator<Integer> it = de.iterator();
		while(it.hasNext()){
			Integer ne = de.pop();
			System.out.println(ne);
		}
		System.out.println(de);
		
	}
	
	public static void main(String[] args) {
		
		method1();
		method1();		
	}
}
