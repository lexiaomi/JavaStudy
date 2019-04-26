package com.xms.javase.day02;

/**
 * String类型：
 * @author Administrator
 *
 */
public class Demo01String {
	
	public static void main(String[] args) {
		method1();
		method2();
		System.out.println(4&7);
		method3();
		System.out.println("----------------------------");
		method4();
	}
	
	public static void method1(){
		//创建字符串对象----字面量的创建方式
		/*
		 * 字符串的是忌讳频繁修改(因为修改一次就会在内存中创建对象)，但是字符串的对象，又要频繁修改----可变字符序列(修改字符串)
		 */
		String str1="adc";
		System.out.println(str1);
		str1=str1+"!";
		System.out.println(str1);
		
	}
	
	public static void method2(){
		/*
		 * ==和equals的区别
		 * ==：
		 * 		基本类型的比较：直接比较值
		 * 		引用类型：比较地址值
		 * equals():
		 * 		一般用于引用类型的比较 ：
		 * 			1.如果这个类没有重写equals(),比较的是地址值
		 * 			2.如果这个类重写了equals(),这时在重写该方法时需要根据实际业务，考虑比较条件
		 * 		String类型已经重写了equals():只要两个对象的内容是相同，则返回值为true否则为false（区分大小写）
		 */
		
		/*
		 * 
		 * 字符串在使用字面量创建对象时，会在堆内存中有一个常量池，来存储字符串，在使用字面量创建对象时，首先会在常量池中寻找是否有与该对象"一样"的字符串对象，如果有则会
		 * 	将常量池中的字符串对象的地址值直接赋值给需要创建该对象的引用变量，如果没有则会在常量池中重新创建对象，把地址值赋值给引用变量
		 */
		
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");
		
		System.out.println("-------==--------------");
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s3==s4);
		System.out.println("---------------equals-------");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s3.equals(s4));
	
	}
	/*
	 * new关键字和字面量的创建对象：
	 * 	使用new关键字创建对象，属于强制性操作
	 * 	会在内存中开辟空间存储数据
	 * 		new关键字创建对象分如下：
	 * 			1.常量池中没有”相同“内容的对象，会在常量池和常量池外堆中创建对象
	 * 			2.常量池中”相同内容“的对象，则该数据不会在常量池中重新创建新的数据，
	 * 				而会在除常量池外的堆内存中开辟空间，存储数据
	 * 
	 * 
	 */
	public static void method3(){
		// new关键字创建对象
		String s= new String("abc");//一次创建两个对象，一个在堆中，一个常量池中
		String s1="1234";//字面量的方式创建对象
		
		/*
		 * 编辑器的特性：当一个表达式运算两边都是字面量时，那么编辑器会先计算，将结构生成表达式的位置，减少运算开销
		 * 		
		 */
		String s2="123"+"4";// 创建一个对象
		String s3="123"; //一个对象
		String s4=s3+"4";  // 两个对象
		/*
		 * 字符串拼接： 底层是使用可变字符序列，可变字符序列和字符串是不同一个类型，而且经过可变字符序列处理的数据和字面量创建的数据是在同一个内存区域
		 * 
		 * 
		 */
		System.out.println(s1==s2);
		System.out.println(s1==s4);
	}
	
	public static void method4(){
		String s1=""; //一个对象，空的，没有内容
		String s2=" "; // 一个对象 有空格，有内容
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2); // f
		System.out.println(s1.equals(s2));//f
		String s3=null; // 没有创建对象，也就没有地址值，在堆中没有数据，指向的是堆中空的
		System.out.println(s1.equals(s3));// f
	//	System.out.println(s3.equals(s2)); // 空指针异常，s3中没有对象，无法调用数据
		/*
		 *  java.lang.NullPointerException
		 *  空指针异常： 在使用对象调用数据时发生异常
		 *  原因： 对象没有数据(没有对象存在)
		 */
		// null 也是数据
		String s4 = "null";
		System.out.println(s4.equals(s3));
	} 
}
