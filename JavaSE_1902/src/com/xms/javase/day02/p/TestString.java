package com.xms.javase.day02.p;
/**
 * 1.将字符串"jdk"变成"DK"输出在控制台
 * @author Administrator
 *
 */
public class TestString {
	
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		String str = "jdk";
		String str1 = str.toUpperCase().substring(1);
		System.out.println(str1);
	}
}
