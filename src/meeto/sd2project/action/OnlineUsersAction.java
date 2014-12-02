package meeto.sd2project.action;
import java.util.*;
import meeto.sd2project.model.RmiBean;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class OnlineUsersAction extends ActionSupport implements SessionAware {

	private static final long	serialVersionUID	= 1L;
	private Map<String, Object> session;
	private List<String> onlineUsersList=new ArrayList<String>();
	public String execute(){
		String onlineUsers = getRmiBean().getOnlineUsers();
		for (int i = 0; i < onlineUsers.split("\n").length; i++) {
			onlineUsersList.add(onlineUsers.split("\n")[i]);
		}
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;		
	}
	public RmiBean getRmiBean() {
		if (!session.containsKey("RmiBean")){
			this.setRmiBean(new RmiBean());
		}
		return (RmiBean) session.get("RmiBean");
	}
	
	public void setRmiBean(RmiBean rmiBean) {
		this.session.put("RmiBean", rmiBean);
	}
	public List<String> getOnlineUsersList() {
		return onlineUsersList;
	}
	public void setOnlineUsersList(List<String> onlineUsersList) {
		this.onlineUsersList = onlineUsersList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
}
