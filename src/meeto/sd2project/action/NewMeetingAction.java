package meeto.sd2project.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

public class NewMeetingAction extends ActionSupport implements SessionAware {
	private static final long	serialVersionUID	= 1L;
	private String				title				= null;
	private String				outcome				= null;
	private String				local				= null;
	private String				day					= null;
	private String				month				= null;
	private String				year				= null;
	private String				hour				= null;
	private String				minute				= null;
	private String				duration			= null;
	private String				invitedUsers		= null;
	private String				agendaItens			= null;
	private Map<String, Object>	session;
	
	public String execute() {
		String username = (String) session.get("username");
		String date = day + "/" + month + "/" + year + "," + hour + ":" + minute;
		String listAgendaItens = agendaItens.replace("\n", ",");
		if (invitedUsers.equals("")) {
			invitedUsers = "none";
		}
		String newMeeting = String.format("%s-%s-%s-%s-%s-%s-%s-%s", username, outcome, local, title, date, invitedUsers,
				listAgendaItens, duration);
		getRmiBean().insertNewMeeting(newMeeting);
		return SUCCESS;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getOutcome() {
		return this.outcome;
	}
	
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	
	public String getLocal() {
		return this.local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getDay() {
		return this.day;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public String getMonth() {
		return this.month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getYear() {
		return this.year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getHour() {
		return this.hour;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public String getMinute() {
		return this.minute;
	}
	
	public void setMinute(String minute) {
		this.minute = minute;
	}
	
	public String getInvitedUsers() {
		return this.invitedUsers;
	}
	
	public void setInvitedUsers(String invitedUsers) {
		this.invitedUsers = invitedUsers;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getAgendaItens() {
		return agendaItens;
	}
	
	public void setAgendaItens(String agendaItens) {
		this.agendaItens = agendaItens;
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
