package com.xms.javase.day11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * 字节流写入字符串
 * @author Administrator
 *
 */
public class Demo01RandomAccesssFile {
	public static void method1(){
		RandomAccessFile raf=null;
		try {
			raf=new RandomAccessFile(new File("String.txt"),"rw");
			/*
			 * 乱码：文件的编码格式和解码格式(字符集编码)不同，造成乱码
			 * （中国）中文存在乱码
			 * 
			 * 将字符串转成数组
			 * 写入字符串
			 * String的getBytes()方法：
			 * 将当前字符串对象按照系统默认的字符集编码，转成对应的字节数组
			 * 返回值为字节数组
			 * 
			 * Unicode: 一个字符一个字节---只服务于英文
			 * GBK:中文两个字节表示一个字符(中文汉字)
			 * 		英文一个字节一个字符
			 * UTF-8:万国码
			 * 	英文一个字节一个字符
			 * 	中文三个字节表示一个字符(汉字)
			 * 	(两个字节表示一个汉字，四个字节表示汉字)
			 * 
			 */
			//按照系统默认的字符集编码----GBK
			byte[] bytes = "中国人".getBytes();
			//raf.write(bytes);
			
			/*
			 * 
			 * String类中可以将字符窜按照指定的字符集编码格式，写入文件
			 * getBytes(String charset)
			 */
			
			//按照utf-8编码，将字符串写入文件中
			byte[] bytes2 = "中国人".getBytes("utf-8");
			raf.write(bytes2);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				raf.close();
				System.out.println("写入成功");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void method2(){
		//输入流
		//字节流
		InputStreamReader isr=null;
		try {
			FileInputStream fis=new FileInputStream("55.txt");
			//字符转换流
			//输入输出的编码格式要 一致，否则会乱码
			isr=new InputStreamReader(fis,"utf-8");
			/*
			 * read():
			 * 一次读取一个字符
			 * 返回值为对应字符的数字
			 * 
			 */
			int index=-1;
			while((index=isr.read())!=-1){
				System.out.println((char)index);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void method3() throws Throwable{
		//先输入，再输出
		
		FileInputStream fis=new FileInputStream("test.txt");
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");
		FileOutputStream fos=new FileOutputStream("isr.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");

		char[] ch=new char[10];
		int read = isr.read(ch);
		while(read!=-1){
			osw.write(ch);
			read = isr.read(ch);
		}
		osw.close();
		isr.close();
		System.out.println("复制完毕");
	}
	
	public static void main(String[] args) throws Throwable {
//		method1();
//		method2();
		method3();
	}
}
