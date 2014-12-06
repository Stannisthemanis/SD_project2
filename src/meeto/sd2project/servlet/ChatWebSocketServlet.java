package meeto.sd2project.servlet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import meeto.sd2project.model.RmiBean;

@ServerEndpoint(value = "/chat")
public class ChatWebSocketServlet  {

	private static final long serialVersionUID = 1L;
	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
	@OnOpen
	public void onOpen(Session session) {
		 System.out.println("New request received. Id: " + session.getId());
	        sessions.add(session);
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("Connection closed. Id: " + session.getId());
        sessions.remove(session);
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		int id_agenda_item = Integer.parseInt(message.split(",")[0]);
		String username = message.split(",")[1];
		String text = message.split(",")[2];
		message=username+": "+text;
		message = "<b><font size=\"5\">" + message + "</font></b>";
        for (Session s : sessions) {
            System.out.println("Sending to " + s.getId());
            s.getAsyncRemote().sendText(message);
        }
        new RmiBean().addMessage(id_agenda_item, username, text);
	}
	
	@OnError
	public void onError(Throwable t) throws Throwable {
//		System.out.println("error");
//		for (Session s : sessions) {
//            sessions.remove(s);
//        }
	}


}