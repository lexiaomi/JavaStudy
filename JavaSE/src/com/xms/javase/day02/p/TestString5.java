package com.xms.javase.day02.p;
/**
 * 5.统计字符串"woainiwoainiwoainiwoainiwoainiwoainiwoainiwoainiwoaini"
	中，出现"ai"的次数？
 * @author Administrator
 *
 */
public class TestString5 {
	
	public static void main(String[] args) {
		test();
	}
	public static void test(){
		String str = "woainiwoainiwoainiwoainiwoainiwoainiwoainiwoainiwoaini";
		int sum=0;
//		for(int i=0;i<str.length();i++){
//			if(str.charAt(i)=='a'&&str.charAt(i+1)=='i'){
//				sum++;
//			}
//		}
		
		String s="ai";
		while(str.indexOf(s)!=-1){
			str=str.substring(str.indexOf(s)+s.length());
			sum++;
		}
		System.out.println("ai出现的次数："+sum);
	}
}
