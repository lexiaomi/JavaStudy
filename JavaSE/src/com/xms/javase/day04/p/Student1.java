package com.xms.javase.day04.p;

public class Student1 {
	String name;
	int age;
	int id;
	public Student1(){
		
	}
	public Student1(String name,int age,int id){
		this.name=name;
		this.age=age;
		this.id=id;
	}
	
	public String toString(){
		
		return "Ãû×Ö£º"+name+"ÄêÁä:"+age;
		
	}
	public boolean equals(Object obj){
		if(obj==null)
			return false;
		if(this==obj)
			return true;
		
		if(obj instanceof Student1){
			Student1 s=(Student1) obj;
			return name.equals(s.name)&&age==s.age&&id==s.id;
		}
		return false;
		
		
		
	}
	
}
