package com.xms.javase.day05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 集合：
 * 	新的数据结构，可以保存不同类型的元素，而且动态拓展
 * 集合的由来：
 * 	数组定义，数组的长度固定，不可更改，当添加的元素超过了
 * 	数组定义的长度，就需要重新定义数组，只能保存相同类型的元素，这样做过于麻烦，引入集合
 * 
 * Java内部给我们提供了集合类，该类的实例可以存任意对象，长度是可以动态改变
 * 	随着元素的增加或者减少而改变空间大小
 * 
 * 集合和数组的区别
 * 	1.数组既可以存基本类型数据，也可以存引用类型数据
 * 			基本类型存的是 值，引用类型存的是地址值
 *  2.集合只能存储引用类型的数据，存储的是地址值，在存储基本数据类型的数据时，
 *  	会将数据自动装箱成引用类型存入集合
 *  3.数组的长度是固定的，不能自动增减
 *  	集合的长度(长度)是不定的，可以随着元素的增减而改变大小
 *  
 *  使用场景：
 *  	1.如果元素的个数是固定不变的--使用数组
 *  	2.如果元素的个数是不确定的---使用集合
 *  
 *  
 *  集合的继承体系：
 *  	父接口：Collection----(Collections，关于集合的工具类)
 *  	子接口：List --有序集合，可以重复
 *  			下标操作元素，存取有顺序
 *  		实现类：ArrayList: 数组式(数组实现)
 *  			 LinkedList:链表式(链表式)
 *  			 Vector: 数组式(数组实现)
 *  	
 *  	子接口： Set --无序集合(部分有序)，不可重复的
 *  			   元素值存和取是不一样的，元素值不能重复
 *  		实现类：---HashSet:哈希算法
 *  				---TreeSet：二叉树算法
 *  		
 *  集合的基本操作：
 *  	增加：
 *  		boolean add(E e):添加一个元素到集合中
 *  	删除：
 *  		boolean remove(Object obj):删除指定元素
 *  		void clear(): 清除集合中所有元素
 *  	查询(获取)：
 *  		int size():获取集合的大小
 *  		E get():返回此列表中指定位置上的元素。
 *  	修改：
 *  		
 *  	判断：
 *  		bollean isEmpty(): 判断集合是否为空
 *  		boolean contains(Object obj):判断集合中是否包含指定元素
 *  	
 *  	
 *  	
 *  	
 *  	
 *  
 *  		
 * @author Administrator
 *
 */
public class Demo02Collection {
	
	public static void method1(){
		
		Student s1=new Student("zs",18,1);
		Student s2=new Student("ls",18,3);
		Student s3=new Student("ww",18,2);
		
		Student[] stu=new Student[]{s1,s2,s3};
		
		
		
	}
	
	public static void method2(){
		
		//创建集合实例
		Collection<Object> c=new ArrayList<Object>();
			
		List c1=new ArrayList();
		Collection c2=new ArrayList();
		//添加元素
		Student s=new Student("sd",12,1);
		c.add("a");
		c.add("a");
		c.add(1);
		c.add(s);
		c.add("dcs");
		System.out.println(c);
		//获取集合大小 size()
		int len=c.size();
		System.out.println(len);
		System.out.println("------------------------------");
		//remove(Object obj)
		/**
		 * 移除第一次equals()比较为trued的元素
		 * true：表示移除
		 * false:表示没有
		 * 
		 */
		c.remove("a");
		System.out.println(c);
		/*判断一个集合是否包含指定元素
		 * contains(Object obj)
		 *使用equals()比较为true,则表示为同一个元素
		 * true:表示包含
		 * false:表示不包含
		 *  
		 */
		boolean bo3=c.contains("a");
		System.out.println(bo3);
		boolean bo4=c.contains("c");
		System.out.println(bo4);
		boolean bo5=c.contains(new Student("sd",12,1));
		System.out.println(bo5);
		
		//清除集合中所有的元素
		c.clear();
		System.out.println(c.size());
		c.add(null);//判断集合是不是空
		System.out.println(c.size());
		//判断集合是不是空
		/*
		 *true：集合为空
		 *false:集合不为空
		 * 
		 */
		boolean bo6=c.isEmpty();
		System.out.println(bo6);
	}
	
	public static void method3(){
		/*
		 * 集合的批量操作
		 * boolean addAll(Collection c):添加一个集合
		 * boolean removeAll(Collection c):删除一个集合
		 * boolean containsAll(Collection c)：判断当前集合是否包含指定集合
		 */
		
		List<Object> c1=new ArrayList<Object>();
		c1.add(1);
		c1.add(2);
		List<Object> c2=new ArrayList<Object>();
		c2.add(3);
		c2.add(4);
		List<Object> c3=new ArrayList<Object>();
		c3.add(5);
		c3.add(6);
		
		//将给定的集合添加到当前集合中
		// c1添加到c2中
		c2.addAll(c1);
		//c2.addAll(c3);
		System.out.println(c2);
		System.out.println(c1);
		System.out.println(c3);
		//判断当前集合是否包含指定集合
		//全部包含
		boolean bo1=c2.containsAll(c1);
		System.out.println(bo1);
		//删除集合中指定集合
		boolean bo2=c2.removeAll(c1);
		boolean bo3=c2.removeAll(c3);
		System.out.println(bo2);
		System.out.println("-------3");
		System.out.println(bo3);
	}
	
	public static void main(String[] args) {
		//method1();
		//method2();
		method3();
		
	}
	
}


class Student{
	
	String name;
	int age;
	int id;
	
	public Student() {
		
	}

	public Student(String name, int age, int id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", id=" + id + ", name=" + name + "]";
	}
	
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(this==obj){
			return true;
		}
		if(obj instanceof Student){
			Student stu=(Student) obj;
			return name.equals(stu.name)&&id==stu.id&&age==stu.age;
		}
		
		return false;
		
	}
	
	
}