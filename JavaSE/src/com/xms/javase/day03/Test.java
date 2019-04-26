package com.xms.javase.day03;

public class Test {
	public static void method1(){
		long a=845734563945L;
		String str=String.valueOf(a);
		System.out.println(str);
		
		String a1="234251416544";
		long num1=Long.parseLong(a1);
		System.out.println(num1);
	}
	
	public static void method2(){
		StringBuffer sbr=new StringBuffer();// 这是创建一个空的字符序列
		System.out.println(sbr.append("qwerzxcdf"));//加入字符串
		System.out.println(sbr.delete(2, 4));//参数的范围是左包括右不包括
		System.out.println(sbr.replace(0, 4, "love"));// 在一定范围内替换
		System.out.println(sbr.insert(4, "shiqi"));// 某个下标值的后面添加指定类型的字符串
		System.out.println(sbr.reverse());//反向生成字符序列
	}
	public static void main(String[] args) {
		//method1()
		method2();
		
		
	}
	
}
