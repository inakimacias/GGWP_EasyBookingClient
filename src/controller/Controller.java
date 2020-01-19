package controller;

import java.rmi.RemoteException;
import java.util.List;

import dto.DTOUsuario;
import dto.DTOVuelo;
import remote.ServiceLocator;

public class Controller {
	
	public ServiceLocator serviceLocator;
	
	public Controller(String[] args) throws RemoteException {
		serviceLocator = new ServiceLocator();
		serviceLocator.setService(args);
		System.out.println("Se ha creado un controller con "+args.toString());
	}
	
	public static void main(String[] args)throws RemoteException {
		System.out.println("Se va a crear un controller");
    	new Controller(args);
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
	
	public String registarse(String usuario, String contrasena, String tipo) {
		System.out.println("Recibido usuario:"+usuario+" pass:"+contrasena);
		String s = "hi";
		try {
			System.out.println("Entro al try");
			s = this.serviceLocator.getService().registrarse(usuario, contrasena, tipo);
			System.out.println(s);
			System.out.println("Salgo del try");
			return s;
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
		}
		return s;
	}
	
}
