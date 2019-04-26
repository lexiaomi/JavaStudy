package com.xms.javase.day07;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * Collection的子接口：
 * 		set接口： 无序（部分有序），不可重复（添加重复元素会失败）
 * 		语法：set<T> set=new HashSet<T>();
 * 
 * @author Administrator
 *
 */
public class Demo01Set {

	public static void method1(){
		Set<Integer> set= new HashSet<Integer>();
		Set<Integer> set1= new TreeSet<Integer>();
		
		boolean bo1=set.add(1);
		
		set.add(2);
		set.add(4);
		set.add(3);
		set.add(9);
		set.add(8);

		boolean bo2=set.add(1);
		System.out.println(bo1);
		System.out.println(bo2);
		System.out.println(set);
		
		//移除元素，因为set集合无序，我们取元素，通过元素值来获取元素
		
		set.remove(3);
		System.out.println(set);
		
		//set集合的遍历
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			Integer next = it.next();
			System.out.println(next);
		}
		System.out.println("------------------");
		for (Integer i : set) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		method1();
	}
}
