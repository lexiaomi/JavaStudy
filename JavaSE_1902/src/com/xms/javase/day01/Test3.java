package com.xms.javase.day01;

public class Test3 {
	public static void main(String[] args) {
		
		
		String s1="abc";
		String s2="a"+"b"+"c";
		String s3="abc"+"";
		String s4=s1+"";
		String s5=new String("abc");// 堆中new出来的和常量池中的有何关系
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1==s4);//说明内存中地址值不一样
		System.out.println(s1==s5);
		// 常量池(constant pool)指的是在编译期被确定
		
	}
}
