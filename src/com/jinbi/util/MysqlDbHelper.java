package com.jinbi.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MysqlDbHelper {
	private Connection conn;
	private Statement st;
	private PreparedStatement pstmt;

	public boolean insert(String name,String pwd)
	{
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
			pstmt = (PreparedStatement) conn.prepareStatement("INSERT INTO staff values(?,?)");	
			
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			pstmt.executeUpdate();
			
			flag = true;
		}catch(Exception e){
			System.out.println("插入失败!");
		}finally{
			if (st != null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				st = null;
			}
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		return flag;
	}
	
	public boolean query(String name,String pwd) throws SQLException
	{
		boolean  flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root") ;
			st = (Statement) conn.createStatement();
			String sql = "SELECT * FROM staff" ; 
			ResultSet res = st.executeQuery(sql);
			System.out.println("查询结果!");
			
			while (res.next())
			{
				if (((res.getString("username")).equals(name)) && ((res.getString("password")).equals(pwd))){
					flag = true;
				}		
			}
			
		}catch(SQLException e){
			System.out.println("查询失败");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if (st != null){
				st.close();
				st = null;
			}
			if(conn !=  null){
				conn.close();
				conn = null;
			}
		}
		return flag;
	}
}
