package com.xms.javase.day08;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

/**
 * 
 * File:
 * 	  文件或者是文件加的抽象表现形式
 * 	1.不能直接对文件内容操作
 * 	2.想要操作一个文件/文件夹，需要一个操作文件/夹的对象
 * 	只能获取文件、文件夹的周边信息，不能操作内容
 * @author Administrator
 *
 */
public class Demo02File {
	public static void method1() {
		/*
		 * java 跨平台，一次编译处处运行，到处改错
		 * 文件分隔符
		 * Windows:\
		 * Linux:/
		 * 
		 * 为了解决跨平台文件分隔符所引起的非逻辑性错误
		 * 引入一个常量：
		 * separator:这个常量可以在各个平台上，根据平台的特性，自动适应对应的文件分割符
		 * 属于File类---忽略文件分隔符的平台差一些
		 * 语法：File.separator 
		 * 
		 *  /
		File f1=new File("E:"+File.separator+"1.txt");
		File f2=new File("E:"+File.separator+"1");//表示文件夹
		
		
		
		/*
		 * 路径：
		 * 	绝对路径(全路径)：从盘符开始寻找的路径
		 *  相对路径：有一个参照物，参照的对象是当前的项目
		 *  相对于项目来寻找文件或者文件夹
		 *  
		 *  ./:表示的是当期的目录(当前项目名)
		 *  ../:表示向上返回一层(父级目录)
		 */
		//相对路径
		File f3=new File("./2.txt");
		File f4=new File("../../2.txt");
		String path = f3.getPath();
		System.out.println();
		
	}
	
	public static void method2(){
		//使用File类的方法，获取文件的信息
		File f1=new File("../1.txt");//获取文件
		File f2=new File("../test");//获取文件夹
		
		/*
		 * getName():
		 * 1.获取文件名或者文件夹的名字
		 * 返回值为字符串
		 */
		
		String fileName=f2.getName();
		System.out.println(fileName);
		
		/*
		 * exits():
		 * 1.判断文件或者目录是否存在
		 * 返回值是布尔类型
		 * 
		 */
		
		boolean bo1 = f1.exists();
		System.out.println(bo1);
		
		System.out.println("------------------------------2");
		/*
		 * length():
		 * 表示文件所占的字节数
		 * 2.返回值为整数类型的字节数(long)
		 * （文件夹中是没有长度的，无论文件夹中包含的文本有多少的字节）
		 */
		File f3=new File("./test/1.txt");
		long l1=f3.length();
		System.out.println("文件的字节大小:"+l1);
		
		long l2=f2.length();
		System.out.println("文件夹的字节大小："+l2);
		System.out.println("------------------------------3");
		
		/*
		 * 
		 * canRead():可读
		 * canWrite(): 可写
		 * canExecute:可执行
		 * true:表示可读/可写
		 * false:表示不可读/不可写, 不可执行
		 * 文件不可读，就一定不可写
		 * 可写就可读
		 */
		
		boolean bo2 = f1.canWrite();
		boolean bo3=f3.canRead();
		boolean bo4=f3.canExecute();
		System.out.println(bo2);
		System.out.println(bo3);
		System.out.println(bo4);
		
		System.out.println("------------------------------4");
		/*
		 * lastModified():
		 * 1.最后修改的时间
		 * 2.返回值类型为整数类型(long ,1970/1/1到现在的毫秒数)
		 * 
		 */
		long l3 = f3.lastModified();
		System.out.println("时间："+l3);
		
		System.out.println("------------------------------5");
		//常见的文件方法
		/*isFile()
		 * 1.表示当前的File对象是否是文件
		 * 2.boolean类型的返回值 
		 * 
		 */
		boolean bo5=f3.isFile();
		System.out.println(bo5);
		/*
		 * isDirectory()：
		 * 判断当前对象是否为文件夹(目录)
		 * 返回值为boolean类型 
		 * 
		 */
		System.out.println("------------------------------6");
		boolean bo6 = f2.isDirectory();
		boolean bo7=f3.isDirectory();
		System.out.println(bo6);
		System.out.println(bo7);
		
	}
	
