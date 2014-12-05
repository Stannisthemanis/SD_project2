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

@ServerEndpoint(value = "/chat")
public class ChatWebSocketServlet  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private final AtomicInteger sequence = new AtomicInteger(0);    
	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
//	protected String nickname;
//	private ChatWebSocketServlet(int id) {
//        this.nickname = "Client" + id;
//    }
//	
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
//		try {
//			System.out.println("sending message");
//			session.getBasicRemote().sendText(message.toUpperCase());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("-> "+sessions.size());
		System.out.println("Message Received: " + message);
        for (Session s : sessions) {
//        	if()
            System.out.println("Sending to " + s.getId());
            s.getAsyncRemote().sendText(message);
        }
	}
	
	@OnError
	public void onError(Throwable t) throws Throwable {
//		System.out.println("error");
//		for (Session s : sessions) {
//            sessions.remove(s);
//        }
	}


}