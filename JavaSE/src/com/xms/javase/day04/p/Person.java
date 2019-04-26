package com.xms.javase.day04.p;

public class Person {

	String name;
	int age;
	char sex;
	
	public Person(){
		
	}
	public Person(String name, int age, char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}
	
	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass() !=obj.getClass())
			return false;
		if(obj instanceof Person){
			Person other =(Person) obj;
			if(age !=other.age){
				return  false;
			}
			if(name==null){
				if(other.name !=null){
					return false;
				}
			}else if(!name.equals(other.name)){
				return false;
			}
			if(name!=other.name){
				return false;
			}
		}
		return true;
	}


	
	
}
