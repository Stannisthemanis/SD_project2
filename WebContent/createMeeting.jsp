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
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
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
         <li><a href='PastMeetings.jsp'>Past meetings</a>
         </li>
         <li><a href='CurrentMeetings.jsp'>Current meetings</a>
         </li>
		 <li><a href='UpcomingMeetings'>Upcoming meetings</a>
         </li>
      </ul>
   </li>
   
   <li><a href='Messages.jsp'>Messages</a></li>
   <li><a href='TodoList.jsp'>TODO</a></li>
   	<li><a href='OnlineUsers.jsp'>Online users</a></li>
   <li><a href='LogOut.jsp'>Logout</a></li>
</ul>
</div>
  <h1> Creating a new meeting </h1>      
  <form  action="NewMeetingAction" method="post" name="formCreateMeeting"> 
        <br/>
  	    Title: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
  	    <input type="text" name="title"> 
        <br/><br/>
  	   	Outcome: &nbsp; &nbsp; &nbsp; 
  	   	<input type="text" name="outecome"> 
        <br/> <br>
		Local:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
		<input type="text" name="local"> 
        <br/> <br>
        Date:  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
        <input type="text" name="date">
		<s:date name="d"  /><br/> <br>
       Starting time: 
       <input type="text" name="start"> (h) 
       <br/> <br>
       Duration: &nbsp; &nbsp; &nbsp; 
       <input type="text" name="duration"> 
       <br/> <br>
       ver a parte dos convidados..
       <br/> <br>
       	
 	  <input type="submit" value="Register"> 
  </form> 
	  
</body>
</html>
