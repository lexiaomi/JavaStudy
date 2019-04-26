package com.xms.javase.day06.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Test01 {
	
	public static void method1(){
		List<String> li=new LinkedList<String>();
		li.add("mysql");
		li.add("css");
		li.add("html");
		li.add("jsp");
		li.add("java");
		//下标获取元素
		
		String a=li.get(2);
		System.out.println(a);
		
		//for循环遍历
		for(int i=0;i<li.size();i++){
			System.out.println(li.get(i));
		}
		
		//set(int index,<T> t)
		
		String a1=li.set(2, "oracle");
		System.out.println(a1);
		System.out.println(li);
		
		//add(int index,<T> t)
		li.add(1,"struts2");//在指定位置插入元素
		System.out.println(li);
		
		
		//移除:remove(int index);//返回值被移除的元素
		
		String a2=li.remove(2);
		System.out.println(a2);
		System.out.println(li);
	}
	
	
	
	public static void method2(){
		//去除重复的元素  for循环去重一般是从后往前遍历
		List<String> li=new LinkedList<String>();
		li.add("mysql");
		li.add("css");
		li.add("html");
		li.add("jsp");
		li.add("java");
		li.add("java");
		li.add("jsp");
		for(int i=li.size()-1;i>=0;i--){
			if(li.get(i).equals("java")){//||li.get(i).equals("jsp")
				li.remove(i);
			}
		}
		System.out.println(li);
	}
	
	
	public static void method3(){
		//List迭代器：ListIterator
		List<String> li=new LinkedList<String>();
		li.add("mysql");
		li.add("css");
		li.add("html");
		li.add("jsp");
		li.add("java");
		li.add("java");
		li.add("jsp");
		ListIterator<String> lisit=li.listIterator();
		while(lisit.hasNext()){
			if(lisit.next().equals("java")){
				//lisit.set("php");
				lisit.remove();
				lisit.add("C++");
			}
		}
		System.out.println(li);
	}
	
	
	public static void method4(){
		//subList
		List<Integer> li=new LinkedList<Integer>();
		for(int i=0;i<=20;i++){
			li.add(i);
		}
		
		List<Integer> li1=li.subList(0, 11);
		System.out.println(li1);
		//将子集元素*10；
		for(int i=0;i<li1.size();i++){
			int a1=li1.get(i)*10;
			li1.set(i, a1);
		}
		System.out.println(li1);
		System.out.println(li);
		//[0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
		//[0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
		//上面输出的结果中为什么被截取的集合里元素也*10了，因为截取的子集实际上是截取的地址值，所以当子集中元素改变，对应的被截取的集合中的元素也被修改
	}
	
	
	public static void method5(){
		//集合与数组之间的转换
		
		List<String> li=new LinkedList<String>();
		li.add("mysql");
		li.add("css");
		li.add("html");
		li.add("jsp");
		li.add("java");
		
		//toArray(T[] t)
		
		String[] str1=li.toArray(new String[li.size()]);
		System.out.println(Arrays.toString(str1));
		
		//数组--》集合
		
		String[] str2=new String[]{"li","sd","kk","dd"};
		List<String> lli=Arrays.asList(str2);
		System.out.println(lli);
		//lli.add("ll");//转换后的集合不能直接操作
		//间接操作
		//addAll()
		List<String> li2=new ArrayList<String>();
		li2.addAll(lli);
		li2.add("woc");
		System.out.println(li2);
		
		//有参的集合构造方法
		List<String> li3=new ArrayList<String>(lli);
		li3.add("sb sb");
		System.out.println(li3);
	}
	public static void main(String[] args) {
//		method1();
//		method2();
//		method3();
//		method4();
		method5();
		
		
	}
}
