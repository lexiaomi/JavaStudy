package com.xms.javase.day08;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		//定义一个过滤规则
		return pathname.getName().endsWith(".txt");
	}
	
}
