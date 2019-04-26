package com.xms.javase.day03.p2;

public class Test {
	public static void main(String[] args) {
		String str="qwe32rr45trq345r";
		String regex="\\d";
		String str1=str.replaceAll(regex, "*");
		System.out.println(str1);
	}
}
