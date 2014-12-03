package meeto.sd2project.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long	serialVersionUID	= 1L;
	private String				username			= null;
	private String				password			= null;
	private Map<String, Object>	session;
	
	@Override
	public String execute() {
		if (this.password != null && this.username != null) {
			if (getRmiBean().login(username, password)) {
				session.put("username", username);
				//if(!getRmiBean().isUserAlreadyOnline(username)){
//					System.out.println("c, putting "+((String)session.get("username"))+" online");
					getRmiBean().putUserOnline(((String)session.get("username")));
				//}	
//				System.out.println(session.get("username").toString() + " Loggedin");
				getRmiBean().putUserOnline(((String)session.get("username")));
				return SUCCESS;
			} else {
				return LOGIN;
			}
		}
		return LOGIN;
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
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
