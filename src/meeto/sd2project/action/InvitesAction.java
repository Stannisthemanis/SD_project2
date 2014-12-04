package meeto.sd2project.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class InvitesAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object>	session;
	private static final long	serialVersionUID	= 1L;
	private String				id_invite;
	private String				userResponsable;
	private String				title;
	private String				local;
	private String				outcome;
	private String				startDate;
	private String				endDate;
	private String				users;
	private String				agendaItens;
	private String				answer;
	
	public String execute() {
		String inviteInfo = getRmiBean().getMessageInfo(Integer.parseInt(this.id_invite.replace(" ", "").split("-")[0]));
		setData(inviteInfo);
		return SUCCESS;
	}
	
	public String accept() {
		System.out.println(getRmiBean().replyToInvite(Integer.parseInt(this.id_invite.replace(" ", "").split("-")[0]), "Yes"));
		return SUCCESS;
	}
	
	public String decline() {
		getRmiBean().replyToInvite(Integer.parseInt(this.id_invite.replace(" ", "").split("-")[0]), "No");
		return SUCCESS;
	}
	
	public String getId_invite() {
		return this.id_invite;
	}
	
	public void setId_invite(String id_invite) {
		this.id_invite = id_invite;
	}
	
	public String getUserResponsable() {
		return this.userResponsable;
	}
	
	public void setUserResponsable(String userResponsable) {
		this.userResponsable = userResponsable;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLocal() {
		return this.local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getOutcome() {
		return this.outcome;
	}
	
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getUsers() {
		return this.users;
	}
	
	public void setUsers(String users) {
		this.users = users;
	}
	
	public String getAgendaItens() {
		return this.agendaItens;
	}
	
	public void setAgendaItens(String agendaItens) {
		this.agendaItens = agendaItens;
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
	
	public void setData(String inviteInfo) {
		String[] tokenizer = inviteInfo.split(",");
		for (String i : tokenizer) {
			System.out.println(i);
		}
		setTitle(tokenizer[0]);
		setUserResponsable(tokenizer[1]);
		setOutcome(tokenizer[2]);
		setLocal(tokenizer[3]);
		setStartDate(tokenizer[4]);
		setEndDate(tokenizer[5]);
		setUsers(tokenizer[6]);
		setAgendaItens(tokenizer[7]);
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
