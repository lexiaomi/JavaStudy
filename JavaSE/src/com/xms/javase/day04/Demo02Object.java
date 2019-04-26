package com.xms.javase.day04;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Object类 ：是所有引用类型的顶级父类
 * 	该类型的引用可以指向任何类型的对象
 * @author Administrator
 *	
 *
 *	----toString():描述一个类(对象)的信息
 *		后期调试工具的
 *	equals():比较各个类型的对象，不同类型的对象比较是没有实际意义，但是是可以实现操作
 *			比较两个对象是否相似，可以根据业务需求来重写equals()方法
 *			
 *			如果两个对象在某些属性值上是相同的，则可以认为这两个对象“相等”
 */
public class Demo02Object {
	public static void main(String[] args) {
		 Student stu=new Student("zs",18,'女');
		 Student stu1=new Student("zs",18,'女');
		 //@459189e1--句柄
		 System.out.println(stu);
		 System.out.println(stu.equals(stu1));
		 
		 ArrayList<Student> al=new ArrayList<Student>();
		 System.out.println(stu.equals(al));
//		 al.add(new Student("lisi",12,'男'));
//		 al.add(new Student("liwu",22,'男'));
//		 al.add(new Student("liliu",32,'男'));
//		 
//		 Iterator<Student> it=al.iterator();
//		 while(it.hasNext()){
//			 System.out.println(it.next());
//		 }
		 
	}
}

// 学生类
class Student{

	String name;
	int age;
	char sex;
	public Student(){
		
	}
	
	public Student(String name, int age, char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String toString(){
		return "姓名:"+name+",年龄"+age+",性别"+sex;
	}
	
	
	public boolean equals(Object obj){
		if(obj==null)
			return false;
		if(this==obj)
			return true;

		if(obj instanceof Student){
			Student stu=(Student) obj;
			if(name.equals(stu.name)&&age==stu.age&&sex==stu.sex){
				return true;
			}
		}
		return false;
	}
	
	
	
}
