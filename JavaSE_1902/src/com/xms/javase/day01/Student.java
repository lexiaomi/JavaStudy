package com.xms.javase.day01;
/**
 * 这是一个学生类，继承自Person类
 * @author 李丽君
 * @see java.lang.String
 *
 */
public class Student extends Person {
	
	long id;
	public Student(){
		
	}
	public Student(String name,int age,long id){
		super(name,age);
	}
	/**
	 * 传入id的值，
	 * 返回的是 学生id号
	 * @param id
	 * @return
	 */
	public long retu(long id){
		return id;
		
	}
}
