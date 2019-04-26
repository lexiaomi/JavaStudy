package com.xms.javase.day05.p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class TestCollection {
	
	public static void main(String[] args) {
		
		List<String> li=new ArrayList<String>();
		for(int i=0;i<5;i++){
			li.add("java");
		}
		System.out.println(li);
		li.remove("java");
		System.out.println(li);
		int a=li.size();
		System.out.println(a);
		
		li.add("mysql");
		li.add("jsp");
		li.add("C++");
		System.out.println(li);
		
		Iterator<String> it=li.iterator();
		while(it.hasNext()){
//			if(it.equals("c++")){
//				it.remove();
//				//System.out.println(it.next());
//			} 
			String str=it.next();//指针是在next方法上
			if(str.equals("java")){
				it.remove();
			}
			
			System.out.println(li);
		}
	}
	
	
}
