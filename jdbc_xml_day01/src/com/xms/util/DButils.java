package com.xms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DButils {
	
	public static  Connection getConnection() {
		Connection connection = null;
		try {
			// ´´½¨Çý¶¯
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jsd","root","1234");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeAll( Statement state,Connection conn,ResultSet rs){
		try {
			if(state!=null){
				state.close();
			}
			if(conn!=null){
				conn.close();
			}
			
			if(rs!=null){
				rs.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
