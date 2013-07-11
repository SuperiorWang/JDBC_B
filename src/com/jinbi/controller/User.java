package com.jinbi.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jinbi.model.LoginController;

public class User extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		/*打印接收到的数据*/
		System.out.println("username="+name+":"+"password="+pwd);
		
		HttpSession session = request.getSession();
		
		LoginController account = new LoginController();
		account.setName(name);
		account.setPwd(pwd);
		
		try {
			if (name != "" && pwd != "" && account.Check())
			{
				session.setAttribute("account", account);
				String login_suc = "loginsuc.jsp";
				response.sendRedirect(login_suc);
				return ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String login_fail = "fail.jsp";
		response.sendRedirect(login_fail);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
