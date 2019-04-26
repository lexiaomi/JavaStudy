package com.xms.javase.day05.p;

import java.util.LinkedList;

public class TestCollection4 {
	public static void main(String[] args) {
		
		method1();
		
	}
	
	public static void method1(){
		
		String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"};
		LinkedList<String> ll=new LinkedList<String>();
		
		for(int i=0;i<strs.length;i++){
			ll.add(strs[i]);
		}
		System.out.println(ll);
		LinkedList<String> ll1=new LinkedList<String>();
		for(int i=0;i<ll.size(); i++){
			if(!ll1.contains(ll.get(i))){
				ll1.add(ll.get(i));
			}
		}
		System.out.println(ll1);
		
		
	}
}
