package meeto.sd2project.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class OtherUsersAction extends ActionSupport implements SessionAware {
	
	private static final long	serialVersionUID	= 1L;
	private Map<String, Object>	session;
	private List<String>		usersList;
	private String				id_meeting;
	
	public String execute() {
		String username = (String) session.get("username");
		String users = getRmiBean().getListOtherUsers(username);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < users.split("\n").length; i++) {
			list.add(users.split("\n")[i]);
		}
		setUsersList(list);
		return SUCCESS;
	}
	
	public String getAllUsers() {
		String users = getRmiBean().getListOtherUsers("");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < users.split("\n").length; i++) {
			list.add(users.split("\n")[i]);
		}
		setUsersList(list);
		return SUCCESS;
	}
	
	public String getUsersNotInvited() {
		String username = (String) session.get("username");
		String notInvitedUser = getRmiBean().getNotInvitedUsers(Integer.parseInt(this.id_meeting.replace(" ", "").split("-")[0]));
		List<String> list = new ArrayList<String>();
		for (String s : notInvitedUser.split("\n")) {
			if (!s.equals(username)){
				list.add(s);
			}
		}
		setUsersList(list);
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public List<String> getUsersList() {
		return usersList;
	}
	
	public void setUsersList(List<String> usersList) {
		this.usersList = usersList;
	}
	
	public RmiBean getRmiBean() {
		if (!session.containsKey("RmiBean")) {
			this.setRmiBean(new RmiBean());
		}
		return (RmiBean) session.get("RmiBean");
	}
	
	public void setRmiBean(RmiBean rmiBean) {
		this.session.put("RmiBean", rmiBean);
	}
	
	public String getId_meeting() {
		return id_meeting;
	}
	
	public void setId_meeting(String id_meeting) {
		this.id_meeting = id_meeting;
	}
	
}
