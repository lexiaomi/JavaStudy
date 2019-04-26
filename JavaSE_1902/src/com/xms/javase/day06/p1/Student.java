package com.xms.javase.day06.p1;

import java.util.Comparator;

public class  Student implements Comparable<Student>{
	
	String name;
	int age;
	int id;
	public Student() {
		
	}
	public Student(String name, int age, int id) {
		this.name = name;
		this.age = age;
		this.id = id;
		
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", id=" + id + "]";
		
	}
	@Override
	public int compareTo(Student o) {
		
		if(age-o.age!=0){
			return age-o.age;
		}else if(id-o.id==0){
			return name.length()-o.name.length();
		}else
			return id-o.id;
	}
	
}


class MyComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
		if(o1.age-o2.age!=0){
			return o1.name.length()-o2.name.length();
			
		}else if(o1.name.length()-o2.name.length()==0){
			return o1.age-o2.age;
			
		}else {
			return o1.id-o2.id;
		}
		
	}
	
}