package com.xms.javase.day05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 集合的遍历：
 * 	1.迭代器遍历
 * 	2.增强for循环
 * @author Administrator
 *
 */
public class Demo03Collection {
	public static void method1(){
		/*
		 * 迭代器遍历集合Iterator接口
		 * Java希望我们使用统一的方式来遍历集合
		 * 定义了遍历集合的接口Iterator接口
		 * 同时还定义了如何遍历集合---迭代器
		 * 使用迭代器遍历集合的步骤
		 * 	1.先获取迭代器
		 *  2.问：是否还有元素--hashNext():询问是否有下一个元素，true:有，false:没有
		 *  				
		 *  					如果指向的方向有元素，则返回值为true
		 *  					如果指向的方向没有元素，则返回值为false
		 *  3.取：如果有就取
		 *  	---next():该方法用于获取元素值，返回值类型为Object类型
		 *  		next()是基于指针的操作，每次调用该方法，指针会下移一位，指向当前元素值
		 *  			取的是当前指针指向的元素值
		 *  		
		 *  4.删除：可有可无
		 */
		
		List<Object> li=new ArrayList<Object>();
		li.add("java");
		li.add("mysql");
		li.add("css");
		li.add("html");
		li.add("js");
		li.add(new Student1("zs",18));
		//获取迭代器对象
		Iterator<Object> it=li.iterator();//返回的是迭代器对象
		while(it.hasNext()){
			
			Object obj=it.next();
			if(obj instanceof String){
				/*
				 * 在迭代器遍历集合时，不可以通过集合的相关方法，删除集合中元素
				 * 否则会出现异常 java.util.ConcurrentModificationException
				 * 只能通过迭代器的方法删除元素
				 * 
				 */
				//li.remove("js");
				if(obj.equals("js")){
					it.remove();
				}
				
			}
			System.out.println(li);
			System.out.println(obj);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		method1();
	}
}

class Student1{
	
	String name;
	int age;
	
	public Student1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student1 [age=" + age + ", name=" + name + "]";
	}
	
	
	
	
	
	
	
}
