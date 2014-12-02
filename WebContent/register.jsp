<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang=''>

<head>
<title>Meeto: Collaboration and Social Networking</title>
</head>
<body bgcolor="#99ffff">
	<div align="center">
		<h1>Register new user</h1>
		<hr color="#0080C0" />
		<br>
		<s:action name="correctDate" executeResult="false" var = "date"/>
		<s:form action="registerNewUser" method="post">
			<s:textfield name="username" label="Username " required="true" />
			<s:password name="password" label="Password " required="true" />
			<s:select label="Day of birth" list="#date.dayList" name = "day"/>
			<s:select label="Month of birth" list="#date.monthList" name = "month"/>
			<s:select label="Year of birth" list="#date.userYearList" name = "year" />
			<s:submit value="Register" />
		</s:form>

		<a href="index.jsp"> Return to login page </a>
	</div>
</body>
</html>
</html>