package com.xms.javase.day06.p;

public class Student {
	
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
	
	
	
	
	
}
