package com.xms.javase.day10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 字节流
 * 缓冲字节流
 * 对象流
 * 
 * 
 * 字符流(转换流  将字节--->字符)：高级流
 * 两个抽象类：
 * 		Reader:字符输入流(父类)
 * 		Writer:字符输出流(父类)
 * 
 * 实现类：
 * 		OutputStreamReader:字符输出流
 * 			OutputStreamReader(OutputStream os)
 * 			OutputStreamWriter(out,  String charsetName)
 * 		InputStreamReader:字符输入流
 * 		InputStreamReader((InputStream in)
 * 		InputStreamReader((InputStream in,  String charsetName)
 * 		
 * 区别字符，字节流
 * 	Reader和Writer都是字符流
 * 	字符输入输出流都是以字符为单位读写数据
 * 	字符流只能用于读取字符数据
 * 		---用于读写文本，不能读取图片，视频....
 * 		---字节流可以读取视频，图片，音频......
 * @author Administrator
 *
 */
public class Demo04Object  {
	public static void method1() throws Throwable{
		FileOutputStream fos=new FileOutputStream("55.txt");
		//高级流---字符流
		OutputStreamWriter osr=new OutputStreamWriter(fos,"utf-8");
		/*
		 * write(String str)
		 * write(char[] c)
		 * write(int i)
		 */
		FileReader fr=new FileReader("22.txt");
		osr.write("中国");
		osr.write(20);
		System.out.println("输入完毕");
		osr.close();
		
	}
	public static void main(String[] args) throws Throwable {
		method1();
	}
}
