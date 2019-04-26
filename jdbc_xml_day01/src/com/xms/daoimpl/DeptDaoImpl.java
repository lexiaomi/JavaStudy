package com.xms.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xms.dao.DeptDao;
import com.xms.entity.Dept;
import com.xms.util.DButils;

public class DeptDaoImpl implements DeptDao{

	@Override
	public int insertDept(Dept dept) {
		Connection connection = DButils.getConnection();
		Statement statement =null;
		int n=0;
		try {
			statement = connection.createStatement();
			String sql="insert into dept_li values ("+dept.getDeptno()+",'"+dept.getDname()+"','"+dept.getLocation()+"')";
			System.out.println(sql);
			n = statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButils.closeAll(statement, connection, null);
		}
		return n;
	}

	@Override
	public Dept selectDeptOne(int deptno) {
		Connection connection = DButils.getConnection();
		Statement statement =null;
		ResultSet rs = null;
		Dept dept= null;
		try {
			statement=connection.createStatement();
			String sql="select * from dept_li where deptno="+deptno;
			System.out.println(sql);
			rs = statement.executeQuery(sql);
			if(rs.next()) {
				dept= new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLocation(rs.getString("location"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButils.closeAll(statement, connection, rs);
		}
		return dept;
	}

	@Override
	public List<Dept> selectDeptAll() {
		Connection connection = DButils.getConnection();
		Statement statement =null;
		ResultSet rs = null;
		List<Dept> list= new ArrayList<Dept>();
		try {
			statement=connection.createStatement();
			String sql="select * from dept_li ";
			System.out.println(sql);
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				Dept dept= new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLocation(rs.getString("location"));
				list.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButils.closeAll(statement, connection, rs);
		}
		return list;
	}

	@Override
	public int deleteDept(int deptno) {
		Connection connection = DButils.getConnection();
		Statement statement =null;
		int n=0;
		try {
			statement = connection.createStatement();
			String sql="delete from dept_li where deptno="+deptno;
			System.out.println(sql);
			n = statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButils.closeAll(statement, connection, null);
		}
		return n;
	}

	@Override
	public int updateDept(Dept dept) {
		
		Connection connection = DButils.getConnection();
		Statement statement =null;
		int n=0;
		try {
			statement = connection.createStatement();
			String sql="update dept_li set dname='"+dept.getDname()+"',location='"+dept.getLocation()+"' where deptno="+dept.getDeptno()+"";
			System.out.println(sql);
			n = statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButils.closeAll(statement, connection, null);
		}
		return n;
	}

}
