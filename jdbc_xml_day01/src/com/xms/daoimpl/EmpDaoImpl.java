package com.xms.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.xms.dao.EmpDao;
import com.xms.entity.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> getEmp() {
		// TODO Auto-generated method stub
		Connection connection =null;
		Statement statement = null;
		ResultSet rs = null;
		List<Emp> list= new ArrayList<Emp>();
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" 加载驱动成功");
			// 建立连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jsd","root","1234");
			System.out.println(" 建立连接成功");
			
			//创建会话
			statement = connection.createStatement();
			System.out.println(" 创建会话成功");
			String sql="select * from emp_xu";
			// 执行SQL语句
			rs = statement.executeQuery(sql);
			System.out.println(" 执行SQL语句成功");
			// 处理结果集
			while (rs.next()) {
					Emp emp= new Emp();
					int empno= rs.getInt("empno");
					emp.setEmpno(empno);
					String ename=rs.getString("ename");
					emp.setEname(ename);
					String position=rs.getString("salary");
					emp.setPosition(position);
					double salary=rs.getDouble("salary");
					emp.setSalary(salary);
					double bouns=rs.getDouble("bouns");
					emp.setBouns(bouns);
					Date hiredate=rs.getDate("hiredate");
					emp.setHiredate(hiredate);
					int leader=rs.getInt("leader");
					emp.setLeader(leader);
					int deptno=rs.getInt("deptno");
					emp.setDeptno(deptno);
					
					list.add(emp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null) {
						rs.close();
					}
					
					if(statement!=null) {
						statement.close();
					}
					// 关闭连接
					if(connection!=null) {
					connection.close();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
			}
		}
		
		return list;
	}

	@Override
	public Emp getEmpOne(int empno) {
		Connection connection =null;
		 Statement statement = null;
		ResultSet rs = null;
		Emp emp= null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" 加载驱动成功");
			// 建立连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jsd","root","1234");
			System.out.println(" 建立连接成功");
			
			//创建会话
			statement = connection.createStatement();
			System.out.println(" 创建会话成功");
			// 执行SQL语句
			String sql="select * from emp_xu where empno="+empno;
			rs = statement.executeQuery(sql);
			System.out.println(" 执行SQL语句成功");
			// 处理结果集
			if(rs.next()) {
					emp= new Emp();
					//数字表示查询结果集返回字段对应的顺序，从1开始
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setPosition(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setBouns(rs.getDouble(5));
					emp.setHiredate(rs.getDate(6));
					emp.setLeader(rs.getInt(7));
					emp.setDeptno(rs.getInt(8));
					
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null) {
						rs.close();
					}
					
					if(statement!=null) {
						statement.close();
					}
					// 关闭连接
					if(connection!=null) {
					connection.close();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
			}
	}
		return emp;
	}

	@Override
	public int addEmp(Emp e) {

		Connection connection =null;
		Statement statement = null;
		int  n=0;
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" 加载驱动成功");
			// 建立连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jsd","root","1234");
			System.out.println(" 建立连接成功");
			
			//创建会话
			statement=connection.createStatement();
			System.out.println(" 创建会话成功");
			
			// 执行SQL语句
			String sql="insert into emp_xu values ("
			+e.getEmpno()+",'"
			+e.getEname()+"','"
			+e.getPosition()+"',"
			+e.getSalary()+","
			+e.getBouns()+
			",date_format('"+new Date(e.getHiredate().getTime())+"','%X-%m-%d'),"
			+e.getLeader()+","
			+e.getDeptno()+")";
			System.out.println("sql语句"+sql);
			
			n=statement.executeUpdate(sql);
			System.out.println(n);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				if(statement!=null) {
					statement.close();
				}
				// 关闭连接
				if(connection!=null) {
				connection.close();
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		
		}
		}
		
		return n;
	}

	@Override
	public int updateEmp(Emp emp) {
		Connection connection =null;
		Statement st=null;
		int n = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jsd？characterEncoding=utf8","root","1234");
			st = connection.createStatement();
			String sql="update emp_xu set ename='"+emp.getEname()+"',position='"+emp.getPosition()
			+"',salary="+emp.getSalary()+",bouns="+emp.getBouns()+",hiredate=date_format('"+new Date(emp.getHiredate().getTime())+"','%X-%m-%d'),"
			+"leader="+emp.getLeader()+",deptno="+emp.getDeptno()+" where empno="+emp.getEmpno()+"";
			System.out.println(sql);
			n = st.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(st!=null) {
					st.close();
				}
				// 关闭连接
				if(connection!=null) {
				connection.close();
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		
		}
		}
		return n;
	}

	@Override
	public int deleteEmpOne(int empno) {
		Connection connection = null;
		Statement st = null;
		int i =0;
		try {
			//创建驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 创建连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jsd","root","1234");
			// 创建会话
			st =connection.createStatement();
			// 执行sql
			String sql="delete from emp_xu where empno="+empno;
			System.out.println(sql);
			i = st.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(st!=null) {
					st.close();
				}
				// 关闭连接
				if(connection!=null) {
				connection.close();
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		
		}
		}
		return i;
	}
	
	

}
