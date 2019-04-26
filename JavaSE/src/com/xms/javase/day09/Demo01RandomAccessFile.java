package com.xms.javase.day09;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile:随机操作文件内容的类
 * File不能操作文件的内容，如果想操作文件内容
 * 需要引入一个新的类 RandonAcsessFile
 * ---这个类的对象支持随机访问文件，对文件进行读写操作
 * ---该类的方法是基于指针的操作，总是在当前指针指向的位置发生读写操作
 * ---"rw":可读，可写
 * ---"r":只读
 * 
 * @author lll
 * 
 * 
 * 
 */
public class Demo01RandomAccessFile {
	
	
	public static void method1() throws Throwable{
		//创建随机访问文件的实例---(对象)
		/*
		 * 
		 * RandomAccessFile(file, mode)
		 * 		file: File对象
		 * 		mode: 读写模式
		 * 这种模式RandomAccesssFile创建对象需要先创建File对象
		 * 
		 * 
		 * RandomAccessFile(name, mode)
		 * 	name:对应的文件路径
		 * mode:读写模式
		 * 这种之间创建对象，直接写文件
		 * 
		 * 这两种创建RandomAccessFile实例的构造方法
		 * 		文件的操作模式： rw, r
		 * 
		 * 读取和写入是相对于虚拟内存来讨论的：
		 * 		程序(虚拟内存)--------->文件(物理内存):写入
		 * 		程序(虚拟内存)<----------文件(物理内存):读取
		 * 
		 * 方法：
		 * 	write(int i):写入，写的是一个int类型的低八位数据，指针自动后移
		 * 	read():读取，一次读取一个字节，然后存入到int类型的低八位上
		 * 		返回值为读取的字节数，返回值为-1表示数据读取完毕
		 *  	一次读取一个字节读取完后指针后移一位
		 * 
		 * 
		 * RandomAccessFile类：
		 * 	底层封装了两个流，输入输出；
		 * 	1.如果写入的字节数大于源文件的字节数，则全部进行覆盖
		 *  2.如果写入的字节数小于源文件的字节数，则进行是写入的的字节将源文件中的字节数从头开始进行等量覆盖
		 */
		RandomAccessFile raf=new RandomAccessFile("22.txt", "rw");
		
		raf.write(3);
		raf.write(6);
		raf.write(0);
		raf.write(255);
		raf.write(-1);
//		raf.write(4);
//		raf.write(255);
		raf.close();
	}
	public static void method2() throws Throwable{
		RandomAccessFile raf=new RandomAccessFile("22.txt", "r");
		int a=raf.read();
		int b=raf.read();
		int  c=raf.read();
		int  d=raf.read();
		raf.close();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);//返回-1，表示没有数据可读
		System.out.println(d);//返回-1，表示没有数据可读
		System.out.println("读取完毕");
	}
	
	public static void main(String[] args) throws Throwable {
//		method1();
		method2();
	}
}
