<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<html> 

	<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<title>Meeto: Collaboration and Social Networking</title>
	</head> 
	<body bgcolor="#99ffff">
		<% 
			session.removeAttribute("username"); 
			session.removeAttribute("password"); 
			session.invalidate(); 
		%> 
		<h1>Logout was done successfully.</h1>
		<a href="index.jsp">Login Page</a>
	</body> 
</html>
