 package com.xms.javase.day12;
/**
 * finally:最终的
 * 		和try-catch一块使用
 * 		无论try块中的代码是否异常，finally的语句都会被执行
 * 		通常是使用finall做清理操作
 * 
 * 		比如IO的关流，数据库的关闭连接
 * @author Administrator
 *
 */
public class Demo03Exception {
	public static void main(String[] args) {
		try {
			System.out.println("尝试与数据库建立连接");
			System.out.println("加载驱动");
			System.out.println("连接成功");
			System.out.println("操作数据中");
			String a="a";
			int i=Integer.parseInt(a);
			System.out.println(i);
			System.out.println("向数据库中操作数据");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
//			e.getMessage();
			/*
			 * 
			 * 日志记录器
			 * 
			 */
		}finally{
			//最终的必需要做的操作
			System.out.println("关闭数据库连接");
		}
		
		
	}
}
