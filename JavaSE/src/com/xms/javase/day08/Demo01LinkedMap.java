package com.xms.javase.day08;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Demo01LinkedMap {
	
	public static void method1(){
		/*
		 * 遍历所有的key
		 * Set<K> keySet():
		 * 该方法可以获取Map集合中所有的Key,并将它们存入一个Set集合中
		 */
		
		
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("语文", 100);
		map.put("数学", 90);
		map.put("英语", 80);
		map.put("物理", 70);
		map.put("化学", 60);
		
		Set<String> set=map.keySet();
		Iterator<String> it = set.iterator();
		for (String str : set) {
			System.out.println(str+":"+map.get(str));
		}
		
	}
	public static void method2(){
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("语文", 100);
		map.put("数学", 90);
		map.put("英语", 80);
		map.put("物理", 70);
		map.put("化学", 60);
		
//		Collection<Integer> value=map.values();
		/*
		 * 
		 * 遍历所有的K-v
		 * entrySet()
		 * 该方法会将每一组K-V存入一个Entry(K-V)实例中
		 * 并将这些实例存入到Set集合中
		 */
		Set<Entry<String,Integer>> value=map.entrySet();
		for (Entry<String ,Integer> va : value) {
			//System.out.println(va);
			/*
			 * getKey():获取Entry实例中K值
			 * getValue():获取Entry实例中V的值
			 */
			String key=va.getKey();
			Integer in=va.getValue();
			System.out.println(key+":"+in);
			
		}
	}
	
	public static void method3(){
		/*
		 * 遍历所有的Value
		 * values()
		 * 该方法返回的是value所对应泛型的Collection集合
		 * 单纯的遍历Value意义不大
		 * 
		 */
		
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("语文", 100);
		map.put("数学", 90);
		map.put("英语", 80);
		map.put("物理", 70);
		map.put("化学", 60);
		
		Collection<Integer> value = map.values();
		for (Integer va : value) {
			System.out.println(va);
		}
	}
	
	public static void main(String[] args) {
//		method1();
//		method2();
		method3();
	}
	
	
	
	
}
