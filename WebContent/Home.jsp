<!doctype html>
<html lang=''>

<head>
   <meta charset='utf-8'>
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
   
   <li class='active'><a href='createMeeting.jsp'> Create meeting</a>
   
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

</body>
<html>
