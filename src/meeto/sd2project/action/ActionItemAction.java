package meeto.sd2project.action;

import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ActionItemAction extends ActionSupport implements SessionAware {
	
	private static final long	serialVersionUID	= 1L;
	private Map<String, Object>	session;
	private String				actionName			= null;
	private String				user				= null;
	private String				id_meeting;
	private int					operation;					// 0-add new 1-set
	private String				id_action_item;
	
	public String execute() {
		System.out.println(this.operation);
		System.out.println(this.id_meeting);
		System.out.println(this.actionName);
		System.out.println(this.user);
		if (this.operation == 0) {
			this.getRmiBean().addActionItem(Integer.parseInt(id_meeting.split("-")[0]), actionName, user);
			return "new";
		} else {
			this.getRmiBean().setActionAsDone(Integer.parseInt(id_action_item.split("-")[0]));
			return "setdone";
		}
	}
	
	public String getId_action_item() {
		return this.id_action_item;
	}

	public void setId_action_item(String id_action_item) {
		this.id_action_item = id_action_item;
	}

	public String getId_meeting() {
		return this.id_meeting;
	}
	
	public void setId_meeting(String id_meeting) {
		this.id_meeting = id_meeting;
	}
	
	public String getActionName() {
		return actionName;
	}
	
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public RmiBean getRmiBean() {
		if (!session.containsKey("RmiBean"))
			this.setRmiBean(new RmiBean());
		return (RmiBean) session.get("RmiBean");
	}
	
	public void setRmiBean(RmiBean rmiBean) {
		this.session.put("RmiBean", rmiBean);
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}
	
	public int getOperation() {
		return operation;
	}
	
	public void setOperation(int operation) {
		this.operation = operation;
	}
	
}
