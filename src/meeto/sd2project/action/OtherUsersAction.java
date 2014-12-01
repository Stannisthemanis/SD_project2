package meeto.sd2project.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

public class OtherUsersAction extends ActionSupport implements SessionAware {
	private Map<String, Object>	session;
	private List<String>		usersList;
	
	public String execute() {
//		System.out.println("a");
		String users = getRmiBean().getListOtherUsers((String)session.get("username"));
//		System.out.println("b");
		List<String> list = new ArrayList<String>();
//		System.out.println("c");
		for (int i = 0; i < users.split("\n").length; i++) {
//			System.out.println("ading");
			list.add(users.split("\n")[i]);
		}
//		System.out.println("setting");
		setUsersList(list);
//		System.out.println("returning success");
		//Scanner sc = new Scanner(System.in);
		//sc.nextInt(); sc.next();
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
		System.out.println("1");
		if (!session.containsKey("RmiBean")){
			System.out.println("2");
			this.setRmiBean(new RmiBean());
		}
		System.out.println("3");
		return (RmiBean) session.get("RmiBean");
	}
	
	public void setRmiBean(RmiBean rmiBean) {
		this.session.put("RmiBean", rmiBean);
	}
	
}
