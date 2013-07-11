<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	com.jinbi.model.LoginController account = (com.jinbi.model.LoginController)session.getAttribute("account");
%>
<h1>注册成功</h1>
用户名:<%=account.getName() %>
密 码 :<%=account.getPwd() %>
</body>
</html>