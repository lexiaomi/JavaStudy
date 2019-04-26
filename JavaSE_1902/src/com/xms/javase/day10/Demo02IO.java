package com.xms.javase.day10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 缓冲字节输入输出流
 * 	---高级流
 * BufferInputStream:缓冲字节输入流
 * 	--read()
 * BufferOutputStream:缓冲字节输出流
 * ---write()
 * 
 * 内部各自维护着一个缓冲区：(自带缓冲区)
 * 
 * 关流只需要关闭高级流即可，低级流会随着高级流的关闭而关闭
 * 自带缓冲区和自己定义一个缓冲数组的的区别：
 * 在相同的字节长度下，is/os缓冲区，要比bis和bos自带的缓冲区的数据的写出和写入要快一些，因为少了一个换车的“环节”
 * @author Administrator
 *
 */
public class Demo02IO {
	public static void method1() throws Throwable{
		//低级流
		FileOutputStream fos=new FileOutputStream("44.txt");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		/*
		 * 自带缓冲区的输出流，只有将缓冲区存满，才会自动将内容一次性写出，如果没有满，则不会将未满的缓冲区数据写出
		 * 1.调用flush；强制将未满的数据缓冲区写出
		 * 	会降低读写效率，有时候为了保证数据的及时性和有效性依然会调用该方法
		 * 2.关闭流；
		 * 
		 * 
		 * 
		 */
		/*
		 * 
		 */
		bos.write(10);
		bos.write(1);
		bos.write(30);
		
		bos.close();
		
		System.out.println("--------------------------------------");
		InputStream is=new FileInputStream("44.txt");
		
		BufferedInputStream bis=new BufferedInputStream(is);
		int d=-1;
		while((d=bis.read())!=-1){
			System.out.println(d);
			
		}
		
		
		
//		bos.flush();
		bis.close();
		
		
		
	}
	public static void method2() throws Throwable{
		FileInputStream fis=new FileInputStream("test.txt");
		FileOutputStream fos=new FileOutputStream("dest.txt");
		
		BufferedInputStream bis=new BufferedInputStream(fis);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		//加个缓冲数组
		byte[] bytes=new byte[1024];
		long start =System.currentTimeMillis();
		
		int src = bis.read(bytes);
		while(src!=-1){
			bos.write(bytes,0,src);
			src=bis.read(bytes);
			
		}
		long ends=System.currentTimeMillis();
		
		bos.close();
		bis.close();
		System.out.println("复制完毕，所用时间"+(ends-start)+"毫秒");
		
		
	}
	
	public static void method3(){
		
	}
	public static void main(String[] args) throws Throwable {
//		method1();
		method2();
	}
}
