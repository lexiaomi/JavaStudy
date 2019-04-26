package com.xms.javase.day07.p1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Test {
	public static void method1(){
		Map<String,Integer> map=new HashMap<String, Integer>();
		//Ìí¼ÓÊý¾Ý
		map.put("java", 1);
		map.put("mysql", 3);
		map.put("css", 5);
		map.put("html", 6);
		map.put("jsp", 8);
		
		Integer in = map.get("sp");
		System.out.println(in);
		
		Integer re = map.remove("css");
		Integer re1 = map.remove("ss");
		System.out.println(re1);
		System.out.println(re);
		System.out.println(map.size());
		
		boolean ck = map.containsKey("jsp");
		System.out.println(ck);
		Map<Student, Integer> map1=new HashMap<Student,Integer>();
		map1.put(new Student("zs", 18, 'ÄÐ'),112);
		map1.put(new Student("ls", 19, 'ÄÐ'),113);
		map1.put(new Student("ww", 22, 'ÄÐ'),110);
		map1.put(new Student("zl", 21, 'ÄÐ'),114);
		map1.put(new Student("cq", 22, 'Å®'),115);
		map1.put(new Student("zb", 16, 'ÄÐ'),111);
		System.out.println(map1);
		
		boolean bo1=map1.containsKey(new Student("ls", 19, 'ÄÐ'));
		System.out.println(bo1);
	}
	
	public static void main(String[] args) {
		method1();
	}
}

class Student {
	String name;
	int age;
	char sex;
	
	public Student(){
		
	}
	public Student(String name,int age,char sex){
		this.name=name;
		this.age=age;
		this.sex=sex;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sex;
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
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}
	
	
	
}
