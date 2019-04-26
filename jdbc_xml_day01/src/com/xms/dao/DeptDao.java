package com.xms.dao;

import java.util.List;

import com.xms.entity.Dept;

public interface DeptDao {
	//添加部门
	int insertDept(Dept dept);
	
	//查询指定部门信息
	Dept selectDeptOne(int deptno);

	List<Dept> selectDeptAll();

	int deleteDept(int deptno);

	int updateDept(Dept dept);
	
	
}
