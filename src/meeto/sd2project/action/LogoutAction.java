package meeto.sd2project.action;

import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {
	
	private static final long	serialVersionUID	= 1L;
	private Map<String, Object>	session;
	
	@Override
	public String execute() {
		String userToRemove=((String)session.get("username"));
		boolean tf=getRmiBean().logout(userToRemove);
		if (tf) {
			session.remove("username");
			System.out.println("removing "+ userToRemove);
			getRmiBean().removeUserOnline(userToRemove);
			System.out.println(userToRemove+" removed!");
			return SUCCESS;
		} else {
			return LOGIN;
		}
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
	
}
