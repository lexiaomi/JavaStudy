package com.xms.javase.day11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 缓冲字符流
 * 	PrintWriter:缓冲字符输出流
 * 		new PrintWriter(File file):直接向文件中写入数据---默认字符集编码
 * 		new PrintWriter(String path):直接指定路径写入---默认字符编码集(不能指定字符集)
 * 		new PrintWriter(OutputStream file): 
 * 		new PrintWriter(OutputStreamWriter file):能指定字符集，能自动属性
 * 		new PrintWriter(OutputStreamWriter file,boolean out)::能指定字符集，能自动行刷新
 * 			---print:该方法可以写出任何类型的数据(在一行)
 * 			---println:该方法可以写出任何类型的数据(会自动换行)
 * 	BufferedReader:缓冲字符输入流
 * @author Administrator
 *
 */
public class Demo03WR {
	public static void method1() throws Throwable{
		
		FileOutputStream fos=new FileOutputStream("pw.txt",true);
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		//缓冲字符输出流
		PrintWriter pw = new PrintWriter(fos,true);
		/*
		 * println()---换行符(两个字节)
		 * 搭配自动行刷新，会换行，将未满的缓冲区写出
		 * 数据写出
		 * --会降低读写效率，
		 * 
		 * print():不会进行行刷新，依然会将数据写入到缓冲区中等待缓冲区存满，然后一次写出
		 * 
		 */
		pw.println("你们好啊1");
		pw.println("你们好啊2");
		pw.println("你们好啊3");
		pw.println("你们好啊4");
		pw.print("你们好啊1");
		pw.print("你们好啊2");
		pw.print("你们好啊3");
		pw.print("你们好啊4");
		
		
		pw.close();
	}
	
	public static void method2() throws Throwable{
		/*
		 * 缓冲字符输入流
		 * 
		 */
		FileInputStream fis=new FileInputStream("pw.txt");
		InputStreamReader isr=new InputStreamReader(fis,"gbk");
		BufferedReader br=new BufferedReader(isr);
		String rl = br.readLine();
		while(rl!=null){
			System.out.println(rl);
			rl = br.readLine();
		}
		br.close();
	}
	public static void main(String[] args) throws Throwable {
//		method1();
		method2();
	}
}
