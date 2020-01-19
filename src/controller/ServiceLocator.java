package controller;

import java.rmi.Naming;

import remote.IEasyBookingManager;

public class ServiceLocator {
	
	private IEasyBookingManager service;
	
	public void setService(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {		
			String URL = "//" + args[0] + ":" + args[1] + "/" + args[2];
			this.service = (IEasyBookingManager) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}		
	}

	public IEasyBookingManager getService() {
		return this.service;
	}

}
