package com.xms.test;

import java.util.List;

import com.xms.dao.DeptDao;
import com.xms.daoimpl.DeptDaoImpl;
import com.xms.entity.Dept;

public class TestJDBC2 {
	
	//增加部门信息
	public static  void  addDept() {
		DeptDao deptDao=new  DeptDaoImpl();
		Dept dept=new Dept(60,"市场部","长沙");
		int i = deptDao.insertDept(dept);
		if(i>0) {
			System.out.println("插入成功");
		}
	}
	
	//查询指定部门信息
	
	public static void getEmpOne() {
		DeptDao deptDao=new  DeptDaoImpl();
		Dept deptOne = deptDao.selectDeptOne(60);
		System.out.println(deptOne);
	}
	
	//查询全部部门信息
	
	public static void getEmpAll() {
		DeptDao deptDao=new  DeptDaoImpl();
		List<Dept> deptAll = deptDao.selectDeptAll();
		for (Dept dept : deptAll) {
			System.out.println(dept);
		}
	}
	
	// 删除指定部门信息
	public static  void  deleteDept() {
		DeptDao deptDao=new  DeptDaoImpl();
		
		int i = deptDao.deleteDept(50);
		if(i>0) {
			System.out.println("删除成功");
		}
	}
	
	// 修改指员工的信息
	
	public static void updateDept() {
		DeptDao deptDao=new  DeptDaoImpl();
		Dept dept=new Dept();
		dept.setDeptno(20);
		dept.setDname("研发部");
		dept.setLocation("南京");
		
		int n= deptDao.updateDept(dept);
		if(n>0) {
			System.out.println("修改成功");
		}
	}
	
	public static void main(String[] args) {
		addDept();
//		getEmpOne();
//		getEmpAll();
//		deleteDept();
//		updateDept();
	}
}
