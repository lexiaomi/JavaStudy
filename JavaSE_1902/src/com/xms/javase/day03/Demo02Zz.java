package com.xms.javase.day03;
import java.util.Arrays;
import java.util.regex.Matcher;;;
/**
 * 正则表达式：本身不属于Java，借鉴而来
 * 理解为规则，
 * 一般用于字符串的格式验证
 * 	---matches(String regex): (全部匹配)
 * 		将字符串与正则表达式(regex)进行比较
 * 		如果格式满足regex，则返回值为true，否则为返回值为false
 * 
 * 	
 * @author Administrator
 *
 */

public class Demo02Zz {
	
	
	
	public static void method1(){
		//String regex="[^abc]";// abc当中任意一个字符
		String regex1="[a-z&&[^a-f]]";
		String regex2="\\d";
		String str="10";
		System.out.println(str.matches(regex2));
		
	}
	
	public static void method2(){
		//1开头的手机号码
		String regex="[1]\\d{10}";
		String num="18812345178";
		boolean bo=num.matches(regex);
		System.out.println(bo);
		//身份证号码
		
		String regex1="^[1-9]\\d{5}[1-9]\\d{3}((0[1-9])|(1[0-2]))(([0][1-9]|[1-2]\\d)|3[0-1])\\d{4}$";
		String num1="340827199901015421";
		System.out.println(num1.matches(regex1));
		
		//邮箱
		String regex2="\\w+@\\w{2,5}(\\.com|\\.cn)+";
		String num3="1877368192@163.com";
		System.out.println(num3.matches(regex2));
	}		
	public static void method3(){
		/*
		 * 
		 * split(String regex):
		 * 1.按照指定的正则表达式分割字符串
		 * 2.返回值为分割后的字符串数组
		 * 
		 */
		
		String str="java#php#python#vb#c++#.net";
		String regex="#";
		String[] arr=str.split(regex);
		System.out.println(Arrays.toString(arr));
		
		String str1="java234php23python78vb56c++03.net";
		String regex1="\\d+"; //\\d{1,5}
		String[] arr1=str1.split(regex1);
		System.out.println(Arrays.toString(arr1));
	}
	
	
	public static void method4(){
		/*
		 * replaceAll(String regex,String str)
		 * 以正则表达式regex,将字符串中以regex格式表示的字符串替换成str
		 * 
		 */
		
		String str="sasdfsdf534fgwe564564er";
		//将该字符串里的数字替换成#
		String regex="[a-z]+";
		String s=str.replaceAll(regex,"");
		System.out.println(s);
		
	}
	
	
	public static void method5(){
		
		String regex="\\w{8,10}";
		String str="abcd1234_a";
		System.out.println(str.matches(regex));
	}
	public static void main(String[] args) {
		
//		method1();
//		method3();
		method4();
		method5();
		//method2();
	}
}
