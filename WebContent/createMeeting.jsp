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
   <title>CSS MenuMaker</title>
</head>
<body bgcolor="#99ffff">

<div id='cssmenu'>
<ul>
   <li><a href='#'>Home</a></li>
   
   <li class='active'><a href='#'> Create meeting</a>
   
   <li class='active'><a href='#'> My Meetings</a>
      <ul>
         <li><a href='#'>Past meetings</a>
            <ul>
               <li><a href='#'>a</a></li>
               <li><a href='#'>b</a></li>
			   <li><a href='#'>c</a></li>
            </ul>
         </li>
         <li><a href='#'>Current meetings</a>
            <ul>
               <li><a href='#'>x</a></li>
               <li><a href='#'>y</a></li>
            </ul>
         </li>
		 <li><a href='#'>Upcoming meetings</a>
            <ul>
               <li><a href='#'>x</a></li>
               <li><a href='#'>y</a></li>
            </ul>
         </li>
      </ul>
   </li>
   
   <li><a href='#'>Messages</a></li>
   
   <li><a href='#'>TODO</a></li>
   <li><a href='#'>Online Users</a></li>
   <li><a href='LogOut.jsp'>Logout</a></li>
</ul>
</div>
  <h1> Creating a new meeting </h1>      
  <form  action="NewMeetingAction" method="post" name="formCreateMeeting"> 
        <br/>
  	    Title: <input type="text" name="title"> 
        <br/><br/>
  	   	Outcome: <input type="text" name="outecome"> 
        <br/> <br>
		Local:<input type="text" name="local"> 
        <br/> <br>
        Date:  <input type="text" name="date">     
       <br/> <br>
       Starting time: <input type="text" name="start"> (h) 
       <br/> <br>
       Duration:<input type="text" name="duration"> 
       <br/> <br>
       ver a parte dos convidados..
       <br/> <br>
 	  <input type="submit" value="Register"> 
  </form> 
	  
</body>
</html>
