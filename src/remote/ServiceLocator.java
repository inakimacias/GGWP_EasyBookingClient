package remote;

import java.rmi.Naming;

public class ServiceLocator {
	
	private IEasyBookingManager service;
	
	public void setService(String ip, String port, String serverName) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {		
			String URL = "//" + ip + ":" + port + "/" + serverName;
			this.service = (IEasyBookingManager) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote fa�ade: " + ex);
		}		
	}

	public IEasyBookingManager getService() {
		return this.service;
	}

}
