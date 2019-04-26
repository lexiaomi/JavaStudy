package com.xms.javase.day14.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 客户端
 * @author Administrator
 *
 */
public class Client {
	//运行在客户端的socket
	private Socket socket;
	
	public Client() throws UnknownHostException, IOException{
		System.out.println("正在连接服务器！！");
		/*
		 * 创建socket 如果对象创建成功，就说明连接上服务器了
		 * 需要给定服务器的ip地址，和对应应用的端口号
		 */
		socket =new Socket("172.41.2.152", 8080);
		System.out.println("服务器连接成功");
	}
	
	public void start(){
		//需要从客户端向服务器发送一句话
		/*
		 * 可以通过Socket对象获取一条输出流
		 * 用于向服务器发送信息
		 * getOutputStream()
		 * 返回值为outPutStream类型的流
		 * 
		 * 
		 */
		
		try {
			/**
			 * 接收
			 */
			//将任务类搭载到对应线程中，启动线程
			GetMessage gm=new GetMessage();
			Thread t=new Thread(gm);
			t.start();
			
			/**
			 * 发送
			 */
			//获取输出流--字节流
			OutputStream os= socket.getOutputStream();
			//将字节流封装成对应的字符流
			OutputStreamWriter osw=new OutputStreamWriter(os,"utf-8");
			//将字符流封装成缓冲字符流
		
			
			
			while(true){
			PrintWriter pw=new PrintWriter(osw,true);
				Scanner sc=new Scanner(System.in);
				System.out.println("请输入一句话");
				String message=sc.nextLine();
				pw.println(message);
				pw.flush();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client c=new Client();
		c.start();
	}
	
	/*
	 * 任务类---用于读取对服务器端的信息回显
	 * 
	 */
	class GetMessage implements Runnable{

		@Override
		public void run() {
			/**
			 * 接收服务器的回显
			 */
			//通过socket获取一个输入流
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is,"utf-8");
				BufferedReader br=new BufferedReader(isr);
				String message =null;
				while((message = br.readLine())!=null){
					System.out.println("你说"+message);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
