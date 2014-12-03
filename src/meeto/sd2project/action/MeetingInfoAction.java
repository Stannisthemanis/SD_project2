package meeto.sd2project.action;

import java.util.List;
import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MeetingInfoAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object>	session;
	private static final long	serialVersionUID	= 1L;
	private int					id_meeting;
	private String				title;
	private String				local;
	private String				outcome;
	private String				startDate;
	private String				endDate;
	private String				users;
	private List<String>		agendaItens;
	private List<String>		actionItens;
	
	public String execute() {
		String meetingInfo = getRmiBean().getMeetingResume(this.id_meeting);
		setData(meetingInfo);
		return SUCCESS;
	}
	
	public int getId_meeting() {
		return this.id_meeting;
	}
	
	public void setId_meeting(int id_meeting) {
		System.out.println(id_meeting);
		this.id_meeting = id_meeting;
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
	
	public void setData(String meetingInfo) {
		String[] tokenizer = meetingInfo.split(",");
//		for (String i : tokenizer) {
//			System.out.println(i);
//		}
		setTitle(tokenizer[0]);
		setOutcome(tokenizer[2]);
		setLocal(tokenizer[3]);
		setStartDate(tokenizer[4]);
		setEndDate(tokenizer[5]);
		setUsers(tokenizer[6]);
		for(String i: tokenizer[7].split("\n")){
			System.out.println("- " + i);
		}
	}

	
	public List<String> getAgendaItens() {
		return agendaItens;
	}

	public void setAgendaItens(List<String> agendaItens) {
		this.agendaItens = agendaItens;
	}

	public List<String> getActionItens() {
		return actionItens;
	}

	public void setActionItens(List<String> actionItens) {
		this.actionItens = actionItens;
	}
	
}
