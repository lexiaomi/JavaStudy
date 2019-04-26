package com.xms.javase.day12.p;

public class Thread3 {
	public static void main(String[] args) {
		wugui wg=new wugui("拫實");
		tuzi tz=new tuzi("赶赽");
		wg.setPriority(10);
		
		tz.setPriority(1);
		wg.start();
		tz.start();
	}
}

class wugui extends Thread{
	
	public wugui(String name){
		super(name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName()+"===拫實婓變"+this.getPriority());
		}
	}
}
class tuzi extends Thread{
	
	public tuzi(String name){
		super(name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName()+"===芤赽婓變"+this.getPriority());
		}
	}
}