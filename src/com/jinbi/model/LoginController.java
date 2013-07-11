package com.jinbi.model;

import java.sql.SQLException;

import com.jinbi.util.MD5Util;
import com.jinbi.util.MysqlDbHelper;

public class LoginController {
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
		MD5Util security = new MD5Util();
		security.setPlainText(this.pwd);
		String pwd = security.getSecurity();   
		
		/*数据库的核实*/
		MysqlDbHelper jdbc = new MysqlDbHelper();
		
		return jdbc.query(name, pwd);
	}
	
}
