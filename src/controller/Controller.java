package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.DTOInformePago;
import dto.DTOReserva;
import dto.DTOUsuario;
import dto.DTOVuelo;
import gui.InitialWindow;

public class Controller {
	
	public ServiceLocator serviceLocator;
	private DTOUsuario usuario=null;
	
	public Controller(String[] args) throws RemoteException {
		serviceLocator = new ServiceLocator();
		serviceLocator.setService(args);
		InitialWindow ini = new InitialWindow(this);
		ini.setVisible(true);
	}
	
	public static void main(String[] args)throws RemoteException {
    	new Controller(args);
	}

	public DTOUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(DTOUsuario usuario) {
		this.usuario = usuario;
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
	
	public void reservar(DTOUsuario usuario, DTOVuelo vuelo, String nombres,String tipoAuth,String idCuenta) {
		try {
			this.serviceLocator.getService().reservar(usuario, vuelo, nombres, tipoAuth, idCuenta);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
		}
	}
	
	public String registrarse(String usuario, String contrasena, String tipo) {
		String s = "hi";
		try {
			System.out.println("Entro en el try");
			s = this.serviceLocator.getService().registrarse(usuario, contrasena, tipo);
			System.out.println("Salgo del try con: "+s);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
		}
		return s;
	}
	
	public ArrayList<DTOReserva> buscarReservas(DTOUsuario usuario){
		ArrayList<DTOReserva> adtor = null;
		try {
			adtor = this.serviceLocator.getService().buscarReservas(usuario);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
		}
		return adtor;
	}
	
	public DTOInformePago buscarInforme(DTOReserva reserva) {
		DTOInformePago i = null;
		try {
			i = this.serviceLocator.getService().buscarInforme(reserva);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
		}
		return i;
	}
}
