package com.xms.javase.day03.p1;

import java.util.Arrays;

/**
 * 1.将字符串"113@ ere ccc com",分割出如下效果
 *	1.[113@, ere, ccc, com]
 *	2.[113, ere, ccc, com]
 * @author Administrator
 *
 */
public class TestRe {
	
	public static void method1(){
		//1
		String str="113@ ere ccc com";
		String regex="\\s";
		String[] s=str.split(regex);
		System.out.println(Arrays.toString(s));
		//2
		
		String regex1="@\\s|\\s";
		String[] s1=str.split(regex1);
		System.out.println(Arrays.toString(s1));
	}
	
	public static void main(String[] args) {
		method1();
	}
	
}
