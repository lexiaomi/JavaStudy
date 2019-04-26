package com.xms.javase.day05.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * 定义一个方法listTest(ArrayList<Integer> al, Integer s)，要求返回s在al里面第一次出现的索引，如果s没出现过返回-1。
 * @author Administrator
 *
 */
public class TestCollection2 {
	
	public static int method1(ArrayList<Integer> al,Integer s){
		//Iterator<Integer> it=al.iterator();
		if(al.contains(s)){
			return al.indexOf(s);
		}
		return -1;
		
//		for(int i=0;i<al.size();i++){
//			if(al.contains(s)){
//				System.out.println(al.indexOf(s));
//				break;
//			}else{
//				System.out.println("-1");
//				break;
//			}
//		}
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(3);
		al.add(5);
		al.add(3);
		al.add(4);
		al.add(8);
		
		System.out.println(method1(al,2));
		//System.out.println(al.indexOf(2));
	}
		
}
