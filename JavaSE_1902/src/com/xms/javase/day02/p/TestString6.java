package com.xms.javase.day02.p;

import java.util.Random;

public class TestString6 {
	public static void main(String[] args) {
		test();
	}
	public static void test(){
		
		String str="";
		Random rd= new Random();
		for(int i=0;i<4;i++){
			int key=rd.nextInt(3);
			switch (key) {
			case 0:
				 str+=rd.nextInt(10);
				break;
			case 1:
				str+=(char)(rd.nextInt(26)+'a');
				break;
			case 2:
				str+=(char)(rd.nextInt(26)+'A');
				break;
			}
		}
		System.out.println(str);
	}
}
