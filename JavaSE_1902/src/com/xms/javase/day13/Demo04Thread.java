package com.xms.javase.day13;
/**
 * 判断一个类是否安全的标准：
 * 	
 * 
 * 
 * @author Administrator
 *
 */
public class Demo04Thread {
//	StringBuffer sb=new StringBuffer();
	static StringBuilder sb1=new StringBuilder("00001111");
	
	public static void main(String[] args) {
		Thread t1=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 1000; i++) {
					sb1.reverse();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(sb1+Thread.currentThread().getName());
				}
			}
			
			
		};
		
		Thread t2=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 1000; i++) {
					sb1.reverse();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(sb1+Thread.currentThread().getName());
				}
			}
			
			
		};
		t1.start();
		t2.start();
		
		
		
	}
}
