package com.xms.javase.day02.p;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 4.随机产生一个长度为4字符串验证码，其中包含大写字母，小写字母，数字
 * 1.在控制台输入对应的验证码，将生成的验证码和输入的验证码转成
 *  大写比较
 * 2.在控制台输入对应的验证码，将生成的验证码和输入的验证码转成
 *		小写比较
 * 3.在控制台输入对应的验证码，不区分大小写比较
 * 
 * @author Administrator
 *
 */
public class TestString4 {
	
	public static void main(String[] args) {
//		while(true){
			test();
//		}
		

	}
	public static void test(){
		String str1="abcdefghijklmnopqrstuvwxyz";
		String str2=str1.toUpperCase();
		String str3="0123456789";
		
		String str4=str1+str2+str3;
		Random rd=new Random();
		int n1=rd.nextInt(str1.length());
		int n2=rd.nextInt(str2.length());
		int n3=rd.nextInt(str3.length());
		int n4=rd.nextInt(str4.length());
		
		char[] arr1=new char[]{str1.charAt(n1),str2.charAt(n2),str3.charAt(n3),str4.charAt(n4)};
		
		//int j=0;
		for(int i=0;i<arr1.length;i++){
			int n5=rd.nextInt(arr1.length-i)+i;
			System.out.print(arr1[n5]); 
			char temp=arr1[n5];
			     arr1[n5]=arr1[i];
			     arr1[i]=temp;
		}
		System.out.println();      
		
	
		System.out.println(Arrays.toString(arr1));
		//String a="fdSh";
		
		//boolean a1=a.equals(arr1);
		//System.out.println(a1);
//		for(int j=0;j<arr1.length;j++){
//			char ch=arr1[j];
//			System.out.println(ch);
//		}
		

		// System.out.println(s1);
		// System.out.println(s1.toUpperCase());
		String s1=new String(arr1);// 直接char数组生成的 字符串
		Scanner sc =new Scanner(System.in);
		System.out.println("请输入验证码:");
		String s3=sc.next();// 输入的
		
		
		System.out.println("进行大写比较按1  进行小写比较 按2 不区分比较按3");
		int num=sc.nextInt();
		if(num==1){
			
			String s2=s1.toUpperCase(); //转换成大写的字母字符串
			String s4=s3.toUpperCase();// 输入的字符串大写了
			System.out.println(s4);
			if(s2.equals(s4)){
				System.out.println("大写比较输入正确");
			}else{
				System.out.println("大写比较不正确");
			}
			
		}else if(num==2){
			//转小写
			String s5=s1.toLowerCase();
			String s7=s3.toLowerCase();
			if(s5.equals(s7)){
				System.out.println("小写比较正确");
			}else{
				System.out.println("小写比较不正确");
			}
		}else{
			if(s1.equalsIgnoreCase(s3)){
				System.out.println("比较正确");
			}else{
				System.out.println("比" +
						"较错误");
			}
		}
		
		
		
		
	}
}
