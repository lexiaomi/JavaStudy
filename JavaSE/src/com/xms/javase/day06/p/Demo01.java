package com.xms.javase.day06.p;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * li用list集合中remove(int index) 移除集合中元素值为a的元素
 * @author Administrator
 *
 */
public class Demo01 {
	
	
	public static void method1(){
		List<String> li=new ArrayList<String>();
		//li.add("a");
		li.add("b");
		li.add("c");
		li.add("a");
		li.add("a");
		li.add("d");
		li.add("e");
		li.add("f");
		System.out.println(li.indexOf("a"));
		for(int i=li.size()-1;i>=0;i--){
			if(li.get(i).equals("a")){
				li.remove(i);
			}
		}
		System.out.println(li);
	}
	
	
	public static void method2(){
		List<String> li=new ArrayList<String>();
		li.add("a");
		li.add("b");
		li.add("c");
		li.add("a");
		li.add("a");
		li.add("d");
		li.add("e");
		li.add("f");
		
		/**
		 * 迭代器专门为List集合做了特殊的实现方法
		 * 
		 */
		ListIterator<String> lit=li.listIterator();
		while(lit.hasNext()){
			//System.out.println(lit.next());
			
			if(lit.next().equals("a")){
				lit.set("A");
				lit.remove();
				lit.add("F");
			}
		}
		System.out.println(li);
		
		//从后往前遍历
		
		while(lit.hasPrevious()){
			System.out.println(lit.previous());
			System.out.println(lit.previousIndex());
		}
	}
	
	
	public static void method3(){
		/*
		 * sublist(int from, int dext):截取集合中的子集
		 * 参数是对应集合截取段的下标
		 * --返回值为截取的对应泛型的集合
		 */
		
		
		List<Integer> li=new LinkedList<Integer>();
		for(int i=1;i<=20;i++){
			li.add(i);
		}
		System.out.println(li);
		System.out.println("SubList------------------------");
		List<Integer> li1=li.subList(0, 11);
		System.out.println(li1);
		
		System.out.println("SubList------------------------");
		for(int i=0;i<li1.size();i++){
			int a=li1.get(i)*10;
//			System.out.println(a*10);
			li1.set(i, a);
		}
		//截取的也是相同的地址值，改变子集中的元素，相当于改变对应地址中的元素，则指向该地址的原集合也会发生改变
		
		System.out.println(li1);
		System.out.println(li);
		
	}
	
	public static void method4(){
		/*
		 * 集合跟数组之间的转换
		 * 1.toArray()：自动转成Object类型的数组---比较麻烦。不常用
		 * 2.toArray(new 引用类型[数组长度])
		 * 	1.定义的数组的长度，大于原集合元素的个数，多余的部分补充null;
		 * 	2.如果定义的数组长度小于原集合的长度，
		 * 		系统默认会默认定义一个大小为集合元素的个数的数组长度，不再使用人为定义的数组的长度
		 * 	3.一般定义的数组长度都是为原集合的大小
		 * 
		 */
		
		List<Integer> li=new LinkedList<Integer>();
		for(int i=1;i<=20;i++){
			li.add(i);
		}
		Integer[] intarr=li.toArray(new Integer[li.size()]);
		System.out.println(Arrays.toString(intarr));
		
	
//		int[] arr=new int[li.size()];
//		for(int i=0;i<arr.length;i++){
//			arr[i]=li.get(i);
//		}
//		System.out.println(Arrays.toString(arr));
		
		
		/*
		 * 数组转集合：---一般转成list集合
		 * Arrays.asList();
		 * asList(类型[],arr):
		 * 将指定的数组转成List
		 * 返回值为对应泛型的集合
		 */
		
		String[] arr1=new String[]{"a","b","c","d","e"};
		/*
		 * 从数组转成的集合，不能直接修改集合中的元素
		 * 否则会报异常：非法操作java.lang.UnsupportedOperationException
		 * 
		 * 
		 * 间接修改集合中的元素：需要重新创建一个集合，将该集合添加到新集合中操作
		 * 
		 * 集合的复制
		 */
		
		
		List<String> li2=Arrays.asList(arr1);
		
		System.out.println(li2); 
	  	
		System.out.println("------------------------------");
		/*
		 * 集合的复制
		 * 1.使用addAll(集合)：
		 * 2.使用集合的有参数的构造方法
		 */
		List<String> li3=new ArrayList<String>();
		li3.addAll(li2);
		System.out.println(li3);
		System.out.println("------------------------------");
		//使用构造方法
		List<String> li4=new ArrayList<String>(li2);
		li4.add("g");
		System.out.println(li4);
		
		
	}
	
	public static void main(String[] args) {
	//	method1();
	//	method2();
	//	method3();
		method4();
		
	}
}
