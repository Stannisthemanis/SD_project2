<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang=''>

<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="styles.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
   <title>Meeto: Collaboration and Social Networking</title>
</head>
	<c:choose>
		<c:when test="${session.username == null}">
			<c:redirect url="index.jsp"/>
		</c:when>
	</c:choose>
<body bgcolor="#99ffff">

<div id='cssmenu'>
<ul>
   <li><a href='Home.jsp'>Home</a></li>
   
   <li><a href='createMeeting.jsp'> Create meeting</a>
   
   <li class='active'><a href='#'> My Meetings</a>
      <ul>
         <li>
         	<a href='PastMeetings.jsp'>Past meetings</a>   
         </li>
         <li>
         	<a href='CurrentMeetings.jsp'>Current meetings</a>
         </li>
		 <li>
		 <a href='UpcomingMeetings.jsp'>Upcoming meetings</a>
         </li>
      </ul>
   </li>
   
   <li><a href='Messages.jsp'>Messages</a></li>
   
   <li><a href='TodoList.jsp'>TODO</a></li>
   <li><a href='#'>Online Users</a></li>
   <li><a href='LogOut.jsp'>Logout (${session.username})</a></li>
</ul>
</div>
<h1> Online users </h1>
<s:action name="onlineUsers" executeResult="false" var="user" /> 
<s:select multiple="true" name="onlineUsers" list="#user.onlineUsersList" size="20" style="width: 450px" />

</body>
</html>
