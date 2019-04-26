package com.xms.entity;

import java.util.Date;

/**
 * 实体类：封装Emp对象(按照表结构)
 * @author Administrator
 *
 */
public class Emp {
	private int empno;
	private String ename;
	private String position;
	private double salary;
	private double bouns;
	private Date hiredate; // java.util
	private int leader;
	private int deptno;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getBouns() {
		return bouns;
	}
	public void setBouns(double bouns) {
		this.bouns = bouns;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getLeader() {
		return leader;
	}
	public void setLeader(int leader) {
		this.leader = leader;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", position=" + position + ", salary=" + salary + ", bouns="
				+ bouns + ", hiredate=" + hiredate + ", leader=" + leader + ", deptno=" + deptno + "]";
	}
	
	
	
	
}
