package com.xms.javase.day09;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用RandomAccessFile进行文件复制
 * 1.一个一个字节复制
 * 2.使用字节数组(缓冲区字节数组，)
 * @author Administrator
 *
 */
public class Demo02RandomAccessFile {
	
	public static void method1() throws Throwable{
		/*
		 * 一个字节一个字节的复制
		 * 
		 * 3.循环读取，循环写入
		 * 源文件中读数据，写入目标文件中
		 * 4.关闭两个
		 */
		
		RandomAccessFile src=new RandomAccessFile("E:/1.txt","r");
		RandomAccessFile dest=new RandomAccessFile("E:/2.txt","rw");
		byte[] byt=new byte[10*10];
		long start=System.currentTimeMillis();
	    int len=src.read(byt);
	   // int index=-1;
	    while(len!=-1){
	    	dest.write(byt);
	    	len=src.read();
	    }
	    
//		int index=-1;
//		while((index=src.read())!=-1){
//			dest.write(index);
//		}
		dest.close();
		src.close();
	    long ends=System.currentTimeMillis();
	    
	    System.out.println("读取时间："+(ends-start));
	}
	
	/*
	 * 使用缓冲字节数组复制文件，是降低读写次数为了提高读写效率
	 * 
	 * 先创建一个字节数组，作为缓冲区
	 * byte[] b=new byte[10];
	 * 
	 * 缓冲字节数组的实质：将硬盘中的文件读取到字节数组中
	 * 
	 * 不是字节数组长度定义多少就一次性读取多少在计算机
	 */
	
	public static void method2() throws Throwable{
		RandomAccessFile src=new RandomAccessFile("E:/1.txt", "r");
		RandomAccessFile dest=new RandomAccessFile("E:/3.txt","rw");
		
		byte[] byt=new byte[10];
		
		int len=-1;
		long start=System.currentTimeMillis();
		while((len=src.read(byt))!=-1){
//			dest.write(byt);
			//write(b, off, len)
			/*
			 * b:表示要写入的字节数组
			 * off:从字节数组的哪一个位置开始
			 * len:写入字节的数组的长度
			 */
			dest.write(byt, 0, len);
		}
		dest.close();
		src.close();
		long ends=System.currentTimeMillis();
	    
	    System.out.println("读取时间："+(ends-start));
	}
	 
	
	public static void method3(){
		
	}
	
	public static void main(String[] args) throws Throwable  {
	
//			method2();
			method1();
			
		
		
	}
}
