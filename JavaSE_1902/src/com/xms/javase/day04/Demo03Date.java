package com.xms.javase.day04;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Date类：用距离一个固定时间点的毫秒数来表示一个特定的时间点
 * Date关于大多的时间分量的设置被Calendar替代
 * @author Administrator
 *
 */
public class Demo03Date {
	public static void method1(){
		// 表示系统的当前时间
		Date d=new Date();
		/*
		 * getTime():
		 *  返回自 1970 年 1 月 1 日 00:00:00以来此 Date 对象表示的毫秒数。
		 *  返回值为long整型
		 */
		long ti=d.getTime();
		//System.out.println();
		
		/*
		 * simpleDateFormat类，将时间进行格式化，以进行更好的展示
		 * java.text.SimpleDateFormat：
		 * 		这个类是与语言环境有关的方法来格式化和解析的具体的类
		 * 		
		 * 	格式化：(日期--->文本)
		 * 	解析：(文本--->日期)
		 * 构造方法：
		 * SimpleDateFormat()
		 * SimpleDateFormat(String mode)
		 * final String format(Date date)
		 */
		DateFormat df=new SimpleDateFormat("yyyy/MM/dd/hh/mm/ss");
		/*Date--->String
		 * 将时间类型的数据，转换成对应的字符串 
		 */
		
		System.out.println(df.format(d));
		
		// String --->Date
		
		String str="2019/3/7/01/12/30";
		Date d1;
		try {
			d1 = df.parse(str);
			System.out.println(d1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		long ti1=System.currentTimeMillis();
		System.out.println(ti1-ti);
	}
	public static void method2(){
		//Date--->String
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
		String str=sdf.format(d);
		System.out.println(str);
		
		
		// String--->Date
		/*
		 * 字符串的格式要与mode定义的格式相同
		 * 否则会出现异常
		 */
		String time="2019/03/04  15:12:25";
		Date d1;
		try {
			d1 = sdf.parse(time);
			System.out.println(d1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void date() throws ParseException{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入你的生日：");
		String birth=sc.next();//输入的字符串不能包含空格  nextLine()： 能包含空格
		//String birth="1996-09-12";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dateBirth=sdf.parse(birth);//转成Date类
		// 生日到1970的毫秒数
		long time = dateBirth.getTime();
		//获取系统的时间到1970
		Date d=new Date();
		long time2=d.getTime();
		
		//活了的毫秒数
		double time3=time2-time;
		
		int day=(int)(time3/1000/60/60/24);
		
		System.out.println("你已经活了："+day/365+"年");
		//System.out.println(day2);
		
	}
	
	/*
	 * 输入你想活到的日期，计算还有几天可活
	 */
	
	public static void date1() throws Throwable{
		Scanner sc=new Scanner(System.in);
		System.out.println("输入你想活到的日期：");
		String str=sc.next();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//活到的日期
		Date time=sdf.parse(str);
		//活到的日期到1970的毫秒数
		long t1=time.getTime();
		
		//获取现在的日期
		Date time1=new Date();
		//现在的日期到1970的毫秒数
		long t2=time1.getTime();
		long t3=t1-t2;
		if(t3>=0){
			System.out.println("还有："+t3/1000/60/60/24+"天数");
		}
		
		//System.out.println(((t1-t2)/1000/60/60/24)+"天数");
		
		
		
	}
	public static void main(String[] args) throws Throwable {
		//method1();
		//method2();
		date1();

	}
}
