package com.xms.javase.day01;
/**
 * 这个是父类 --Person类
 * @author Administrator
 * @version 1.2
 * 
 *
 */
public class Person {
	String name;
	int age;

	/**
	 * 无参构造方法
	 */
	public Person(){
		
	}
	/**
	 * 有参构造方法， 初始化
	 * @param name 
	 * @param age
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * 这是一个吃的方法，没有返回值
	 * 
	 */
	public void eat(){
		System.out.println("吃");
	}
	/**
	 * name的get方法，返回的是一个name的值
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * name的set方法，参数是String类型的，提交name的值
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * age的get方法，返回的是一个age的值
	 * @return
	 */
	
	public int getAge() {
		return age;
	}
	/**
	 * age的set方法，参数是int类型的，提交age的值
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
