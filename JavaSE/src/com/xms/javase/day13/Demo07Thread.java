package com.xms.javase.day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 集合非线程安全：
 * 	将集合转成线程安全的
 * 
 * @author Administrator
 *
 */
public class Demo07Thread {
	public static void main(String[] args) {
		//非线程安全的集合
		List<String> list=new ArrayList<String>();
		Set<String> set=new HashSet<String>();
		Map<String,Integer> map=new HashMap<String, Integer>();
		/*
		 * 变成线程安全的集合
		 */
		Collections.synchronizedList(list);
		Collections.synchronizedSet(set);
		Collections.synchronizedMap(map);
		
	}
}