	public static void method3(){
		/*
		 * creatNewFile():
		 * 创建一个文件
		 * 返回值为boolean类型
		 * true表示创建成功
		 * delete():删除一个文件或者一个文件夹
		 * 返回值boolean类型
		 * 
		 * 创建文件/文件夹,删除文件/文件夹操作：
		 * 1.先判断是否存在
		 * 2.再操作，创建或者删除
		 */
		
		File file=new File("test.txt");
		if(!file.exists()){
		try {
			boolean bo1=file.createNewFile();
			
			System.out.println("创建文件"+bo1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}else{
			boolean bo2=file.delete();
			System.out.println("删除文件："+bo2);
		}
		
		System.out.println("------------------------------1---------");
		
		/*
		 * 
		 * mkdir():创建一个目录
		 * mkdirs(): 创建一个多级目录
		 * delete():删除目录时：只能删除空的目录
		 * 	再删除多级目录时，会最先删除最底层的目录
		 */
//		File file1=new File("test1");
//		if(!file1.exists()){
//			boolean bo2=file1.mkdir();
//			System.out.println("创建文件夹"+bo2);
//		}else{
//			boolean bo3=file1.delete();
//			System.out.println("删除文件夹"+bo3);
//		}
		
		System.out.println("-----------------------------2");
		//创建一个多级目录
		File file2=new File("test2/a/b/c");
		if(!file.exists()){
			boolean bo5=file2.mkdirs();
			System.out.println("创建多级目录："+bo5);
		}else{
			System.out.println("删除多级目录："+file2.delete());
		}
		/*
		 * 删除多级目录，需要从最底层最开始删除，直到将整个文件夹删除成空的文件夹，才能被允许删除文件夹
		 * ---递归
		 * 
		 */
		/*
		 * getParentFile():
		 * 获取当前文件/文件夹的上级路径
		 * 1.返回值是File对象，
		 * getParent():
		 *  获取当前文件/文件夹的上级路径
		 * 1.返回值是String类型，
		 */
		
		System.out.println("----------------3--------------------------");
		System.out.println("----------------3--------------------------");
		File ff=file2.getParentFile();
		String ffs=file2.getParent();
		System.out.println(ff);
		System.out.println(ffs);
		
		System.out.println("----------------3--------------------------");
		/*
		 * 查看一个目录下所有文件/文件夹
		 * listFiles():
		 * 该方法是返回当前File对象目录下所有的文件/文件夹
		 * 返回值为File类型的数组(File[])
		 * 
		 * 
		 * listFiles(FileFilter ,ft):
		 * 重载的方法：该方法支持文件过滤器，按照文件过滤器中定义的方式来返回指定要求的文件
		 * 返回的是以指定条件筛选的File数组
		 */
		
		File f3=new File(".");
		if(f3.exists()){
			File[] lf= f3.listFiles();
			
			for (File file3 : lf) {
				if(file3.getName().endsWith(".txt")){
					System.out.println(file3);
				}
			}
		}
		
		
		//筛选指定文件，使用过滤器
		/*
		 * 1。定义一个文件过滤器的类，实现FileFiter接口
		 * 2.写错匿名内部类
		 * 
		 * 
		 */
		System.out.println("----------------3--------------------------");
		MyFileFilter mff=new MyFileFilter();
		if(f3.isDirectory()){
			File[] ff1=f3.listFiles(mff);
			for (File fi : ff1) {
				System.out.println(fi);
			}
		}
		
		FileFilter fff=new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				
				return false;
			}
		};
		
	}
	
	/*
	 * 创建一个多级目录下的文件
	 * 1.先得到该文件所在的父级目录，如果目录存在则创建文件，如果不存在，先创建多级目录，再创建多级目录下的·文件
	 */
	
	
	public static void method4(String path) throws IOException{
		//判断父级目录是否存在
		File f=new File(path);
		File parent= f.getParentFile();
		if(!parent.exists()){
			//创建多级目录
			parent.mkdirs();
			System.out.println("成功");
		}
		if(!f.exists()){
			f.createNewFile();
			System.out.println("成功");
		}
		
	}
	
	/*
	 * 删除多级目录
	 * 递归----？
	 * 1.考虑到极限情况，声明时候停止
	 * 2.方法内部出现重复
	 * 3.方法内出现重复操作(自己调用自己)
	 */
	public static int sum(int num){
		
		if(num<=1){
			return 1;
		}else{
			return num*sum(num-1);
		}
	}
	//递归删除目录
	public static void delete(File path){
		if(path.isDirectory()){
			File[] f=path.listFiles();
			for (File file : f) {
				delete(file);
			}
		}
		path.delete();
		System.out.println("删除成功");
			
		
		
	}

	public static void main(String[] args) throws IOException {
//		method1();
//		method2();
//		method3();
		//method4("demo\\a\\b\\1.txt");
		System.out.println(sum(100));
		delete(new File("demo"));
	}
}
