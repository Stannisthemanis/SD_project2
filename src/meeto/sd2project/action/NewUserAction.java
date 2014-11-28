package meeto.sd2project.action;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class NewUserAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username = null;
	private String password = null;
	private String dob = null;
	
	@Override
	public String execute() {
		System.out.println("starting web server");
		//WebServer ws = new  WebServer();

	//	if(WebServer.addNewUser(username,password,dob))
		//	return SUCCESS;
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setUsername(String username) {
		this.username = username; // will you sanitize this input? maybe use a prepared statement?
	}

	public void setPassword(String password) {
		this.password = password; 
	}
}