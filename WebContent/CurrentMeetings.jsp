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
         	<a href='#'>Current meetings</a>
         </li>
		 <li>
		 <a href='UpcomingMeetings.jsp'>Upcoming meetings</a>
         </li>
      </ul>
   </li>
   
   <li><a href='Messages.jsp'>Messages</a></li>
   
   <li><a href='TodoList.jsp'>TODO</a></li>
   <li><a href='OnlineUsers.jsp'>Online Users</a></li>
   <li><a href='LogOut.jsp'>Logout (${session.username})</a></li>
</ul>
</div>

	<s:action name="currentMeetingList" var="currentMeeting" />
	<s:action name="meetingInfo" var="meetingInfo" />

	<s:property value="id_meeting"/>
	<div align="center">
		<h1>Current Meetings of user ${session.username}:</h1>
		<br> <br>
		<div style="width: 1000px; float: left;">
			<p>Messages:</p>
			<s:select list="#currentMeeting.meetingList" name="meeting" listKey="studentID" size="20" style="width: 450px"  />
		<s:form action="getInfoMeeting" method="post">
			<s:submit value="Get info" align="center" />
		</s:form>
		</div>
		<!--  <div style="margin-left: 100px;">
			<div align="left">
				<br> <br>
				<h2>
                    Meeting title: <font color = "red"><s:property value="#meetingInfo.title" /></font>
                </h2>
                <h2>
                    Meeting local: <font color = "red"><s:property value="#meetingInfo.local" /></font>
                </h2>
                <h2>
                    Meeting desired outcome: <font color = "red"><s:property
                            value="#meetingInfo.outcome" /></font>
                </h2>
                <h2>
                    Meeting start date: <font color = "red"><s:property
                            value="#meetingInfo.startDate" /></font>
                </h2>
                <h2>
                    Meeting end date: <font color = "red"><s:property value="#meetingInfo.endDate" /></font>
                </h2>
                <h2>
                    Users attending: <font color = "red"><s:property value="#meetingInfo.users" /></font>
                </h2>
                <h2>
                    Agenda itens: <font color = "red"><s:property value="#meetingInfo.agendaItens" /></font>
                </h2>
                <h2>
                    Action itens: <font color = "red"><s:property value="#meetingInfo.actionItens" /></font>
                </h2>
			</div>
		</div> -->
	</div>

</body>
</html>
