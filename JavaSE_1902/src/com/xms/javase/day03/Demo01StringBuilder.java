package com.xms.javase.day03;
/**
 * 
 * 引入一个可变字符序列：可以动态的对字符串进行修改
 * StringBuilder:线程不安全，并发处理，效率高
 * StringBuffer:线程安全，同步处理，效率低
 * 
 * 用法和方法一致
 * 区别就是在处理多线程时的安全与否
 * 	----追加，删除，替换，插入，翻转
 * 对应的方法返回值都是String
 * @author Administrator
 *
 */
public class Demo01StringBuilder {
	
	
	public static void method1(){
		//创建一个可以动态扩展字符的可变字符序列
		StringBuilder sb=new StringBuilder();
		/*
		 * append(String str)
		 * 追加指定的字符串---返回值为该引用类型的对象
		 * 
		 */
		sb.append("Hello");
		char c=sb.charAt(2);
		System.out.println(c);
		sb.append("World");
		System.out.println(sb);
		/*
		 * 
		 * 删除：delete(int start,int end):
		 * 	删除指定区域的字符串[start,end)
		 * 返回值为该引用类型的类型对象
		 * 
		 */
		// helloworld --->删除ld
		StringBuilder sb2=sb.delete(8,10);
		System.out.println(sb2);
		
		/*
		 * 
		 * 替换  replace(int start,int end,String str):
		 * 将指定区域的字符串替换成预定的字符串
		 * 返回值为该引用类型的类型对象
		 */
		
		StringBuilder sb3=sb2.replace(0, 5, "java");
		System.out.println(sb3);
	
		/*
		 * 
		 * 插入：insert(int index,String str)
		 * 在指定位置插入预定的字符串
		 * 返回值为该引用类型的类型对象
		 * 
		 */
		// javaWor--->#--->java#Wor
		/*
		 * 在指定位置插入预定字符串时，对应的指定位置上的原有的字符及其之后的字符全部后移一位
		 */
		StringBuilder sb4=	sb3.insert(4,"#&%" );
		System.out.println(sb4);
		
		/*
		 * 翻转：reverse()
		 * 将字符串翻转
		 */		
		StringBuilder sb5=sb4.reverse();
		System.out.println(sb5);
		
		//等量代换
		
		/*
		 * 这些方法封装时返回值为该引用类型对象的好处：
		 * 因为字符串需要频繁的修改，使用创建多个变量的方式来接受
		 * 处理后的字符串比较繁琐，不利于操作，所以修改的是字符串的返回该类型对象，这样便于在原有
		 * 的可变字符序列的对象上多次修改
		 */
	}
	
	public static void method2(){
		String str="tesk";
		StringBuffer sbf=new StringBuffer("tesk");
		sbf.reverse();
		System.out.println(sbf);
	}
	public static void test(){
		
	}
	
	public static void main(String[] args) {
		method1();
		method2();
	}
	
}
