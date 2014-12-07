<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>

<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="styles.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
   <title>Meeto: Chat History</title>
   
   
   
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
   <li><a href='OnlineUsers.jsp'>Online Users</a></li>
   <li><a href='LogOut.jsp'>Logout (${session.username})</a></li>
</ul>
</div>


<div align="left">
	<b><font size="5" color="red"> 
	
	
	
	<c:forEach
		items="${chatHistory}" var="chatHistory">
		<c:out value="${chatHistory}" />
		<br>
		<br>
	</c:forEach>
	</font></b>
</div>

<a href="PastMeetings.jsp"> Return </a>

</body>
</html>
