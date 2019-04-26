package com.xms.javase.day02;

import java.util.Scanner;

/**
 * String类 常用的方法
 * 		字符串的特性：
 * 			1.length() ---获取字符串对象的长度，有多少个字符长度为多少
 * 				语法： 字符串对象.length()
 * 				返回值为整数类型的字符串长度
 * 			2.字符串的下标从0开始，到-1结束
 * 
 * java中设置参数：一般前包括，后不包括[2,6);
 * @author Administrator
 *
 */
public class Demo02String {
	
	public static void main(String[] args) {
		//method1();
		System.out.println("*************************");
		method2();
		method3();
		method4();
		System.out.println("*************************");
		String str="上海自来水来自海上";
		method5(str);
		//method6();
		method7();
		
		
	}
	
	public static void method1(){
		String str="good good study,day day up";
		System.out.println(str.length());
		/*
		 * indexOf(String str);
		 * 检索指定字符串所在的位置(下标)
		 * 返回值为 int类型
		 * 
		 * 1.整体匹配，返回值从左到又最先匹配到的字符串所对应的下标
		 * 2.如果没有匹配到指定字符串，则返回值为-1
		 */
		System.out.println("---------------------");
		int num=str.indexOf("s");
		System.out.println(num);
		int num1=str.indexOf("study");
		System.out.println(num1);
	
		
		/*
		 * indexOf(String str,int index);
		 * 从下标为index的位置开始检索字符串
		 */
		int num4=str.indexOf("good");
		System.out.println(num4);
		//检索该字符串中第二个good所在的下标
		
		System.out.println(str.indexOf("good",2 ));
		// 字符串的方法可以嵌套使用
		int num5=str.indexOf("good",str.indexOf("good")+1);
		System.out.println(num5);
		
		
		/*
		 * LastIndexOf(String str):
		 * 检索指定字符串最后一次出现的位置
		 */
		System.out.println("-------------------------");
		int num6=str.lastIndexOf("p");
		System.out.println(num6);
	}
	
	public static void method2(){
		/*
		 * subString(int start,int end):
		 * 1.截取指定区域的字符串[satrt,end)
		 * 2.返回截取的字符串
		 *	用于截取域名
		 * www.baidu.com--->baidu 
		 */
		String str="0123456789";
		System.out.println(str.substring(3,7));
		
		String str1="www.baidu.com";
		String str2=str1.substring(str1.indexOf(".")+1,str1.lastIndexOf("."));
		System.out.println(str2);
		/*
		 * subString(int index);
		 * 
		 * 截取index之后字符串(包括index)
		 * 返回值为截取到的字符串类型的数据
		 * 
		 */
		String str3=str.substring(6);
		System.out.println(str3);
	}

	public static void method3(){
		/*
		 * trim：
		 * 	1.去除字符串两端的空白
		 * 	2.不能去除字符串中间的空白
		 * 	3.返回值为去除两端空白后的字符串
		 * 
		 */
		
		String str1=" 斗破  苍穹    ";
		
		System.out.println(str1.trim());
	}
	
	public static void method4(){
		/*
		 * charAt(int index)
		 * 查看指定位置上的字符
		 * 2.返回值为指定位置的字符
		 */
		
		String str="hello";
		System.out.println(str.charAt(1));
		char c1=str.charAt(str.indexOf("e"));
		System.out.println(c1);
		
		//判断一个字符串是否是回文
		
	}
	public static void method5(String str){
		//判断一个字符串是否是回文
		//String str="上海自来水来自海上";
		//int index=0;
		
//		for(int i=0;i<str.length()/2;i++){
//			if(str.charAt(i)!=str.charAt(str.length()-1-i)){
//				//continue;
//				System.out.println("不是回文");
//				break;
//			}else{
//				index++;
//			}
//			
//			if(index==str.length()/2){
//				System.out.println("是回文");
//			}
//		}
		System.out.println("----------------------");
		int len=str.length();
		
		for(int i=0;i<len/2;i++){
			if(str.charAt(i)!=str.charAt(len-1-i)){
				System.out.println("不是回文");
				return;
			}
		}
		System.out.println("是回文");
		
		System.out.println("------------3-----------");
//		boolean flag=true;
//		for(int i=0;i<len/2;i++){
//			if(str.charAt(i)!=str.charAt(len-1-i)){
//				flag=false;
//				break;
//			}
//		}
//		if(flag){
//			System.out.println("是回文");
//		}else{
//			System.out.println("不是回文");
//		}
		
	}
	public static void method6(){
		/*
		 * startsWith(String str):
		 * ensWidth(String str):
		 * 1.判断某字符串是否指定字符串开头或者结尾
		 * 2.返回值为boolean
		 * 	如果是以指定字符串开头、结尾、则返回值为true 否则返回值为false
		 * http:互联网传输协议
		 * ftp:文件传输协议
		 */
		
		// 上传以.txt结尾的文件
		
		Scanner sc =new Scanner(System.in);
		System.out.println("请上传一.txt文件结尾的文档");
		String str=sc.next();
		if(str.endsWith(".txt")){
			System.out.println("格式正确，上传成功");
		}else{
			System.out.println("上传失败，格式不正确");
		}
		
		
		
	}
	public static void method7(){
		/*
		 * toUpperCase：字母字符串转换成大写
		 * toLowerCase：字母字符串转换成小写
		 * 返回值为改变后的字符串
		 */
		
		String str1="abc";
		String str2="ABC";
		
		String str3=str1.toUpperCase();
		String str4=str2.toLowerCase();
		System.out.println(str3+str4);
		
		/*
		 * equalsIgnoreCase(String anotherString):
		 * 不区分大小写比较字符串
		 * 返回值为boolean类型
		 * 	对应的两个字母不区分大小写相同，则返回为true否则为false
		 * 
		 */
		if(str1.equalsIgnoreCase(str2)){
			System.out.println("相等");
		}
	}
	
	
	
	
}
