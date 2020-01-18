package controller;

import java.rmi.RemoteException;
import java.util.List;

import dto.DTOUsuario;
import dto.DTOVuelo;
import remote.ServiceLocator;

public class Controller {
	public ServiceLocator serviceLocator;
	
	public Controller(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	
	public DTOUsuario login(String email, String password, String tipo) {
		try {
			return this.serviceLocator.getService().login(email, password, tipo);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
			return null;
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
	
	public void reservar(DTOUsuario usuario, DTOVuelo vuelo, String nombres,String tipo,String metodo) {
		try {
			this.serviceLocator.getService().reservar(usuario, vuelo, nombres, tipo, metodo);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
		}
	}
	
	public boolean registarse(String usuario, String contraseña, String tipo) {
		try {
			return this.serviceLocator.getService().registrarse(usuario, contraseña, tipo);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
			return false;
		}
	}
	
}
