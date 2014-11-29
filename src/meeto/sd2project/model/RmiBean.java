package meeto.sd2project.model;


import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmiserver.RMIServerInterface;




public class RmiBean {
	private RMIServerInterface	rmiServer;
	
	public RmiBean() {
		connectToRmi();
	}
	
	public void connectToRmi() {
		// Acesso ao servidor rmi
		String rmiHost[] = { "localhost", "Roxkax", "ricardo" };
		boolean connected = false;
		int i = 0;
		while (connected == false) {
			i = (i + 1) % 3;
			try {
				this.rmiServer = (RMIServerInterface) Naming.lookup("rmi://" + rmiHost[i] + ":1099/server");
				connected = true;
			} catch (MalformedURLException e) {
				System.out.println("->> URL Server: Registing to rmiServer " + e.getMessage());
				connected = false;
			} catch (NotBoundException e) {
				System.out.println("->> BOUND Server: Registing to rmiServer " + e.getMessage());
				connected = false;
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: Registing to rmiServer " + e.getMessage());
				connected = false;
			} catch (IOException e) {
				System.out.println("->> IO Server: Registing to rmiServer " + e.getMessage());
			}
		}
		System.out.println("->> Server: Connection to RmiServer ok...");
	}

	public boolean login(String username, String password){
		while(true){
			try {
				return rmiServer.tryLogin(username, password);
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public boolean registerNewUser(String newUser){
		while(true){
			try {
				if (rmiServer.registerNewUser(newUser) != null) {
					return true;
				}
				return false;
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}

	public boolean logout(String username){
		while(true){
			try {
				if (rmiServer.removeUserFromAllChats(username) != 0) {
					return true;
				}
				return false;
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	
	
	
	
	

}
