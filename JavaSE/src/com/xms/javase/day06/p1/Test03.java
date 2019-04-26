package com.xms.javase.day06.p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test03 {
	
	
	public static void main(String[] args) {
		List<Student> li=new ArrayList<Student>();
		li.add(new Student("lisi",18,20154055));
		li.add(new Student("zhaowu",19,20154255));
		li.add(new Student("lisi",18,20154013));
		li.add(new Student("lizzub",19,20155055));
		li.add(new Student("xms",19,20155055));
		li.add(new Student("pdd",12,20154055));
		
		
		Collections.sort(li);
		System.out.println("---------默认年龄排序方式---------------");
		for (Student stu: li) {
			System.out.println(stu);
		}
//		System.out.println("---------2---------------");
//		MyComparator myco= new MyComparator();
//		Collections.sort(li,myco);
//		for (Student stu: li) {
//			System.out.println(stu);
//		}

	}
}
