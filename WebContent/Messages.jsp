<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang=''>

<head>
<meta charset='utf-8'>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles.css">
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<script src="script.js"></script>
<title>Meeto: Collaboration and Social Networking</title>
</head>
<body bgcolor="#99ffff">

	<div id='cssmenu'>
		<ul>
			<li><a href='Home.jsp'>Home</a></li>

			<li><a href='createMeeting.jsp'> Create meeting</a>
			<li class='active'><a href='#'> My Meetings</a>
				<ul>
					<li><a href='PastMeetings.jsp'>Past meetings</a></li>
					<li><a href='CurrentMeetings.jsp'>Current meetings</a></li>
					<li><a href='UpcomingMeetings.jsp'>Upcoming meetings</a></li>
				</ul></li>

			<li><a href='#'>Messages</a></li>

			<li><a href='TodoList.jsp'>TODO</a></li>
			<li><a href='OnlineUsers.jsp'>Online Users</a></li>
			<li><a href='LogOut.jsp'>Logout (${session.username})</a></li>
		</ul>
	</div>
	<s:action name="messageList" var="messages" />

	<div align="center">
		<h1>Messages of user ${session.username}:</h1>
		<br> <br>
		<div style="width: 1000px; float: left;">
			<p>Messages:</p>
			<s:select list="#messages.messageList" name="message" size="20" style="width: 450px"/>
		</div>
		<div style="margin-left: 100px;">
			<div align="left">
				<br> <br>
				<h2>Invited by:</h2>
				<h2>Meeting title:</h2>
				<h2>Meeting local:</h2>
				<h2>Meeting desired outcome:</h2>
				<h2>Meeting start date:</h2>
				<h2>Meeting end date:</h2>
				<h2>Users attending:</h2>
				<h2>Agenda itens:</h2>
			</div>
		</div>
	</div>

</body>
</html>
