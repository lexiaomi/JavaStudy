package com.xms.javase.day06.p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Student> li=new ArrayList<Student>();
		li.add(new Student("ai",14,20154658));
		li.add(new Student("lzz",18,20151658));
		li.add(new Student("filq",20,20150658));
		li.add(new Student("lzz",18,20150658));
		li.add(new Student("v",20,20150608));
		
//		Student [name=l, age=12, id=20150608]
//		         Student [name=li, age=14, id=20154658]
//		         Student [name=lilq, age=16, id=20150658]
//		         Student [name=lzz, age=18, id=20150658]
//		         Student [name=lzz, age=18, id=20151658]
		
//		MyComparator myc=new MyComparator();
//		Collections.sort(li,myc);
//		
//		for (Student stu : li) {
//			System.out.println(stu);
//		}
//		
		Comparator<Student> com=new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				/*
				 * 先按照姓名默认的方式 ，如果名字相同按照年龄排序，如果
				 *  年龄相同按照学号排序
				 */
				if(o1.age!=o2.age||o1.name!=o2.name){
					return o1.name.compareTo(o2.name);
				}else if(o1.name.equals(o2.name)){
					return o1.age-o2.age;
				}
				return o1.id-o2.id;
				
			}
			
		};
		
		Collections.sort(li,com);
		for (Student stu: li) {
			System.out.println(stu);
		}
		
	}

}


class MyComparator implements Comparator<Student>{
	/*
	 * 先按照年龄排序，如果年龄相同按照学号排序，如果学号相同
	 * 		按照名字排
	 */
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.age==o2.age&&o1.id==o2.id){
			return o1.name.compareTo(o2.name);
		}else if(o1.age!=o2.age){
			return o1.age-o2.age;
		}
		return o1.id-o2.id;
		
		
	}
	
}