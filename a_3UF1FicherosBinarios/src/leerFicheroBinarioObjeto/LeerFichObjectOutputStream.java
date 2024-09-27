package leerFicheroBinarioObjeto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javaBean.Alumno;

public class LeerFichObjectOutputStream {

	public static void main(String[] args) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ficheros/alumnos.dat"))) {
			Alumno alumno;
			
			boolean exit = true; // mucho mejor mas mantenible 
			
			System.out.println("Datos deserializados del objeto alumno");
			System.out.println("--------------------------------------");
			
			//Bucle para leer objetos del archivo binario
			while (exit) { // si no hay mas datos lanzara una excepcion nosotros la cogeremos y haremos que pare el bucle
				try {
					alumno = (Alumno) ois.readObject();
					// esto nos servira para pasar datos entre aplicaciones la serealizacion funcionara para pasar archivos a Android
					
					System.out.println(alumno); // si el objeto alumno no tiene to stream no se van a leer 
				} catch (Exception e) {
					// breack;
					exit = false;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo encontrar el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Se ha producido un error general");
			e.printStackTrace();
		}
	}

}
