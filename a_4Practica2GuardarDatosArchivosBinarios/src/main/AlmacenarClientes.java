package main;

import java.io.FileNotFoundException;
// import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import pojo.Cliente;

public class AlmacenarClientes {

	public static void main(String[] args) {
		
		// primero creamos un array de clientes y los metemos a mano
		Cliente[] clientes = { 
				new Cliente("Ana", "García", "ana.garcia@email.com", "Calle Mayor 5", "2023-05-20", "Madrid", "Madrid"), 
				new Cliente("Luis", "Pérez", "luis.perez@email.com", "Calle Sol 10", "2023-06-15", "Barcelona", "Barcelona"),
				new Cliente("Laura", "Sánchez", "laura.sanchez@email.com", "Calle Luna 7", "2023-07-01", "Valencia", "Valencia"), 
				new Cliente("Carlos", "Romero", "carlos.romero@email.com", "Calle Estrella 22", "2023-08-20", "Sevilla", "Sevilla") };
		
		// guardamos los clientes en un archivo binario llamados 'clientes.dat'
		try {
			ObjectOutputStream oos = new ObjectOutputStream( // no hace falta poner el buffer writer
			
			new FileOutputStream("clientes.dat"));
			
			for (Cliente cliente : clientes) {
				oos.writeObject(cliente); // Guardar cada cliente linea por linea  en el archivo binario
			}
			
			System.out.println("Guardando clientes en el archivo... clientes.dat");
					
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el fichero clientes.dat");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No se pudieron meter los datos en el fichero clientes.dat");
			e.printStackTrace();
		}
				
	}

}
