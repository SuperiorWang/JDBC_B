<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登陆/注册</title>
</head>
<body>
 <p>------------------------------------------------------------------</p>
 <h1>这是一个登陆界面</h1><br/>
 <form action="login">
	username:<input type="text" name="name" id="name"/><br/>
	password:<input type="password" name="password" id="password"/><br/>
	<input type="submit" value="登陆"/><br/>
 </form>
 <p>------------------------------------------------------------------</p>
 <h1>这是一个注册界面</h1><br/>
 <form action="register">
 	username:<input type="text" name="username" id="username"/><br/>
	password:<input type="password" name="pwd" id="pwd"/><br/>
	<input type="submit" value="注册"/><br/>
 </form>
</body>
</html>