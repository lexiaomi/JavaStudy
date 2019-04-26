package com.xms.javase.day03.p1;

import java.util.Arrays;

/**
 * 
 * 3.将下列字符串拆分：
 *	"name=zs age=18 classId=110"
 *如下：
 * 	zs
 *	18
 *	110
 * @author Administrator
 *
 */
public class TestRe2 {
	
	
	public static void main(String[] args) {
		method1();
	}
	
	public static void method1(){
		String str="name=zs age=18 classId=110";
		String regex="name=|age=|classId=";
		String[] str1=str.split(regex);
		//System.out.println(Arrays.toString(str1));
		String[] str2=str.split("\\s");
		for(int i=0;i<str2.length;i++){
			//System.out.println(str1[i]);
			String ss=str2[i].substring(str2[i].indexOf("=")+1);
			System.out.println(ss);
		}
	}
}
