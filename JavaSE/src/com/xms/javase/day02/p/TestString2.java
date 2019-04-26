package com.xms.javase.day02.p;
/**
 * 2.计算字符串"adsadaFASFAASDADAASSDDAS15465"中有几个
	大写字母，几个小写字母，几个数字？
 * 
 */
public class TestString2 {
	public static void main(String[] args) {
		test();
	}
	public static void test(){
		String str="adsadaFASFAASDADAASSDDAS15465";
		int sumUp=0;
		int sumLow=0;
		int sumNum=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>='a'&&str.charAt(i)<'z'){
				sumLow++;
			}else if(str.charAt(i)>='A'&&str.charAt(i)<'Z'){
				sumUp++;
			}else{
				sumNum++;
			}
		}
		System.out.println("小写字母个数："+sumLow);
		System.out.println("大写字母个数："+sumUp);
		System.out.println("数字个数："+sumNum);
		
	}
}
