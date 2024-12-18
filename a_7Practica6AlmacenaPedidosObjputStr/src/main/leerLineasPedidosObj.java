package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import pojo.LineaProducto;

public class leerLineasPedidosObj {

	public static void main(String[] args) {
		
		// Leer los objetos LineaPedido desde el fichero "lineasPedidos.dat"
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ficheros/lineasPedidos.dat"))) {
			
			boolean corr = false;
			
			 while (!corr) {
	                try {
	                    LineaProducto lineaPedido = (LineaProducto) ois.readObject(); // Hacer casting explícito y leer cada objeto LineaPedido
	                    System.out.println(lineaPedido); // Mostrar por pantalla
	                } catch (IOException | ClassNotFoundException e) {
	                    corr = true; // Salir del bucle cuando se termine de leer el archivo
	                }
	         }
			 
			 ois.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el fichero clientes.dat");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No se pudieron scacar los datos en el fichero clientes.dat");
			e.printStackTrace();
		}
		
	}

}
