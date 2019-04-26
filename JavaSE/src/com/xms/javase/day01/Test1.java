package com.xms.javase.day01;

public class Test1 {
	
	
	public static void menthod1(){
		//将字节数组转换成字符串
		byte[] arr1=new byte[]{97,98,99,100};
		String str=new String(arr1);
		System.out.println(str);
		System.out.println("-------------------");
		//将指定的字节数组一部分转成字符串
		String str1=new String(arr1,1,3);
		System.out.println(str1);
		System.out.println("---------------------");
		//将字符数组，转换成字符串
		char[] arr2=new char[]{'1','2','3','4'};
		String str2=new String(arr2);
		System.out.println(str2);
		System.out.println("-----------------------");
		//将指定字符数组的一部分，转换成字符串
		String str3=new String(arr2,1,3);
		System.out.println(str3);
		System.out.println("---------------------");
		//将字面量转换成字符串
		String str4="123456";
		String str5=new String(str4);
		System.out.println(str5);
	}
	
	public static void main(String[] args) {
		menthod1();
	}
}
