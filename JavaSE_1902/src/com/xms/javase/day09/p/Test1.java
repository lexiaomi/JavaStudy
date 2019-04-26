package com.xms.javase.day09.p;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 1.计算test.txt中各个字符出现的次数，并输出
	在控制台上，输出效果如下：
	a:123
	b:2131
	c...
	....
 * @author Administrator
 *
 */
public class Test1 {
	
	public static void main(String[] args) throws Throwable {
		RandomAccessFile src=new RandomAccessFile("test.txt", "r");
		Map<Character ,Integer> map=new HashMap<Character,Integer>();
		int index=-1;
		while((index=src.read())!=-1){
			char c=(char)index;
			if(!map.containsKey(c)){
				map.put(c, 1);
			}else{
				Integer value = map.get(c)+1;
				//System.out.println(value);
				map.put(c, value);
			}
			//System.out.println(index+"\t"+c);
			//des.write(index);
		}
		src.close();
		
//		System.out.println(map);
		Set<Entry<Character, Integer>> enty = map.entrySet();
		for (Entry<Character, Integer> entry : enty) {
			System.out.println(entry);
		}
	}

}
