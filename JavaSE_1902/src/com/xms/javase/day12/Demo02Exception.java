package com.xms.javase.day12;
/**
 * 抛出：
 * 	throws:
 * 		加在方法的的声明上。提示调用者该方法可能会出现某些异常
 * 		1.用try-catch
 * 		2.抛出throws
 * @author Administrator
 *
 */
public class Demo02Exception {
	public static void main(String[] args) {
		Student s=new Student();
		try {
			s.setAge(230);
			System.out.println(s.getAge());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("苏韵锦你欠我的用什么还");
	}
}

class Student{
	
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age){
		if(age<0||age>200){
			throw new RuntimeException("年龄在0-200之间");
		}
		
		this.age = age;
	}
	
	
	
}
