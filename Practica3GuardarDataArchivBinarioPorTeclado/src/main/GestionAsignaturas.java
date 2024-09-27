package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import pojo.Asignaturas;

public class GestionAsignaturas {
	
	public static final String FICHASIGNATURAS_DAT = "asignaturas.dat";
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Asignaturas> listaAsignaturas = new ArrayList<Asignaturas>();
	
	
	public static void main(String[] args) {
		
		// menu 
		boolean exit = false;
		String user;
		
		while (!exit) {
			
			System.out.println("Menu de gestión de Asignaturas: ");
			
			System.out.println("\nSelecione uno de los numeros para:");
			System.out.println("1. añadir asignatura");
			System.out.println("2. ver Asignaturas");
			System.out.println("3. Salir\n");
			System.out.print(": ");
			user = sc.nextLine();
			
			switch (user) {
			
			case "1":
				aniadirAsignatura();
				
				break;
			case "2":
				verAsignaturas();
				break;
				
			case "3":
				System.out.println("Saliendo del programa...");
				exit = true;
				sc.close();
				break;

			default:
				System.out.println("Ingrese uno de los datos en el menu");
				break;
			}
			
			
		}
		

	}

	private static void verAsignaturas() {
		
		// Ahora necesitamos sacar los datos de las asignaturas que se hayan ingresado
		//en el fichero y imprimirlas 
		
		//primero vamos a crear el metodo para sacarlas del archivo 
		// necesitaremos un Arraylist del objeto en cuestión
		cargarObjDesdeFich();
		System.out.println("\n Cargando Asignaturas desde el fichero Serializado");
		
		imprimirAsignaturas();
			
	}

	private static void imprimirAsignaturas() {
		
		System.out.println("Lista de Asignaturas: ");
		
		for (Asignaturas asignatura : listaAsignaturas) {
			System.out.println(asignatura);
		}
		
		listaAsignaturas.clear(); // necesario para que no queden duplicados 
		
	}

	private static void cargarObjDesdeFich() {
		
		// usamos el metodo
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHASIGNATURAS_DAT))) {
			
			// necesitaras un bucle para leer cada linea del archivo 
			boolean end = false; // un booleano para finalizarlo
			Asignaturas asignatura; // necesitamos una instancia del objeto para atraparlo
			
			while (!end) {
				try {
					
					// asignamos la variable del objeto a la clase con el metodo para recogerla
					// individualmente
					asignatura = (Asignaturas)ois.readObject();
					listaAsignaturas.add(asignatura); // y la guardamos en la lista
 
				} catch (Exception e) { // usa la Excepcion general si no no te deja
					// si la Excepcion se ejecuta es que ya no hay mas codigo en el fichero
					end = true; // aqui entra el booleano pilar nos dijo que es una buena practica romper el bucle asi. 
				}
			}
					
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo para la Extracción de datos: " + FICHASIGNATURAS_DAT);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Hubo un problema con el archivo expecificado :" + FICHASIGNATURAS_DAT );
			e.printStackTrace();
		}
		
	}

	private static void aniadirAsignatura() {
		
		// pedimos los datos al usuario
		System.out.print("Introduzca el código de la asignatura: ");
		String code = sc.nextLine();
		System.out.print("Introduzca el nombre de la Asignatura: ");
		String nombre = sc.nextLine();
		System.out.print("Introduzca el nombre del profesor: ");
		String profesor = sc.nextLine();
		System.out.print("Introduzca el número de horas: ");
		int numHoras = Integer.parseInt(sc.nextLine());
		
		// Ahora vamos a guardar los datos en un objeto
		Asignaturas asignatura = new Asignaturas(code, nombre, profesor, numHoras);
		
		//Ahora cremos un metodo para guardar las asignatura creada en un fichero binario
		cargarObjEnFichBin(asignatura);
		
		System.out.println("\nAsignatura Guardada");
		
		
	}

	private static void cargarObjEnFichBin(Asignaturas asignatura) {
		
		// se crea una extructura de try catch para solventar los posibles problemas con los archivos
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHASIGNATURAS_DAT))) {
			
			// La clase FileOutputStream cuenta con este metodo para cargar el objeto como una linea en el Archivo
			oos.writeUnshared(asignatura);
			
			oos.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo para la inserción: " + FICHASIGNATURAS_DAT);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Hubo un problema con el archivo expecificado :" + FICHASIGNATURAS_DAT );
			e.printStackTrace();
		}
		
		
		
	}

	

}
