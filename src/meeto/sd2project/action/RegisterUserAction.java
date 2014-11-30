package meeto.sd2project.action;

import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterUserAction extends ActionSupport implements SessionAware {
	
	private static final long	serialVersionUID	= 1L;
	private Map<String, Object>	session;
	private String				username			= null;
	private String				password			= null;
	private String				day					= null;
	private String				month				= null;
	private String				year				= null;
	
	@Override
	public String execute() throws Exception {
		if (username != null && password != null && day != null && month != null && year != null) {
			String dob = day + "/" + month + "/" + year;
			if (getRmiBean().registerNewUser(username + "," + password + "," + dob)) {
				return SUCCESS;
			} else {
				return LOGIN;
			}
		}
		return LOGIN;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public RmiBean getRmiBean() {
		if (!session.containsKey("RmiBean"))
			this.setRmiBean(new RmiBean());
		return (RmiBean) session.get("RmiBean");
	}
	
	public void setRmiBean(RmiBean rmiBean) {
		this.session.put("RmiBean", rmiBean);
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
