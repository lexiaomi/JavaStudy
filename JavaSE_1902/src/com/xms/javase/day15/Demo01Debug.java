package com.xms.javase.day15;
/**
 * 调式方式：
 * 	打桩--输出语句
 * 	断点调试(Debug)--推崇
 * 	区域介绍：
 * 	  1.debug调式，显示当前正在调试的代码	
 * 	  2.Variables变量区域，显示当前变量的值
 * 	  3.代码编辑区，方便正在观看的执行代码
 * 	  4.代码结构区，显示调试代码的方法，数据
 * 	  5.Console控制台区域
 *  
 *  F5:单步执行,(会进入函数或者方法中)
 * 	F6:单步执行(结构代码的单步执行，不进入函数或者方法中)
 * 	F7:由函数/方法内部返回---跳出方法
 *  F8:一直执行到下一个断点(连续执行)
 * @author Administrator
 *
 */
public class Demo01Debug {
	public static void main(String[] args) {
		Student stu=new Student("zs",18,'男');
		for(int i=0;i<10;i++){
			System.out.println("-----------"+i+"-------");
			stu.add();
			int num=stu.add(1,2);
			System.out.println(num);
			if(i==5){
				stu=null;
				int num1=stu.add(1,2);
				System.out.println(num1);
				
				break;
			}
			System.out.println(stu.name);
			System.out.println(stu.age);
			System.out.println(stu.sex);
			
		}
		
	}
}


//学生类

class Student{
	String name;
	int age;
	char sex;
	
	//构造方法
	public Student(){
		
	}
	public Student(String name,int age,char sex){
		super();
		this.name=name;
		this.age=age;
		this.sex=sex;
		
	}
	
	public void add(){
		System.out.println("addd");
	}
	
	public int add(int a,int b){
		System.out.println("add(int a,int b)");
		return a+b;
	}
	
	
	
}