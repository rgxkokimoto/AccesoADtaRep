package main;

import java.util.ArrayList;
import java.util.Scanner;

import pojo.Cliente;

public class GestionClientes {
	
	private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>(); // 
	private static Scanner scn = new Scanner(System.in); //

	public static void main(String[] args) {
		
		// TODO Añade un bucle while para presentar el menú con las opciones: Añadir cliente, Ver clientes, Guardar en texto, Salir.
		
		boolean exit = false;
		
		while (!exit) {
			System.out.println("\nELIJA LA OPCIÓN QUE DESEE"); 
			System.out.println("1. Añadir Cliente");
			System.err.println("2. Ver Clientes");
			System.out.println("3. Salir");
			
		}
		

	}

}
