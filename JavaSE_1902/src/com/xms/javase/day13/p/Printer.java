package com.xms.javase.day13.p;


/**
 * 创建两个线程
 * 一个线程打印字母（A-Z）
 * 一个线程打印数字
 * 要求在控制台输出效果如下：
 * AB1CD2EF3GH4......YZ13
 * 
 */
public class Printer {
	int index=1;
	public static void main(String[] args) {
		Printer p=new Printer();
		Charac c=new Charac(p);
		Num n=new Num(p);
		c.start();
		n.start();
	}
	public synchronized void ptc(char c){
		while(index%3==0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print(c);
		index++;
		notify();
	}
	public synchronized void ptn(int i){
		while(index%3!=0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print(i);
		index++;
		notify();
	}
	
}

class Charac extends Thread{
	private Printer p;
	public Charac(Printer p) {
		this.p = p;
	}
	//打印字符
	@Override
	public void run() {
		for(char c='A';c<='Z';c++){
			p.ptc(c);
		}
		
	}
}

class Num extends Thread{
	private Printer p;
	
	public Num(Printer p) {
		this.p = p;
	}

	//打印数字
	@Override
	public void run() {
		for(int i=1;i<=13;i++){
			p.ptn(i);
		}
	}
}