package com.xms.javase.day02.p;
/**
 * 3.将字符串"test"变成"tset"输出在控制台
 * @author Administrator
 *
 */
public class TestString3 {

	public static void main(String[] args) {
		test();
	}
	public static void test(){
		String str="test";
		String s="";
		for(int i=str.length()-1;i>=0;i--){
			s+=str.charAt(i);
			System.out.println(s);
		}
	}
}
