package com.xms.javase.day14.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务器类
 *  应用大于进程，一个应用一个端口号
 * 端口号：选择端口号要注意：0-1024这些端口号已经被系统预留的
 * 当你在编写服务器端口选择端口号时，要大于1024的端口号
 * @author Administrator
 *
 */
public class Server {
	//运行在服务器上的socket
	private ServerSocket server;
	//线程池对象 --搭载任务类
	private ExecutorService threadPool;
	//创建一个共享集合---所有客户端的输出流
	private List<PrintWriter> allOut;
	
	
	/*
	 * 初始化服务器
	 * 
	 */
	public Server() throws Throwable{
		
		System.out.println("初始化服务器");
		//需要指定服务器的端口号
		server=new ServerSocket(8080);
		//创建固定数量线程的线程池
		threadPool=Executors.newFixedThreadPool(20);
		//初始化共享集合
		allOut=new LinkedList<PrintWriter>();
		
		
		System.out.println("服务器初始化成功");
		
		
	}
	
	/*
	 * 服务器开始的方法
	 */
	
	public void start(){
	/*
	 * 服务器端的accept()：
	 * 用于监听8080,等待客户端连接
	 * 是一个线程阻塞的方法，直到一个客户端连接完成，则该方法返回一个socket类型的对象
	 * 没有连接一直处于等待状态
	 */
		try {
			while(true){
				System.out.println("等待客户端连接");
				Socket socket = server.accept();
				//任务接收socket对象
				ClientHandler cs=new ClientHandler(socket);
				//将接收到的socket对象任务纳入线程池管理
				threadPool.execute(cs);
				System.out.println("客户端连接成功");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server=new Server();
			server.start();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 内部类---任务类
	 * 接收socket对象，完成对话任务
	 * 这个类是接收客户端发来的信息
	 * 有可能是多个客户端的信息
	 * 需要多个任务，需要多线程解决
	 *  写成---任务类：方便使用线程池
	 *  
	 */
	
	class ClientHandler implements Runnable{
		
		
		//任务是接收当前的客户端对象
		private Socket socket;
		private String name;
		
		public ClientHandler(Socket socket){
			this.socket=socket;
//			this.name=name;
			
			InetAddress inter=socket.getInetAddress();
			//获取计算机的IP地址
			String ip=inter.getHostAddress();
			//获取计算机名
			String name1=inter.getHostName();
			//获取计算机的端口号
			int port = socket.getPort();
			
			System.out.println("获取远端计算机的ip:"+ip+"端口为"+port+"计算机名："+name1);
			System.out.println(inter);
			System.out.println(name);
			System.out.println(port);
			
		}
		@Override
		public void run() {
			
			InputStream is;
			PrintWriter pw=null;
			try {
				/*
				 * 
				 * 将客户端发送来的信息,再发送给客户端
				 * 消息回显
				 */
				//字节输出流
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os,"utf-8");
				//缓冲字符流单位行输出
				 pw=new PrintWriter(osw,true);
				addOut(pw);
				/*
				 * 接收Socket对象信息
				 * 
				 */
	
				is = socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is,"utf-8");
				BufferedReader br=new BufferedReader(isr);
			
				String getmessage=null;
				while((getmessage=br.readLine())!=null){
//					System.out.println(getmessage);
//					pw.println(getmessage);
					/*
					 * 将某一个客户端发送的信息，通过共享集合
					 * 中所有客户端输出流，将该信息发送给所有客户端
					 */
					sendMssage(getmessage);
				}
				br.close();
				pw.flush();
			
				//将刚才从客户端读取的信息写出到客户端上---回显
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				/*
				 * 清理操作
				 * 当某个客户端下线后，对应的out流
				 * 应该从共享集合移除
				 */
				removeOut(pw);
				//下线，当前对象的socket就需要关闭
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		/**
		 * 为了保证这三个方法成互斥关系，使用互斥关系
		 * @param pw
		 */
		//向共享集合中添加输出流
		public synchronized void addOut(PrintWriter pw){
			allOut.add(pw);
		}
		
		//从共享集合中删除输出流
		public synchronized void removeOut(PrintWriter pw){
			allOut.remove(pw);
		}
		
		//遍历集合中的输出流，---相当于发送信息
		/*
		 * 在线(客户端在共享中)
		 * 将所有客户端的输出流封装成一个方法
		 * 然后将给定的信息通过遍历该集合，即
		 * 通过客户端的输出流发送给各个客户端
		 */
		public synchronized void sendMssage(String message){
			for ( PrintWriter pw : allOut) {
				pw.println(message);
			}
			
		}
		
	}
	
	
	
	
	
	
}
