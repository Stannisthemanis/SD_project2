package meeto.sd2project.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import meeto.sd2project.model.RmiBean;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CurrentMeetingListAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object>	session;
	private static final long	serialVersionUID	= 1L;
	private List<String> meetingList;
	
	
	public String execute(){
		String username = (String) session.get("username");
		if (username == null) {
			return LOGIN;
		}
		String messages = getRmiBean().getCurrentMeetingList(username);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < messages.split("\n").length; i++) {
			list.add(messages.split("\n")[i]);
		}
		setMeetingList(list);
		return SUCCESS;
	}
	
	public String getMeetingInfo(){
//		List<Student> MeetingsList = (List<Student>)ActionContext.getContext().getSession().get("currentMeeting.meetingList");
//		int idemeeting = ActionContext.getContext().getSession().get("studentID");
//		String studentName = student.getStudentName();
		return "ooooo: " + (String) ActionContext.getContext().getSession().get("studentID");
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

	public List<String> getMeetingList() {
		return meetingList;
	}

	public void setMeetingList(List<String> meetingList) {
		this.meetingList = meetingList;
	}
	
}
