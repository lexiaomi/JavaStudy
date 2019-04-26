package com.xms.javase.day10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * IO流：输入输出流(相对于虚拟内存)
 * 	程序(虚拟)----->物理  输入
 * 	程序<-----(文件)物理  输出
 * 	InputStream: 抽象类，所有字节输入流的父类
 * 		--	read()
 * 	OutputStream: 抽象类，所有字节输出流的父类
 * 		-- write()
 * 
 * 
 * 节点流：(低级流) 可以从、向一个特定的地方读取/写出数据
 * 处理流：(高级流) 对一个已经存在的低级流进行封装，是建立在低级流的基础之上，不会单独存在，可以嵌套使用
 * 
 * 
 * 实现流：
 * 	---文件输入输出流
 * 	---低级流
 * 		FileInputStream
 * 			--read()  read(byte[], buf);
 * 		FileOutputStream
 * 			-write(int i) write(buf[],0,len)
 * @author Administrator
 *
 */
public class Demo01IO {
	public static void method1() throws Throwable{
		//输出流
		/*
		 * new FileOutputStream("22.txt")
		 * name:文件夹的路径名
		 * 在向一个指定文件中输入数据，在写入数据会将源文件中的所有数据清除，然后再写入
		 * 这一点和RandomAccessFile不同
		 * 
		 * 
		 * FileOutputStream(file, append)
		 * 
		 * name:路径名
		 * append: 是否追加数据
		 * 	true:表示在原有数据后面添加数据，
		 *  false:表示清除数据继续重新添加
		 */
		
		FileOutputStream fos=new FileOutputStream("22.txt");
		//new FileOutputStream(file, append)
		String str="lsdasaj";
		fos.write(str.getBytes());
		fos.write("中国人".getBytes());
		
		fos.close();
		System.out.println("输出完成");
		
		//输入流
		InputStream is=new FileInputStream("22.txt");
		byte[] by=new byte[13];
		int i=is.read(by);
		String s=new String(by,0,by.length);
		System.out.println(s);
		
	}
	
	public static void method2() throws Throwable{
		InputStream is=new FileInputStream("22.txt");
		
		OutputStream os=new FileOutputStream("33.txt");
		BufferedInputStream bis= new BufferedInputStream(is);
		BufferedOutputStream bos=new BufferedOutputStream(os);
		
		byte[] bytes=new byte[10];
		
		int len = bis.read(bytes);
		while(len!=-1){
			bos.write(bytes,0,len);
			len=bis.read(bytes);
		}
		bos.close();
		bis.close();
		os.close();
		is.close();

		System.out.println("完毕");
		
		
		
		 
		
	}
	public static void main(String[] args) throws Throwable {
//		method1();
		method2();
	}
}
