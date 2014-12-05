package meeto.sd2project.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AgendaItemAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object>	session;
	private static final long	serialVersionUID	= 1L;
	private int operation;//0-delete 1-modify 2-add new 3-addKeyDecision
	private int id_agenda_item;
	private int id_meeting;
	private String info;
	private List<String> chatHistory;
	
	public String execute(){
		if (operation == 0) {
			getRmiBean().deleteAgendaItem(this.id_agenda_item);
		}else if(operation == 1){
			getRmiBean().modifyAgendaItem(id_agenda_item, info);
		}else if(operation == 2){
			getRmiBean().addAgendaItem(id_meeting, info);
		}else if(operation==3){
			System.out.println(getRmiBean().addKeyDecision(id_agenda_item, info));
			return "current";
		}else{
			String result=getRmiBean().getChatHistory(id_agenda_item);
			List<String> aux = new ArrayList<String>();
			for (String s : result.split("\n")) {
				aux.add(s);
			}
			setChatHistory(aux);
			return "chat";
		}
		return "upcuming";
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

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public int getId_agenda_item() {
		return id_agenda_item;
	}

	public void setId_agenda_item(int id_agenda_item) {
		this.id_agenda_item = id_agenda_item;
	}

	public int getId_meeting() {
		return id_meeting;
	}

	public void setId_meeting(int id_meeting) {
		this.id_meeting = id_meeting;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<String> getChatHistory() {
		return chatHistory;
	}

	public void setChatHistory(List<String> chatHistory) {
		this.chatHistory = chatHistory;
	}
	
}
