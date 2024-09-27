package leerFicheroBinarioSecuencialBuffer;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class LeerFichBin {

	public static void main(String[] args) {
		// ruta de archivo 
		File archivo = new File("Ficheros","ejemplo.dat");
		
		// Verificar si existe NECESARIO
		if (!archivo.exists()) {
			System.out.println("No exite el archivo");
			return;
			
		}
		
		//Leer datos del archivo binario
		
		try {
			FileInputStream fis = new FileInputStream(archivo);
			DataInputStream dis = new DataInputStream(fis);
			
			// leer en el mismo orden en el que fueron escritos sino EXCEPCION 
			int entero = dis.readInt();
			double decimal = dis.readDouble();
			String cadena = dis.readUTF();
			
			//Imprimir por consola 
			System.out.println("Entero: " + entero);
			System.out.println("decimal: " + decimal);
			System.out.println("Cadena: " + cadena);
			
		} catch (Exception e) {
			System.out.println("Error en leer el archivo binario");
		}

	}

}
