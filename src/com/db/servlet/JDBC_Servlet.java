package com.db.servlet;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBC_Servlet {
	private Connection conn;
	private Statement st;

	/*public JDBC_Servlet(String url,String root,String pwd) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306//text", "root","root") ;
			//conn = (Connection) DriverManager.getConnection(url,root,pwd);
		} catch (Exception e) {
			System.out.println("连接数据库失败" + e.getMessage());
		} 
	}*/
	
	public boolean query(String name,String pwd) throws SQLException
	{
		boolean  flag = false;
		try{
			System.out.println("do JDBC_Servlet1");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("do JDBC_Servlet2");
			
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
			if(conn !=  null)
				conn.close();
		}
		//return flag;
	}
}
