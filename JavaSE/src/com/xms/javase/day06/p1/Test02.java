package com.xms.javase.day06.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test02 {

	public static void method1(){
		String[] arr=new String[]{"aaaa","bbbb","dddd","bbbb","dddd","eeee"};
		
		List<String> ll=Arrays.asList(arr);		
		List<String> ll1=new ArrayList<String>();
		for(int i=0;i<ll.size();i++){
			String s=ll.get(i);
			if(!ll1.contains(s)){
				ll1.add(ll.get(i));
			}
		}
		System.out.println(ll1);
		
	}
	public static void main(String[] args) {
		method1();
		
	}
}
