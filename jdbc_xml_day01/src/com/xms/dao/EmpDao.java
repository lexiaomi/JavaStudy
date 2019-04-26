package com.xms.dao;

import java.util.List;

import com.xms.entity.Emp;

public interface EmpDao {
	
	List<Emp> getEmp();
	
	//根据员工号查询员工信息
	Emp getEmpOne(int empno);
	//增加员工信息
	int addEmp(Emp e);
	
	//修改员工信息
	int updateEmp(Emp emp);
	
	//删除指定员工信息
	
	int deleteEmpOne(int empno);
}
