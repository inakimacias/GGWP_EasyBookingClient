package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.DTOUsuario;
import dto.DTOVuelo;

public class Controller {
	
	public ServiceLocator serviceLocator;
	
	public Controller(String[] args) throws RemoteException {
		serviceLocator = new ServiceLocator();
		serviceLocator.setService(args);
	}
	
	public static void main(String[] args)throws RemoteException {
		System.out.println("Se va a crear un controller");
    	new Controller(args);
	}

	public DTOUsuario login(String email, String password, String tipo) {
		DTOUsuario u = null;
		try {
			u = this.serviceLocator.getService().login(email, password, tipo);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
		}
		return u;
	}
	
	public ArrayList<DTOVuelo> buscarVuelo(String origen, String destino) {
		try {
			return this.serviceLocator.getService().buscarVuelo(origen, destino);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
			return null;
		}
	}
	
	public void reservar(DTOUsuario usuario, DTOVuelo vuelo, String nombres,String tipoBanco,String idCuenta) {
		try {
			this.serviceLocator.getService().reservar(usuario, vuelo, nombres, tipoBanco, idCuenta);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
		}
	}
	
	public String registarse(String usuario, String contrasena, String tipo) {
		String s = "hi";
		try {
			s = this.serviceLocator.getService().registrarse(usuario, contrasena, tipo);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
		}
		return s;
	}
	
}
