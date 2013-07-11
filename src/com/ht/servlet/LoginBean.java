package com.ht.servlet;

import java.sql.SQLException;

import com.db.servlet.JDBC_Servlet;
import com.security.md5.securityCode;

public class LoginBean {
	private String name ;
	private String pwd ;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/*查询数据库*/
	public boolean Check() throws SQLException {
		/*转换md5密码*/
		securityCode security = new securityCode();
		security.setPlainText(this.pwd);
		String pwd = security.getSecurity();   
		
		/*数据库的核实*/
		JDBC_Servlet jdbc = new JDBC_Servlet();
		//JDBC_Servlet jdbc = new JDBC_Servlet("jdbc:mysql://localhost:3306//text", "root","root");
		
		return jdbc.query(name, pwd);
	}
	
}
