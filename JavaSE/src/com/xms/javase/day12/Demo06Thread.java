package com.xms.javase.day12;
/**
 * 守护线程：
 * 	isDaemon():判断是否为守护线程
 * 	
 * 
 * 守护线程和普通线程在表现上没有区别，可以通过Thread类中的setDaemon(boolean b)方法设置成守护线程
 * 	
 * ----void setDaemon(boolean b):
 * 		可以将普通线程设置成守护线程
 * 守护线程(后台线程)特点：当进程中只剩下守护线程时，所有的守护线程将会被强制终止
 * 	gc()典型的建立在守护线程上的方法
 * 		
 * @author Administrator
 *
 */
public class Demo06Thread {
	public static void main(String[] args) {
		//rose
		Thread rose=new Thread(){
			@Override
			public void run() {
				for (int i = 0; i <5; i++) {
					System.out.println("rose:let me go!!!!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("rose:啊啊啊啊啊啊");
				System.out.println("音效：噗通~~~~~");
			}
		};
		
		//jack
		
		Thread jack =new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					System.out.println("you jump,i jump");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		
		jack.setDaemon(true);
		/*
		 * 将jack设置成守护线程，必须在该线程启动前设置守护线程
		 * 否则没有效果
		 */
		rose.start();
		jack.start();
		
		System.out.println(rose.isDaemon());
		System.out.println(jack.isDaemon()); 
		
		
		
	}
}
