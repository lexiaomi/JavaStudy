package com.xms.javase.day04.p;


public class Test {
	
	
	public static void main(String[] args) {
		Person p=new Person("ll", 12,'ÄÐ');
		Person p1=new Person("ll",12,'ÄÐ');
		System.out.println(p.equals(p1));
	}
}
