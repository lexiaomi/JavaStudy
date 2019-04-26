package com.xms.javase.day13.p;
/**
 * 2.三个人抢100张车票，直到将车票抢购完，提示车票已经售完
 * @author Administrator
 *
 */
public class TestThread {
	
	public static void main(String[] args) {
		TrainTicket tt=new TrainTicket();
		Thread t1=new Thread(tt,"小小");
		Thread t2=new Thread(tt,"小红");
		Thread t3=new Thread(tt,"小白");
		t1.start();
		t2.start();
		t3.start();
	}
	
	
}

class TrainTicket implements Runnable{
	private static int ticket=100;
	
	@Override
	public void run() {
		for (int i = 1; i < 100; i++) {
			synchronized (this) {
				if(ticket>0){
					
					try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()+"买到了火车票,剩余"+ticket--+"张");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		System.out.println("车票已经售完");
		
		
	}
	
}


