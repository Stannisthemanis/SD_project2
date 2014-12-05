package meeto.sd2project.action;

import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ReplyAction extends ActionSupport implements SessionAware {
	private static final long	serialVersionUID	= 1L;
	private Map<String, Object>	session;
	private String answer;
	private int id_invite;
	
	public String execute(){
		getRmiBean().replyToInvite(this.id_invite, answer);
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getId_invite() {
		return id_invite;
	}

	public void setId_invite(int id_invite) {
		this.id_invite = id_invite;
	}
	
}
