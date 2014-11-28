<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

  <head>
    <title>Meeto: Collaboration and Social Networking</title>
  </head>
  <body bgcolor="#99ffff">
  	<div align="center"> 
      <h1> Register new user </h1>      
	  <hr color="#0080C0" />
  	<br>
	  <s:form action="registerNewUser" method="post"> 
  	    <s:textfield name="username" label="Username " required="true" /> 
  	   	<s:textfield name="password" label="Password " required="true"/> 
        <s:textfield name="dob" label="Date of bithday " required="true"/>     
  	  	<s:submit value="Register" />
    </s:form>

  	<a href="index.jsp"> Return to login page </a>
  	</div>
  </body>
</html>
</html>