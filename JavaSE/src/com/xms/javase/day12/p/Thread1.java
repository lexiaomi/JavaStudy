package com.xms.javase.day12.p;

public class Thread1 {
	public static void main(String[] args) {
//		HuoCheP hp=new HuoCheP("窗口1");
		HuoCheP hp=new HuoCheP();
		Thread t1=new Thread(hp,"窗口1");
		Thread t2=new Thread(hp,"窗口2");
		t1.start();
		t2.start();
//		HuoCheP hp2=new HuoCheP("窗口2");
//		hp2.start();
	}
}

class HuoCheP implements Runnable  {
	private  int tickNum=10;
	
//	public HuoCheP(String name){
//		super(name);
//	}
	
	@Override
	public void run() {
		for (int i = 1; i <=100; i++) {
			if(tickNum>0){
				System.out.println("我在"+Thread.currentThread().getName()+"买到了火车票，剩余第"+tickNum--+"张车票");
			}
		}
	}
	
	
	
}