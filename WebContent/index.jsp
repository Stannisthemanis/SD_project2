<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meeto: Collaboration and Social Networking</title>
</head>
<body bgcolor="#99ffff">
	<div align="center">
		<h1>Welcome to Meeto</h1>
		<hr color="#0080C0" />
		<s:form action="login" method="post">
			<s:textfield name="username" label="Username" required="true" />
			<br>
			<s:password name="password" label="Password" required="true" />
			<br>
			<s:submit value="Log in" align="center" />
			<s:actionmessage />
		</s:form>
		<br> <br> <a href="register.jsp"> Click here to register
		</a>
		<!--  
	<form action="login" method="post" name="formLogin">
		Username: <input type="text" name="username"> <br><br>
		Password: <input type="text" name="password"> <br><br>
		<input type="button" value="Get in">
	</form>
	-->
	</div>
</body>
</html>