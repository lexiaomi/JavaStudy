package com.xms.javase.day07;

import java.io.ObjectInputStream.GetField;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Map接口：
 * 		Map结合是无序的
 * 		该数据结构看起来像一个多行两列的表格
 * 		每条数据都包含两个信息：Key-Value
 * 		Key:唯一不重复的(equals()方法比较)
 * 		Value:可以重复的值
 * 		
 * 		Map接口和Collections接口是俩个独立的接口
 * 		Map<K,V>   K,V对应数据类型的泛型
 * 		实现类：HashMap
 * 		实现方式：
 * 			Map<k,v> map=new HashMap<k,V>();
 * 
 * 
 * @author Administrator
 *
 */
public class Demo03Map {
	
	public static void method(){
		Map<Integer,String> map=new HashMap<Integer, String>();
		map.put(1,"java");
		map.put(2, "jsp");
		map.put(3, "js");
		map.put(4, "jquery");
		map.put(2, "mysql");
		System.out.println(map);
		Set<Integer> keySet = map.keySet();
		for (Integer in : keySet) {
			System.out.println(in);
		}
		Collection<String> values = map.values();
		for (String str: values) {
			System.out.println(str);
		}
		
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			System.out.println(entry);
		}
	}
	
	
	public static void method1(){
		//创建Map集合，K:唯一的，V:可重复
		Map<String,Integer> map=new HashMap<String ,Integer>();
		/*
		 * 添加数据
		 * put(K,v):
		 * 返回值类型为Value值的类型
		 * 1.当添加的元素K-V在集合中不存在，为添加元素功能---返回值为null类型为V泛型
		 * 
		 * 2.当添加的元素K-V在集合中存在时，则会根据K值的equals方法比较是否为true，
		 * 		再替换比较为true的对应的value的值(等同于set方法----修改的功能)
		 * --返回值为被对应K替换掉的Value
		 */
		Integer put = map.put("语文", 120);
		map.put("数学", 90);
		map.put("英语", 80);
		map.put("物理", 70);
		map.put("生物", 60);
		Integer put2 = map.put("英语", 90);
		System.out.println(put);
		System.out.println(map);
		System.out.println("------------------------------------");
		System.out.println(put2);
		System.out.println(map);
		
		/*
		 * get(K):
		 * 	--equals() 比较为true则视为相同的K
		 * 该方法根据给定的key来获取对应的Value值
		 * 返回值为对应泛型的V值
		 * 
		 * 如果给定的K值在集合中不存在，则返回值为null
		 */
		Integer in= map.get("物理");
		System.out.println(in);
		Integer in1 = map.get("Java");
		System.out.println(in1);
		
		/*
		 * remove(K):	--equals() 比较为true则视为相同的K
		 * 该方法根据给定的K来删除K-V这个一行数据
		 * 返回值为被删除K所对应的V值，如果没有找到对应的K值，则返回值为null
		 * 
		 */
		System.out.println("----------------------------------");
		//删除集合中存在的K---英语
		Integer re1 = map.remove("英语");
		System.out.println(re1);
		System.out.println(map);
		//删除集合中不存在的
		Integer re2 = map.remove("体育");
		System.out.println(re2);
		System.out.println(map);
		
		//containsKey(k)
		/*
		 * 包含返回true
		 * 反之false
		 */
		
		boolean ck = map.containsKey("语文");
		System.out.println(ck);
		
		
	}
	/*
	 * 存一个学生的学号
	 * name,age,sex
	 * 
	 */
	
	public static void method2(){
		Map<Student,Integer> map=new HashMap<Student,Integer>();
		map.put(new Student("ls", 15, '男'), 108);
		map.put(new Student("zs", 20, '女'), 191);
		map.put(new Student("ww", 18, '男'), 101);
		map.put(new Student("qq", 19, '男'), 109);
		map.put(new Student("ww", 18, '男'), 101);
		map.put(new Student("zl", 11, '女'), 104);
		
		/*
		 * 重写equals()方法应当重写hashCode()方法
		 * 重写规则如下：
		 * 	1.若两个对象equals比较为true，那么hashCode()返回值必须相同
		 * 		即重写equals()方法也需要重写hashCode()
		 *  2.反之则不是必须，但是这种情况要避免，即两个对象如果是equals比较为false，但是hashCode()返回值
		 *  一样，这样会影响HashMap的性能损失
		 *  即重写equals方法，没有重写hashCode()
		 * 
		 */
		boolean ck = map.containsKey(new Student("ls", 15, '男'));
		System.out.println(ck);
		
		Set<Entry<Student, Integer>> set = map.entrySet();
		for (Entry<Student, Integer> en : set) {
			System.out.println(en);
		}
	}
	
	
	
	
	
	public static void method3(){
		Map<String,Student> map=new HashMap<String ,Student>();
		map.put("班长", new Student("mjl",28,001));
		map.put("文艺委员", new Student("sdf",22,005));
		map.put("学习委员", new Student("vfg",23,003));
		map.put("团支部书记", new Student("lll",20,006));
		Set<Entry<String, Student>> entrySet = map.entrySet();
		for (Entry<String, Student> entry : entrySet) {
			System.out.println(entry);
		}
	}
	
	
	
	public static void method4(){
		Map<Point, Integer> map=new HashMap<Point, Integer>();
		Point p1 = new Point(1,1);
		int point=p1.hashCode();///hashCode值
		System.out.println("修改前："+point);
		System.out.println("修改前："+point);
		map.put(p1, 1);
		System.out.println(map.get(p1));
		//修改Kde1属性
		
		/*
		 * 注意：
		 * 	hashCode():
		 * 	在当前对象内容没有发生改变的情况下，应当多次返回值是相同的，如果内容发生改变
		 * 	则应当返回为不同的值
		 */
		p1.x=2;
		int point1=p1.hashCode();
		System.out.println("修改后："+point1);
		System.out.println("修改后："+point1);
		
		
	}
	
	
	public static void method5(){
		//加载因子：0.75； 平衡存取效率和空间利用率(实验)
		/*
		 * 没有初始化散列组大小默认值：16
		 * 可以根据数据而发生改变，加载因子始终保持在0.75;
		 * 
		 * 
		 * 自定义散列组的大小
		 * 	数据量比较大，考虑性能
		 * 
		 */
		
	}
	public static void main(String[] args) {
//		method();
//		method1();
		//method2();
		//method3();
		method4();
		
		
		
	}
}
//Point
class Point{
	int x;
	int y;
	
	public Point(){
		
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
}
