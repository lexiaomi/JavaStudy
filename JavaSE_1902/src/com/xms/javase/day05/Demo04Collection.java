package com.xms.javase.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * foreach:增强for循环遍历
 * 			Java5.0出现的新特性
 * 
 * 该循环不通用于传统for循环
 * 	只用于遍历集合和数组
 * 	语法：for(元素类型  元素名：集合或者数组名){
 * 			逻辑体
 * 		}
 * 
 * @author Administrator
 *
 */
public class Demo04Collection {
	public static void method1(){
		int[] arr=new int[]{1,2,3,4,5,6,7};
		//传统for循环
		for(int i=0;i<arr.length;i++){
			int a=arr[i];
			System.out.println(a);
		}
		
		System.out.println("--------------------");
		//增强型for循环
		for(int a:arr){
			System.out.println(a);
		}
	}
	
	public static void method2(){
		List li=new ArrayList();
		li.add("java");
		li.add("jsp");
		li.add("mysql");
		li.add("css");
		li.add(12);
		for (Object obj : li) {
			System.out.println(obj);
			/*
			 * 增强型for循环不是新语法，只是在编译时生成.class文件时，将新循环转化成迭代器，所以在遍历的时候
			 * 	不能使用集合中的方法
			 * ---本质就是迭代器
			 * 
			 * 在遍历的过程不允许使用集合的方法
			 * 删除集合中的元素
			 */
			
		//	li.remove(12); java.lang.IndexOutOfBoundsException:
		}
		
		
	}
	public static void main(String[] args) {
//		method1();
		method2();
	}
}
