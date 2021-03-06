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
   <title>Meeto: Collaboration and Social Networking</title>
   
   <script type="text/javascript">

        var websocket;

        window.onload = function() { // execute once the page loads
            initialize();
            document.getElementById("chat").focus();
        }

        function initialize() { // URI = ws://10.16.0.165:8080/chat/chat~
            connect('ws://' + window.location.host + '/SD_project2/chat');
        }

        function connect(host) { // connect to the host websocket servlet
            if ('WebSocket' in window){
                websocket = new WebSocket(host);
            }
            else if ('MozWebSocket' in window){
                websocket = new MozWebSocket(host);
            }
            else {
                writeToHistory('Get a real browser which supports WebSocket.');
                return;
            }       
                        
            websocket.onopen    = onOpen; // set the event listeners below
            websocket.onclose   = onClose;
            websocket.onmessage = onMessage;
            websocket.onerror   = onError;
        }

        function onOpen(event) {
           // writeToHistory('Connected to ' + window.location.host + '.');
            document.getElementById('chat').onkeydown = function(key) {
                if (key.keyCode == 13)
                    doSend(); // call doSend() on enter key
            };
        }
        
        function onClose(event) {
            writeToHistory('WebSocket closed.');
            document.getElementById('chat').onkeydown = null;
        }
        
        function onMessage(message) { // print the received message
            writeToHistory(message.data);
        }
        
        function onError(event) {
            writeToHistory('WebSocket error (' + event.data + ').');
            document.getElementById('chat').onkeydown = null;
        }
        
        function doSend() {
       		var username = document.getElementById("username").value;
       		var id_agenda_item = document.getElementById("id_agenda_item").value;
            var message = document.getElementById('chat').value;
            document.getElementById('chat').value = '';
            if (message != '')
                websocket.send(id_agenda_item+","+username+","+message); // send the message
          //  window.location = "/SD_project2/sendChat.action?idAgendaItem="+id_agenda_item+"&username="
			//		+ username+"&message="+message;
        }

        function writeToHistory(text) {
            var history = document.getElementById('history');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.innerHTML = text;
            history.appendChild(p);
            while (history.childNodes.length > 25)
                history.removeChild(console.firstChild);
            history.scrollTop = history.scrollHeight;
        }

    </script>
   
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

<div>
	<input type="hidden" id="username" value="${sessionScope.username}">
	<input type="hidden" id="id_agenda_item" value="${id_agenda_item}">
    <div id="container"> <div id="history"></div> </div>
    <p> <input type="text" placeholder="type to chat" id="chat"> </p>
</div>

</body>
</html>
