package com.xms.javase.day09;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile:基于指针的操作
 * 介绍关于指针操作的方法
 * @author Administrator
 *
 */
public class Demo03RandomAccessFile {
	public static void main(String[] args) throws Throwable {
		RandomAccessFile raf=new RandomAccessFile("demo.txt", "rw");
		/*
		 * getFilePionter()
		 * 获取指针指向的当前位置
		 * 返回值为整数类型
		 * 
		 */
		
		raf.write(20);
		raf.write(2);
		raf.write(10);
		raf.write(6);
		raf.write(3);
		raf.write(4);
		raf.writeInt(20);
		long numb1=raf.getFilePointer();
		System.out.println("指针当前位置："+numb1);
		System.out.println("-----------------------------------------------------");
		/*
		 * 
		 * seek(long a):
		 * 调整指针的当前位置：
		 * 	设置到此文件开头到测量位置的偏移量
		 * 在该位置发生下一次读取或者写入操作
		 * --void
		 * 任意调整
		 * 
		 */
		raf.seek(1);
		int i1=raf.read();
		System.out.println(i1);
		System.out.println("-----------------------------------------------------");
		/*
		 * skipByte(int i)
		 * 
		 */
		
		
		raf.skipBytes(3);
		int ii1=raf.read();
		System.out.println(ii1);
		
		raf.close();
		System.out.println("结束");
	}
}
