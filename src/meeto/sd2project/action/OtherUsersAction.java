package meeto.sd2project.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class OtherUsersAction extends ActionSupport implements SessionAware {
	private Map<String, Object>	session;
	private List<String>		usersList;
	
	public String execute() {
		String users = getRmiBean().getListOtherUsers((String)session.get("username"));
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < users.split("\n").length; i++) {
			list.add(users.split("\n")[i]);
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
		if (!session.containsKey("RmiBean"))
			this.setRmiBean(new RmiBean());
		return (RmiBean) session.get("RmiBean");
	}
	
	public void setRmiBean(RmiBean rmiBean) {
		this.session.put("RmiBean", rmiBean);
	}
	
}