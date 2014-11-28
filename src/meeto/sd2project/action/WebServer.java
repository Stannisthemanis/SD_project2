package meeto.sd2project.action;

/**
 * Raul Barbosa 2014-11-07
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

//import meeto.rmiserver.RmiServerInterface;


@SuppressWarnings("deprecation")
public class WebServer {
	//private static RmiServerInterface server;

	public WebServer(){
	/*	try {
			server = (RmiServerInterface) Naming.lookup("rmi://localhost:1099/DataBase");
		} catch (MalformedURLException e) {
		} catch (RemoteException e) {
		} catch (NotBoundException e) {
		}*/
		System.out.println("Web server running...");

	}
	
	/*public static boolean testLogin(String username, String password){
		System.out.println("testing login: "+username+","+ password);
		try {
			System.out.println("Web server: test if name exists ");
			System.out.println(server.tryLogin(username, password));
			return server.tryLogin(username, password);
		} catch (RemoteException e) {
			System.out.println("error testing login");
		}
		System.out.println("false");
		return false;
	}*/
	
	public static boolean addNewMeeting(String username, String title, String local, String date, String time, String duration){
		//System.out.println("inserting meeting:"+title+","+title+","+local+","+date+","+time+","+duration);
		//return server.addNewMeeting();
		return false;
		//UNDER CONSTRUCTION
	}
	

	
}






