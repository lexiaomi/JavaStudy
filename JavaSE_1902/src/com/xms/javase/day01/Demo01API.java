package com.xms.javase.day01;

import com.xms.basic.day13.Animal;

/**
 * JAVAME:微型版Javase,这个是在JavaSE的基础之上，删除部分类和接口，同时添加一部分关于游戏开发的的功能类(手机小游戏)
 * JavaSE：基础Java；主要是一些基本的类和接口，以及对应的方法(抽象类，接口，方法，普通类.......)
 * JavaEE:是在基础的JavaSE的前提下。加上部分的关于web编程的类和组件(企业级开发);
 *	---文档注释：写在类的前面，解释类的； 写在方法前，解释方法的；
 *			只有文档注释才会在生成doc文档显示出来
 *
 * @author  李丽君
 * @see 参考文献。引用的知识点
 * @version 封装这个类时，所使用的版本JDK 1.6
 * @since 从哪个版本支持这种功能
 * 
 * jar包：就是一个封装好的类，或者是接口
 * 生成jar包:选择对应要生成的类或者是接口，
 * 		步骤：Export--->Java-->JARfile
 * 
 * 导入jar包：选择要导入的项目名，在项目名下创建Folder,命名为lib,将需要导入的的jar包(.jar, .zip)复制到lib文件中，添加文件资源路径，也就是add Builder path
 * 
 */
public class Demo01API {
	
	
	public static void main(String[] args) {
		Animal an=new Animal();
	}
	/**
	 * 这个方法叫add方法，在方法中输出一句字符串
	 */
	public void add(){
		/*
		 * 多行注释(一段逻辑代码的上面，)---一般是解释一部分代码的意思
		 * 这就是一个输出语句
		 */
		System.out.println("add()");// 单行注释---解释一句代码的含义 写在一句代码之后或者这句代码上面
	}
	
	
	/**
	 * 这个方法是计算两个int类型的数字想加的方法
	 * @param a int类型的参数a
	 * @param b int类型的参数b
	 * @return  返回值是a+b的和
	 */
	public int add1(int a,int b){
		System.out.println("int-add(int a,int b");
		return a+b;
	}
}
