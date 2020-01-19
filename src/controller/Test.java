package controller;

import java.rmi.RemoteException;

public class Test {

	public static void main(String[] args) throws RemoteException{
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		
		Controller c = new Controller(args);
		String b = c.registarse("ruben@gmail.com", "elRuben", "google");
		System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		System.out.println(b);
		
	}

}