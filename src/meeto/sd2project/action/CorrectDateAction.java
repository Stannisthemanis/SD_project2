package meeto.sd2project.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class CorrectDateAction extends ActionSupport {
	
	private static final long	serialVersionUID	= 1L;
	private List<Integer>		dayList;
	private List<Integer>		monthList;
	private List<Integer>		meetingYearList;
	private List<Integer>		userYearList;
	private List<Integer>		hourList;
	private List<Integer>		minuteList;
	
	public String execute() {
		dayList = new ArrayList<Integer>();
		setDayList();
		monthList = new ArrayList<>();
		setMonthList();
		meetingYearList = new ArrayList<>();
		setMeetingYearList();
		userYearList = new ArrayList<>();
		setUserYearList();
		hourList = new ArrayList<>();
		setHourList();
		minuteList = new ArrayList<>();
		setMinuteList();
		return SUCCESS;
	}
	
	public List<Integer> getDayList() {
		return dayList;
	}
	
	public void setDayList() {
		for (int i = 1; i < 32; i++) {
			dayList.add(i);
		}
	}
	
	public List<Integer> getMonthList() {
		return monthList;
	}
	
	public void setMonthList() {
		for (int i = 1; i < 13; i++) {
			monthList.add(i);
		}
	}
	
	public List<Integer> getHourList() {
		return hourList;
	}
	
	public void setHourList() {
		for (int i = 0; i < 24; i++) {
			hourList.add(i);
		}
	}
	
	public List<Integer> getMinuteList() {
		return minuteList;
	}
	
	public void setMinuteList() {
		for (int i = 0; i < 60; i++) {
			minuteList.add(i);
		}
	}
	
	public List<Integer> getMeetingYearList() {
		return meetingYearList;
	}
	
	public void setMeetingYearList() {
		Calendar current = Calendar.getInstance();
		current.setTime(new Date());
		for (int i = current.get(Calendar.YEAR); i < current.get(Calendar.YEAR) + 3; i++) {
			meetingYearList.add(i);
		}
	}
	
	public List<Integer> getUserYearList() {
		return userYearList;
	}
	
	public void setUserYearList() {
		Calendar current = Calendar.getInstance();
		current.setTime(new Date());
		for (int i = current.get(Calendar.YEAR) - 18; i > current.get(Calendar.YEAR) - 100; i--) {
			userYearList.add(i);
		}
	}
}
