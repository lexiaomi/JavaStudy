package com.xms.javase.day04;
/**
 * 	包装类：  针对基本数据类型
 * 		Java就是面向对象的编程语言，操作的数据层面都是对象
 * 		基本数据不是对象，不方便后期操作
 * 		保留基本数据类型的原因：因为具体的数据需要进行四则运算或者比较运算
 * 
 * 	基本类型----->引用类型(对象)---->装箱
 * 	引用类型----->基本类型 (数值)---->拆箱
 * 
 * 自动装箱：把基本数据类型自动装箱成引用数据类型
 * 自动拆箱：把引用数据类型自动拆箱成基本数据类型
 * @author Administrator
 *
 */
public class Demo01 {
	
	public static void main(String[] args) {
//		int i=1234234;
//		Integer it=i; //自动装箱
//		System.out.println(it);
//		System.out.println(i+it);
//		int i1=it; // 自动拆箱
//		System.out.println(i1);
		
		
		int a=23;
		int b=12;
		
		/*
		 * 装箱
		 */
		//引用类型---创建对象(构造方法)
		Integer it=new Integer(a);
		System.out.println(it);
		
		/*
		 * valueOf(基本类型变量):
		 * 将基本类型装箱成对应的引用数据类型
		 */
		
		Integer ii=Integer.valueOf(12);
		System.out.println(ii*2);
		
		/*
		 * 拆箱
		 * 基本类型Value():
		 * 将引用类型拆箱成基本数据类型
		 */
		
		int ii1=ii.intValue();
		System.out.println(ii1);
	}
}
