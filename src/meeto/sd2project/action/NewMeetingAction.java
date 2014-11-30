package meeto.sd2project.action;

import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
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
	private String				invitedUsers		= null;
	
	public String execute() {
		System.out.println(invitedUsers);
		System.out.println(invitedUsers.equals(""));
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
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
