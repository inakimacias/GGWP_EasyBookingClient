package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.DTOUsuario;
import dto.DTOVuelo;

public class Test {

	public static void main(String[] args) throws RemoteException{
		System.out.println("Puertos:");
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(" ");
		
		Controller c = new Controller(args);
		
		System.out.println("Registrando usuario:");
		String b = c.registarse("ruben@gmail.com", "elRuben", "google");
		System.out.println(b);
		System.out.println(" ");
		
		System.out.println("Loggeando usuario:");
		DTOUsuario user = c.login("ruben@gmail.com", "elRuben", "google");
		System.out.println(user.getEmail());
		System.out.println(" ");
		
		System.out.println("Buscando vuelos Bilbao-Madrid");
		DTOVuelo v = null;
		ArrayList<DTOVuelo> vuelos = c.buscarVuelo("Bilbao", "Madrid");
		System.out.println("Vuelos encontrados:");
		for(int i = 0; i<vuelos.size(); i++) {
			if(vuelos.get(i).getIdVuelo().equals("002") && vuelos.get(i).getAerolinea().equals("iberia")) {
				v = vuelos.get(i);
			}
			System.out.println("Vuelo: "+vuelos.get(i).getIdVuelo()+" de la aerolinea:"+vuelos.get(i).getAerolinea());
		}
		System.out.println(" ");
		
		System.out.println("Reservando vuelo 002 de la aerolinea iberia");
		c.reservar(user, v, "ruben;inaki;dani;alberto", "paypal", "ruben@gmail.com"); //(DTOUsuario usuario, DTOVuelovuelo, String nombres: nombre1;nombre2;..., String metodoPago, String idcuenta)
		System.out.println(" ");
		
		System.out.println("Visualizando Reservas del usuario: "+user.getEmail());
		
		System.out.println(" ");
		
		System.out.println("Visualizando Informes de Pago de: "+user.getEmail());
		System.out.println(" ");
		
		System.out.println("FIN");
	}

}