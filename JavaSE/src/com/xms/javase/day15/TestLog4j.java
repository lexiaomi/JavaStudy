package com.xms.javase.day15;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * y用于Log4j的测试类
 * 	用类充当Log4j的日志记录器
 * @author Administrator
 *
 */
public class TestLog4j {
	//获取日志记录器，当前类(本类的名字)
	static Logger logger=Logger.getLogger(TestLog4j.class);
	
	public static void main(String[] args) {
		//加载配置文件
		PropertyConfigurator.configure("./src/com/xms/javase/day15/testLog4j.properties");
		
		for (int i = 0; i <15; i++) {
			logger.info("this is an info");
			logger.warn("this is an warn");
			logger.error("this is an Error");
			logger.debug("this is an Debug");
		}
		
	}
	
}
