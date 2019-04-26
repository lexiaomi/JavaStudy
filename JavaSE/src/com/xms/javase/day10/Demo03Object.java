package com.xms.javase.day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象流：
 * 	可以保存一个对象
 * 	1.将对象转成字节，
 * 	2.长久保存到硬盘中
 * 	
 * 1.将一个特定的数据结构，转换成一组字节的过程叫做序列化
 * 2.将这个数据写入到硬盘中做长久保存的过程--持久化
 * 3.将一组字节转成特定的数据结构的过程---反序列化
 * 
 *
 * 序列化 ，反序列化的作用：
 * 	1.数据传输：
 * 	2.数据保存：
 * 
 * ObjectInputStream():对象输入流
 * 	---readObject()
 * ObjectOutputStream()：对象输出流
 * 	---writeObject()
 * 
 * 
 * Serializable:接口
 * 如果想要对一个类的对象进行序列化，那么这个类必须要实现可序列化的接口即Serializable
 * 一旦某个类实现了该接口，这表示这个类的对象具备可序列化的资格
 * 
 * private static final long serialVersionUID = 1L;
 * 在我们序列化之后，对该类的属性或者方法等进行了修改，会出现不同的异常，为了防止异常发生，引入一个
 * serialVersionUID,防止在反序列化时发生异常
 * IDE自动生成
 * 
 * transient:
 * 	修饰成员变量，在序列化可以忽略该属性的值(在序列化时，属性的值不保存，有属性存在)
 * 	在反序列化时有该属性的存在，没有之前传入的数据，只有默认值
 * 
 * @author Administrator
 *
 */
public class Demo03Object {
	//序列化
	public static void method1() throws Throwable{
		
		//低级流
		
		FileOutputStream fos=new FileOutputStream("Student.txt");
		//高级流---对象流
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Student stu=new Student("张三",20,120);
		/*
		 * void write(Object o)
		 * 该方法是ObjectOutputStream 类中的方法
		 * 该方法将给定的对象转成一组字节后，写到目标文件中
		 * ---void
		 */
		
		oos.writeObject(stu);
		
		
		oos.close();
		System.out.println("序列化完成");
		
		
	}
	//反序列化
	public static void method2() throws Throwable{
		//低级流
		FileInputStream fis=new FileInputStream("Student.txt");
		ObjectInputStream ois= new ObjectInputStream(fis);
		/*
		 * 
		 * readObject():
		 * 读取一个对象，返回值为Object类型
		 * 需要进行强制转换才能调用对应类型的成员方法和成员变量
		 * 
		 * 
		 */
		
		Object obj = ois.readObject();
		if(obj instanceof Student){
			Student s=(Student) obj;
			System.out.println(s.name);
			System.out.println(s.age);
			System.out.println(s.id);
			s.study();
			
		}
		
		ois.close();
		System.out.println("反序列化完成");
		
	}
	
	public static void main(String[] args) throws Throwable {
		method1();
		method2();
	}
	
	
}


//学生类

class Student implements Serializable{
	/**
	 * IDE自动生成的版本号
	 */
	private static final long serialVersionUID = 1L;
	String name;
	transient int age;
	int id;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age,int id) {
		this.name = name;
		this.age = age;
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	public void study(){
		System.out.println("学生学习");
	}
	
	
}