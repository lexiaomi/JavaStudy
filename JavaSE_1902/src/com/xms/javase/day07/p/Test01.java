package com.xms.javase.day07.p;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;



/**
 * 
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		String str="good good study ,day day up";
		
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<str.length();i++){
			char in=str.charAt(i);
			if(!map.containsKey(in)){
				System.out.println(map.put(in, 1));
			}else{
				Integer value = map.get(in)+1;
				System.out.println(value);
				map.put(in, value);
			}
//	
		}
		
		System.out.println(map.size());
		System.out.println(map);
		
		
		
		
		
	}
}
