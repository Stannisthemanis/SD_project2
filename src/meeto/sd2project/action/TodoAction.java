package meeto.sd2project.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class TodoAction extends ActionSupport implements SessionAware {
	private Map<String, Object>	session;
	private static final long	serialVersionUID	= 1L;
	private List<String> todoList;
	
	
	public String execute(){
		List<String> list = new ArrayList<String>();
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


	public List<String> getTodoList() {
		return todoList;
	}


	public void setTodoList(List<String> todoList) {
		this.todoList = todoList;
	}
	
}
