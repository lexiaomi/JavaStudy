package com.xms.javase.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * List集合:有序可重复的集合
 * 是可以通过元素下标来操作元素(0开始)
 * 	实现类：
 * 		ArrayList: 数组结构，检索(查询)效率高，
 *		LinkedList: 链表结构 ，插入删除的效率高，
 *			---这些特点在处理数据量较大的时候，差异较为明显
 *			
 * @author Administrator
 */

public class Demo01List {
	
	
	public static void method1(){
		//创建List对象
		List<String> li=new ArrayList<String>();
		li.add("a");
		li.add("b");
		li.add("c");
		li.add("d");
		li.add("e");
		//System.out.println(li);
		/*
		 * get(int index)
		 * 该方法通过元素下标来获取元素
		 * （下标的位置和元素添加的顺序一致）
		 * 返回值为集合泛型的元素值
		 */
		String s1=li.get(0);
		System.out.println(s1);
		/*
		 * 传统for循环遍历集合
		 * 
		 */
		System.out.println("---------------------");
		for(int i=0;i<li.size();i++){
			String ss=li.get(i);
			System.out.println(ss);
		}
		
		/*
		 * set(int index,<T> t):修改或赋值
		 * 使用t元素，替换对应位置上(index)的元素返回值为被替换的元素
		 */
		System.out.println("---------------------");
		String value=li.set(0, "A");
		System.out.println(value);
		System.out.println(li);
		
		/*
		 * add(index,<T> t):
		 * 元素插入的方法
		 * 将给定的元素t,插入到index的位置上，index上原有的以及后面的元素，都会一次向后移动
		 */
		System.out.println("---------------------");
		li.add(1, "B");
		System.out.println(li);
		
		/*
		 * remove(int index)
		 * 移除指定位置上的元素，返回值为被移除的元素
		 * 
		 */
		System.out.println("---------------------");
		String ss2=li.remove(2);
		System.out.println(ss2);
		System.out.println(li);
		
		
	}
	
	public static void test(){
		List<String> li=new ArrayList<String>();
		
		li.add("java");
		li.add("mysql");
		li.add("jsp");
		li.add("html");
		li.add("css");
		li.add("servlet");
	}
	
	public static void main(String[] args) {
		method1();
	}
}
