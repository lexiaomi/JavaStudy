package com.xms.entity;

public class Dept {
	private int deptno;
	private String dname;
	private String Location;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Dept() {
		
	}
	public Dept(int deptno, String dname, String location) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		Location = location;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", Location=" + Location + "]";
	}

	
}
