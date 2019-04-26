package com.xms.javase.day05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) throws ParseException {
		/*
		 * 
		 */
		test1();
		
	}
	
	public static void test1() throws ParseException{
		System.out.println("请输入一个商品生产日期，yyyy-MM-dd:");
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		System.out.println("请输入一个商品保质日期天数：");
		int day=sc.nextInt();
		
		System.out.println("保质期前多少天促销：");
		int day1=sc.nextInt();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date scDay=sdf.parse(str);
		
		Calendar cal=Calendar.getInstance();
		// 获取输入的生产日期
		cal.setTime(scDay);
		cal.add(Calendar.DATE, day-day1);
		Date d=cal.getTime();
		String sd=sdf.format(d);
		System.out.println("保质期"+day1+"天促销："+sd);
		
		
	}
	
	public static void test2(){
		System.out.println("请输入一个 ");
	}
}
