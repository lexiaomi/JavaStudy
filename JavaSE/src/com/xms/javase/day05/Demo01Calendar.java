package com.xms.javase.day05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Calendar:日历类
 *  	因为Date对时间分量的操作不方便，所以引入Calendar
 *  
 *  该类是一个抽象类，该类封装对时间分量逐一操作的方法
 *  月份：0-11
 *  周：日---六 1 2 3 4 5 6 7
 * 
 * @author Administrator
 *
 */
public class Demo01Calendar {
	
	public static void method1(){
		//创建日历类对象
		Calendar cal=Calendar.getInstance();
		/*
		 * get(int fied):
		 * 	获取日历类对应时间分量的值
		 * 返回值为对应的指定的时间分量(int)
		 */
		int year=cal.get(Calendar.DAY_OF_MONTH);
		int day=cal.get(Calendar.DATE);//少用
		int day2=cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year);
	}	
	
	public static void method2(){
		/*
		 * set(int field,int value)
		 * field:指定的时间分量
		 * value：要设置的值
		 * 给指定的时间分量设置指定的值
		 * --void
		 */
		
		//创建日历类对象
		Calendar cal=Calendar.getInstance();
		
		//修改年
		cal.set(Calendar.YEAR, 2020);
		System.out.println(cal.get(Calendar.YEAR));
		//修改月--使用英文
		cal.set(Calendar.MONTH, Calendar.OCTOBER);
		System.out.println(cal.get(Calendar.MONTH));
		
	}
	
	public static void method3(){
		/*
		 * 让在控制台输出十天后的今天是几号
		 */
		
		
		Calendar cal=Calendar.getInstance();
		//获取今天是这个月的第几天
		int day1=cal.get(Calendar.DATE);
		int day2=day1+10;
		cal.set(Calendar.DATE, day2);
		int day3=cal.get(Calendar.DATE);
		System.out.println(day3);
		
		/*add()
		 * 直接在对应的时间分量上进行数值改变(+或-)
		 * 正是加
		 * 负数是减
		 * 使用该方法不用考虑月份的天数
		 * 会根据日历自动计算
		 */
		cal.add(Calendar.DATE, -10);
		System.out.println(cal.get(Calendar.DATE));
		
	}
	
	public static void method4(){
		/*
		 * setTime(Date date)
		 * 	---将指定的日期类对象设置成日历类对象
		 * 	---void
		 * getTime()
		 * 	---使Calendar时间设置成Date时间
		 * 
		 */
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.MONTH, 3);
		cal.add(Calendar.DATE, 10);
		cal.set(Calendar.DAY_OF_WEEK, 4);
		Date date=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd E");
		String str=sdf.format(date);
		System.out.println(str);
		
		
		
	}
	
	public static void method5() throws ParseException{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入日期：");
		String s1=sc.nextLine();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d1=sdf.parse(s1);	
		Calendar cal=Calendar.getInstance();
		//修改当前时间为输入的时间
		cal.setTime(d1);
		cal.add(Calendar.MONTH,2);
		cal.add(Calendar.DATE, 5);
		cal.set(Calendar.DAY_OF_WEEK, 4);
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd E");
		Date date=cal.getTime();
		String str=sdf1.format(date);
		System.out.println(str);
	}
	public static void main(String[] args) throws ParseException {
		//method2();
		//method3();
		//method4();
		//WEDNESDAY
		method5();
	}
}
