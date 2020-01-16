package controller;

import java.rmi.RemoteException;
import java.util.List;

import dto.DTOVuelo;
import remote.ServiceLocator;

public class Controller {
	public ServiceLocator serviceLocator;
	
	public Controller(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	
	public boolean login(String email, String password, String tipo) {
		try {
			return this.serviceLocator.getService().login(email, password, tipo);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
			return false;
		}
	}
	
	public List<DTOVuelo> buscarVuelo(String origen, String destino) {
		try {
			return this.serviceLocator.getService().buscarVuelo(origen, destino);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
			return null;
		}
	}
	
}
