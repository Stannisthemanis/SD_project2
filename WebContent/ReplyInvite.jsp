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
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<script src="script.js"></script>
<title>Meeto: Collaboration and Social Networking</title>
</head>
<c:choose>
	<c:when test="${session.username == null}">
		<c:redirect url="index.jsp" />
	</c:when>
</c:choose>
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

			<li><a href='Messages.jsp'>Messages</a></li>

			<li><a href='TodoList.jsp'>TODO</a></li>
			<li><a href='OnlineUsers.jsp'>Online Users</a></li>
			<li><a href='LogOut.jsp'>Logout (${session.username})</a></li>
		</ul>
	</div>

	<script type="text/javascript">
		function accept(id) {
			var id_invite = id.split("-")[0];
			window.location = "/SD_project2/replyInvite.action?answer=yes&id_invite="
					+ id_invite;
		}

		function decline() {
			var id_invite = id.split("-")[0];
			window.location = "/SD_project2/replyInvite.action=answer=no&id_invite="
					+ id_invite;
		}
	</script>

	<div align="center">
		<h1>Message of user ${session.username}:</h1>
		<br> <br>
		<h2>
			Invited by: <font color="red"><s:property
					value="userResponsable" /></font>
		</h2>
		<h2>
			Meeting title: <font color="red"><s:property value="title" /></font>
		</h2>
		<h2>
			Meeting local: <font color="red"><s:property value="local" /></font>
		</h2>
		<h2>
			Meeting desired outcome: <font color="red"><s:property
					value="outcome" /></font>
		</h2>
		<h2>
			Meeting start date: <font color="red"><s:property
					value="startDate" /></font>
		</h2>
		<h2>
			Meeting end date: <font color="red"><s:property
					value="endDate" /></font>
		</h2>
		<h2>
			Users attending: <font color="red"><s:property value="users" /></font>
		</h2>
		<h2>
			Agenda itens: <font color="red"><br> <c:forEach
					items="${agendaItens}" var="agendaItens">
					<c:out value="${agendaItens}" />
					<br>
				</c:forEach></font>
		</h2>
		<br> <br> <br>
		<button onclick="accept(this.value)" value="${id_invite}">Accept</button>
		<button onclick="decline()">Decline</button>
		<a href="Messages.jsp"><font size="5">return</font></a>
	</div>
</body>
</html>
