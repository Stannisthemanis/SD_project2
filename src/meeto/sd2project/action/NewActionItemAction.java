package meeto.sd2project.action;

import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class NewActionItemAction extends ActionSupport implements SessionAware {
	
	private static final long	serialVersionUID	= 1L;
	private Map<String, Object>	session;
	private String actionName 		= null;
	private String user 			= null; 
	private String meetingSelected  =null;
	
	public String execute() {
		//System.out.println("NewActionItemAction: inserting action item");
		int meetingNumber=Integer.parseInt(meetingSelected.split("-")[0]);
		System.out.println("NewActionItemAction: adding new action item: M-> "+meetingNumber+" U-> "+user
				+" A-> "+actionName);
		boolean suc = getRmiBean().insertNewActionItem(meetingNumber,actionName,user);
		if(suc)
			return SUCCESS;
		return LOGIN;
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

	public String getMeetingSelected() {
		return meetingSelected;
	}

	public void setMeetingSelected(String meetingSelected) {
		this.meetingSelected = meetingSelected;
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
		this.session=arg0;
		
	}
	
}
