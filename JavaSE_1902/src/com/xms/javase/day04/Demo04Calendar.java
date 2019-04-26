package com.xms.javase.day04;
/**
 *  Calendar:日历类
 *  	因为Date对时间分量的操作不方便，所以引入Calendar
 *  
 *  该类是一个抽象类，该类封装对时间分量逐一操作的方法
 *  月份：0-11
 *  周：日---六 1 2 3 4 5 6 7
 *  
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Demo04Calendar {

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
		Scanner sc=new Scanner(System.in);
		//System.out.println("请输入日期：");
		//String str=sc.next();
		//Date date=new Date();
		//将字符串的时间转成Date
		//String str="1996-09-12";
		SimpleDateFormat sdf=new SimpleDateFormat();
		
			//Date valueof=sdf.parse(str);
			Calendar cal=Calendar.getInstance();
			//cal.setTime(valueof);
			
			System.out.println("天\t一\t二\t三\t四\t五\t六");
			//计数变量
			int count=0;
			//获取这个最大的天数
			int maxDay=cal.getActualMaximum(Calendar.DATE);
			//获取现在的天数
			int nowDay=cal.get(Calendar.DATE);
			
			for(int i=1;i<=maxDay;i++){
				System.out.print(i+"\t");
				count++;
				if(count%7==0){
					System.out.println();
				}
			}
		
		
		
		
		
	}
	
	
	public static void method3(){
	
		System.out.println("请输入日期：");
		Scanner sc=new Scanner(System.in);
		
		String str1=sc.next();
		Date valueOf=java.sql.Date.valueOf(str1);
		Calendar cal=Calendar.getInstance();
		cal.setTime(valueOf);
		//System.out.println(cal);
		System.out.println("天\t一\t二\t三\t四\t五\t六");
		//计数变量
		int count=0;
		//获取这个最大的天数
		int maxDay=cal.getActualMaximum(Calendar.DATE);
		//获取现在的天数
		int nowDay=cal.get(Calendar.DATE);
		
		//将当前日期变成第一天
		cal.set(Calendar.DATE,1);
		//获取第一天是一周中的第几天
		int num=cal.get(Calendar.DAY_OF_WEEK);
		//\t个数
		for(int i=1;i<=num-1;i++){
			System.out.print("\t");
		}
		count+=(num-1);
		for(int i=1;i<=maxDay;i++){
			if(i!=nowDay){
				System.out.print(i+"\t");
			}else{
				System.out.print(i+"*\t");
			}
			count++;
			if(count%7==0){
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		//method1();
		//method2();
		method3();
		
	}
}
