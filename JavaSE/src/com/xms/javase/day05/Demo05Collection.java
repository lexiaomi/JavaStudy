package com.xms.javase.day05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * 泛型：jdk1.5之后出现的
 * 作用：限制集合中所存放的元素类型
 * 		方便后期对集合中数据的操作
 * 		所有集合都支持泛型
 * 		迭代器也支持泛型
 * 		
 * 
 * @author Administrator
 *
 */
public class Demo05Collection {
	@Test
	public  void method1(){
		//加入泛型
		//泛型前后要一致
		List<String> li=new ArrayList<String>();
		li.add("java");
		li.add("jsp");
		li.add("servlet");
		li.add("mysql");
		Iterator<String> it=li.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
			//String str=it.next();
			
		}
	}
//	public static void main(String[] args) {
//		method1();	
//	}
}
