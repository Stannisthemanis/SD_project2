package meeto.sd2project.action;

import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ChatAction extends ActionSupport implements SessionAware {

	private Map<String, Object>	session;
	private static final long	serialVersionUID	= 1L;
	private int idAgendaItem;
	private String username;
	private String message;
	
	//int id_agenda_item, String user, String message
	public String execute(){
		System.out.println("antes");
		getRmiBean().addMessage(idAgendaItem, username, message);
		System.out.println("despois");
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	
	public RmiBean getRmiBean() {
		if (!session.containsKey("RmiBean"))
			this.setRmiBean(new RmiBean());
		return (RmiBean) session.get("RmiBean");
	}
	
	public void setRmiBean(RmiBean rmiBean) {
		this.session.put("RmiBean", rmiBean);
	}

	public int getIdAgendaItem() {
		return idAgendaItem;
	}

	public void setIdAgendaItem(int idAgendaItem) {
		this.idAgendaItem = idAgendaItem;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
