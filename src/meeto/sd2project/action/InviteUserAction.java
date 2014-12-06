package meeto.sd2project.action;

import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class InviteUserAction extends ActionSupport implements SessionAware {
	private Map<String, Object>	session;
	private static final long	serialVersionUID	= 1L;
	private String				invitedUser;
	private String				id_meeting;

	
	public String execute(){
		int id = Integer.parseInt(this.id_meeting.replace(" ", "").split("-")[0]);
		getRmiBean().inviteUser(id, this.invitedUser);
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
	
	public String getInvitedUser() {
		return invitedUser;
	}
	
	public void setInvitedUser(String invitedUser) {
		this.invitedUser = invitedUser;
	}
	
	public String getId_meeting() {
		return id_meeting;
	}
	
	public void setId_meeting(String id_meeting) {
		this.id_meeting = id_meeting;
	}
	
}
