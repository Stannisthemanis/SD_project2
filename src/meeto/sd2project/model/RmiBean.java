package meeto.sd2project.model;

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
			}
		}
		System.out.println("->> Server: Connection to RmiServer ok...");
	}
	
	public boolean login(String username, String password) {
		while (true) {
			try {
				return rmiServer.tryLogin(username, password);
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public boolean registerNewUser(String newUser) {
		while (true) {
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
	
	public boolean logout(String username) {
		while (true) {
			try {
				rmiServer.removeUserFromAllChats(username);
				return true;
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public String getListOtherUsers(String username) {
		while (true) {
			try {
				return rmiServer.getListOtherUsers(username);
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public boolean insertNewMeeting(String newMeeting) {
		while (true) {
			try {
				rmiServer.addNewMeeting(newMeeting);
				return true;
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public boolean putUserOnline(String username) {
		while (true) {
			try {
				rmiServer.setUserOnline(username);
				return true;
			} catch (RemoteException e) {
				System.out.println("->>> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->>> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public boolean removeUserOnline(String username) {
		while (true) {
			try {
				rmiServer.deleteUserOnline(username);
				
				return true;
			} catch (RemoteException e) {
				System.out.println("->>> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->>> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	// public boolean isUserAlreadyOnline(String username){
	// while(true){
	// try {
	// return rmiServer.isUserOnline(username);
	// } catch (RemoteException e) {
	// System.out.println("->> REMOTE Server: connection to rmiServer" +
	// e.getMessage());
	// System.out.println("->> Server: trying to reconnect...");
	// connectToRmi();
	// }
	// }
	// }
	
	public String getOnlineUsers() {
		String res = null;
		while (true) {
			try {
				res = rmiServer.getOnlineUsers();
				return res;
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public String getMessagesList(String username) {
		while (true) {
			try {
				return rmiServer.getListOfInvitesByUser(username);
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public String getPastMeetingList(String username) {
		while (true) {
			try {
				return rmiServer.getListPassedMeetings(username);
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public String getCurrentMeetingList(String username) {
		while (true) {
			try {
				return rmiServer.getListCurrentMeetings(username);
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public String getUpcumingMeetingList(String username) {
		while (true) {
			try {
				return rmiServer.getListUpcumingMeetings(username);
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public String getMeetingResume(int id_meeting) {
		while (true) {
			try {
				return rmiServer.getMeetingResumeV2(id_meeting);
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public String getMessageInfo(int id_invite) {
		while (true) {
			try {
				return rmiServer.getResumeOfInvite(id_invite);
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public String getTodoList(String username) {
		while (true) {
			try {
				return rmiServer.getListOfActionItensFromUser(username);
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public boolean insertNewActionItem(int meetingSelected, String actionName, String userSelected) {
		while (true) {
			try {
				System.out.println("RmiBean: adding new action item: M-> " + meetingSelected + ", U-> " + userSelected + ", A-> "
						+ actionName);
				return rmiServer.addActionItemToMeeting(1, actionName, userSelected);
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
	
	public boolean replyToInvite(int id_invite, String answer) {
		System.out.println("aqui");
		while (true) {
			try {
				if (answer.equalsIgnoreCase("yes")) {
					return rmiServer.setReplyOfInvite(id_invite, true);
				} else{
					return rmiServer.setReplyOfInvite(id_invite, false);
				}
			} catch (RemoteException e) {
				System.out.println("->> REMOTE Server: connection to rmiServer" + e.getMessage());
				System.out.println("->> Server: trying to reconnect...");
				connectToRmi();
			}
		}
	}
}
