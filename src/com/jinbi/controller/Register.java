package com.jinbi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jinbi.model.LoginController;
import com.jinbi.util.MD5Util;
import com.jinbi.util.MysqlDbHelper;

public class Register extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OK-----------!");
		HttpSession sesson = request.getSession();
		
		String name = request.getParameter("username");
		String password = request.getParameter("pwd");
		System.out.println("username: " + name + ":" + "password: " + password);
		
		LoginController account = new LoginController();
		account.setName(name);
		account.setPwd(password);
		
		if (name != "" && password != "" && password.length()>=3)
		{
			MD5Util pwd = new MD5Util();
			pwd.setPlainText(password);
			String index = pwd.getSecurity();
			
		    MysqlDbHelper mysql = new MysqlDbHelper();
		    
		    if (mysql.insert(name,password)){
				sesson.setAttribute("account", account);
				String registerSuc = "RegisterSuc.jsp";
				response.sendRedirect(registerSuc);
				return ;
		    }
		}
		
		String registerFail = "RegisterFail.jsp";
		response.sendRedirect(registerFail);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
