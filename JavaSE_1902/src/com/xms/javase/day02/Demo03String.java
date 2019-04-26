package com.xms.javase.day02;

public class Demo03String {
	public static void method1(){
		/*
		 * 1.基本类型转成字符串类型
		 * 		1.String.valueOf(基本类型):
		 * 		方法返回值为String类型
		 * 2.数字字符串转成基本类型的数值
		 * 	语法：基本类型的包装类.parse基本类型(String str)
		 *  返回值为对应的基本类型数值
		 * 
		 */
		
		int i=23;
		String str=String.valueOf(i);
		System.out.println(str);
		// 数字字符串转基本类型
		String str1="12345";
		int num=Integer.parseInt(str1);
		System.out.println(num+1);
		
		
	}
	
	
	
	public static void main(String[] args) {
		method1();
	}
}
