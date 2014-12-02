<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

			<li><a href='#'> Create meeting</a>
			<li class='active'><a href='#'> My Meetings</a>
				<ul>
					<li><a href='PastMeetings.jsp'>Past meetings</a></li>
					<li><a href='CurrentMeetings.jsp'>Current meetings</a></li>
					<li><a href='UpcomingMeetings'>Upcoming meetings</a></li>
				</ul></li>

			<li><a href='Messages.jsp'>Messages</a></li>
			<li><a href='TodoList.jsp'>TODO</a></li>
			<li><a href='OnlineUsers.jsp'>Online users</a></li>
			<li><a href='LogOut.jsp'>Logout</a></li>
		</ul>
	</div>
	<h1>Creating a new meeting</h1>

	<s:action name="correctDate" var="date" />
	<s:action name="otherUsers" executeResult="true" var="user" />

	<s:form action="newMeting" method="post">
		<s:textfield name="title" label="Title" required="true" />
		<s:textfield name="outcome" label="Outcome" required="true" />
		<s:textfield name="local" label="Local" required="true" />
		<s:select label="Day of meeting" list="#date.dayList" name="day" />
		<s:select label="Month of meeting" list="#date.monthList" name="month" />
		<s:select label="Year of meeting" list="#date.meetingYearList"
			name="year" />
		<s:select label="Hour" list="#date.hourList" name="hour" />
		<s:select label="Minutes" list="#date.minuteList" name="minute" />
		<s:textfield name="duration" label="Duration(min)" required="true" />
		<s:checkboxlist label="Users to invite" list="#user.usersList"
			name="invitedUsers" />
		<s:textarea label="Agenda Itens" name="agendaItens" col="100" row="40" />
		<s:submit value="Create meeting" />
	</s:form>

</body>
</html>
