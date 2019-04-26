package com.xms.javase.day06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collections:是一个关于Collection接口集合的工具类
 * 里面封装着关于集合特定的操作方法
 * sort(List<T> list):
 * 	按照默认的排序顺序，给给定的集合进行排序--数据展示
 * 
 * 1.排序接口：comparable 
 * 		排序接口，相当于"内部比较器"若一个类实现该接口，
 * 		意味着该类的对象支持排序，该类的对象拥有着比较资格
 * 但是需要重新定义比较规则，即重写 compareTo方法
 * 		sort(List<T> list)
 * 
 * 2.Comparator
 * 		比较器，相当于"外部比较器"，不同修改源码，实现另外一个比较器
 * 		当对象需要比较时，将集合对象和比较器一起传入对应的方法即可
 * 		---sort(List<T> list,comparator mycom)
 * 
 * @author Administrator
 *
 */
public class Demo02Collections {
	
	public static void method1(){
		
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(1);
		list1.add(3);
		list1.add(2);
		list1.add(6);
		list1.add(4);
		list1.add(9);
		
		//System.out.println(list1);
		Collections.sort(list1);
		System.out.println(list1);
		
		List<String> list2=new ArrayList<String>();
		list2.add("zhangsan");
		list2.add("lisi");
		list2.add("wangwu");
		list2.add("zhaoliu");
		
		Collections.sort(list2);
		System.out.println(list2);
	}
	
	public static void method2(){
		
		List<Student> li=new ArrayList<Student>();
		li.add(new Student("zhangsan\t",19,'男',001));
		li.add(new Student("cf\t",22,'女',004));
		li.add(new Student("wangwu\t",16,'男',003));
		li.add(new Student("zhaoliu\t",21,'男',005));
		li.add(new Student("lss\t",19,'女',002));
		li.add(new Student("cq\t",16,'女',012));
		li.add(new Student("zl\t",5,'女',102));
		//System.out.println(li);
		Collections.sort(li);
		System.out.println("----------姓名长度---------------");
		for (Student stu : li) {
			System.out.println(stu);
		}
		System.out.println("----------年龄大小-(外部比较器)-Comparator-------------");
		
		//创建外部比较器对象
		// 在不修改内部比较器源码的情况下，按照自己所需的方式定义外部比较器
		MyComparator my=new MyComparator();
		//sort(List<T> list,comparator mycom)
		/*
		 * list:要排序的集合
		 * mycom:比较器对象
		 */
		Collections.sort(li,my);
		for (Student stu : li) {
			System.out.println(stu);
		}
		
		System.out.println("-------comparator 匿名内部类方式--------------");
		
		Comparator<Student> mycom =new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				
				return o1.id-o2.id;
			}
		
		};
		Collections.sort(li,mycom);
		for (Student stu1 : li) {
			System.out.println(stu1);
		}
	}
	
	public static void main(String[] args) {
//		method1();
		method2();
	}
}







class Student implements Comparable<Student>{
	String name;
	int age;
	char sex;
	int id;
	
	public Student(){
		
	}
	
	public Student(String name, int age,char sex, int id) {
		this.name = name;
		this.age = age;
		this.sex=sex;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex
				+ ", id=" + id + "]";
	}

	@Override
	public int compareTo(Student o) {
		/*
		 * 
		 * 实现Comparable接口
		 * 定义比较规则：---自定义
		 * 
		 * 该方法用于是当前对象与给定的对象进行比较
		 * 该方法返回值为int类型，与值的大小无关
		 * 只是与值的正负有关
		 * 1.若当前的对象大于给定的对象，返回值为大于0的数  ---什序
		 * 2.若当前的对象小于给定的对象，返回值为小于0的数 ---降序
		 * 3.若当前的对象等于于给定的对象，返回值为等于0的数 --- 顺序不变
		 * 
		 */
		//比较规则
	//	return name.compareTo(o.name);.
	  return name.length()-o.name.length();
//		if(name.length()-o.name.length()!=0){
//			return name.length()-o.name.length();
//		}else{
//			return age-o.age;
//		}
		
		
	}
	
	
}

class MyComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		/*
		 * 实现Comparator接口
		 * 定义比较规则：---自定义
		 * 
		 * 该方法用于是当前对象与给定的对象进行比较
		 * 该方法返回值为int类型，与值的大小无关
		 * 只是与值的正负有关
		 * 1.若当前的对象大于给定的对象，返回值为大于0的数  ---什序
		 * 2.若当前的对象小于给定的对象，返回值为小于0的数 ---降序
		 * 3.若当前的对象等于于给定的对象，返回值为等于0的数 --- 顺序不变
		 */
		return o1.age-o2.age;
	}
	
}






