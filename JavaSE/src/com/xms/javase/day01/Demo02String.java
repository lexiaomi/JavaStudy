package com.xms.javase.day01;

import java.util.Iterator;

/**
 * String :字符串类型(引用数据类型)
 * 	1.字符串字面量"abc",可以看做成一个字符串对象
 * 	2.字符串是常量，一旦定义不可更改，
 * 		字符串的本质就是：字符数组；
 * 	引用数据类型，在创建对象的时候一般使用new关键字创建对象
 * 	但是字符串的使用频率较高，Java对字符串的创建做了一定的妥协，
 * 	既可以使用new关键字创建对象，也可以使用字面量的方式创建对象
 * 
 * 字符串常用的构造方法：
 * 	1.public String():无参构造方法 
 * 		String str=new String()等价于String str="";
 *  2. public String(byte[] byte):
 * 		将字节数组转换为字符串
 *  3.public String(byte[] bytes, int index ,int length):
 *   	index:数字下标
 *   	length:长度
 *   	
 *   	将指定的字节数组的一部分转成字符串
 *   
 *   4.public String(char[] c) :将char数组装换成字符串
 *   5.public String(char[] c, int index, int length) 
 *   	index:数组下标
 *   	length:长度
 *   
 *   	将指定的字符数组的一部分转换成字符串	
 *   
 *   6.public String(String str):
 *   	将字符串常量转换成字符串
 *   	
 *   
 * @author Administrator
 *
 */
public class Demo02String {
	
	public static void method1(){
		//创建对象---字面量
		String str1=new String("abc");
		//创建对象--- 字面量(常用)
		String str2="abc";
		System.out.println(str1);
		System.out.println(str2);
		
	
	}
	
	
	public void method2(){
		//调用无参构造方法，创建字符串对象---new
		String str = new String();
		//使用字面量
		String str1="";
	}
	
	public static void method3(){
		byte[] arr1 = new byte[]{97,98,99,100,101};
		String str1 = new String(arr1);
		System.out.println(str1);
		System.out.println("-----------1------------------------------------");
		String str2 = new String(arr1,1,4);
		System.out.println(str2);
		
		System.out.println("----------------2---------------------------");
		char[] arr2 = new char[]{'a','b','c','d','e'};
		String str3 = new String(arr2);
		System.out.println(str3);
		System.out.println("---------------------------3-----------------");
		String str4=new String(arr2,0,3);
		System.out.println(str4);
		
		System.out.println("----------------------------4-------------------");
		String strr="123456";//常量字符串
		String str5=new String(strr); // 字符串
		System.out.println(str5);
	}
	
	
	
	public static void main(String[] args) {
		String str = "abcdef";
		for(int i=0;i<str.length();i++){
			System.out.println(str.charAt(i));
		}
		
		//method1();
		method3();
		
	}
}
