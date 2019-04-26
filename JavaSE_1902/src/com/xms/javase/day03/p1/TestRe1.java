package com.xms.javase.day03.p1;
/**
 * 2.将下列字符串
 *		"eb ot ton ro eb oT"
 *		变成
 *		"To be or not to be."
 * @author Administrator
 *
 */
public class TestRe1 {
	
	public static void main(String[] args) {
		method1();
	}
	
	public static void method1(){
		String str="eb ot ton ro eb oT";
//		String str1="";
//		for(int i=str.length()-1;i>=0;i--){
//			str1+=str.charAt(i);
//		}
//		System.out.println(str1);
		
		StringBuilder sb=new StringBuilder(str);
		sb.reverse().append(".");
		
		System.out.println(sb);
	}
	
}
