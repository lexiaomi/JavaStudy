package com.xms.javase.day13.p;
/**
 * 1.小红，小明，小黑负责教室的卫生工作
	主要工作内容为：檫黑板，洒水，扫地
	这三位同学各自负责
		小明：檫黑板
		小红：洒水 wait
		小黑：扫地小红.jion
		顺序：先檫黑板，再洒水，最后扫地
		使用线程的知识，完成他们的工作安排
 */
public class TestThread2 {
	public static void main(String[] args) {
		TestThread2 tt=new TestThread2();
		XiaoMing xm=new XiaoMing(tt);
		XiaoHei xh=new XiaoHei(tt);
		XiaoHong xho=new XiaoHong(tt);
		
		xm.start();
		xho.start();
		try {
			xho.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xh.start();
		
	}
}

class XiaoMing extends Thread{
	final private TestThread2  te;
	
	
	public XiaoMing(TestThread2  te) {
		this.te=te;
	}
	@Override
	public  void run() {
		// TODO Auto-generated method stub
		System.out.println("小明在擦黑板");
		
		synchronized (te) {
			te.notify();
		}
		
	}
}

class XiaoHong extends Thread{
	
	
	final private TestThread2  te;
	
	public XiaoHong(TestThread2  te){
		this.te=te;
	}
	@Override
	public  void run() {
		try {
			synchronized (te) {
				te.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		System.out.println("小红在洒水");
	}
}

class XiaoHei extends Thread{
	final private TestThread2  te;
	public XiaoHei(TestThread2  te){
		this.te=te;
	}
	
	@Override
	public  void run() {
		// TODO Auto-generated method stub
		
		System.out.println("小黑在扫地");
	
	}
}
