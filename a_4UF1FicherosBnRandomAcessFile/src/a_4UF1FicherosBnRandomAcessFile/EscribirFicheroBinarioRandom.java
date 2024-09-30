package a_4UF1FicherosBnRandomAcessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFicheroBinarioRandom {

	public static void main(String[] args) {
		
		String rutaArchivo = "Fichero/ejemplo.bin";
		//
		
		try(RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "rw")) { // permisos del archivo
			
			//Borrar el archivo para limpiarlo le indicas que no hay contenido es un truco
			archivo.setLength(0); 
			
			//Posicionarme al final de un archivo 
			archivo.seek(archivo.length());
			
			// Escribir una cadena como UFT-8
			String texto = "Hello world de forma aleatoria"; // cada caracter 2 bytes // 60bytes + 4
			archivo.writeUTF(texto);
			//entero
			archivo.writeInt(131412); // 4 bits 
			
			//boolean
			archivo.writeBoolean(true); // 1 byte 
			
			// Double
			archivo.writeDouble(2.4);
			
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo para la inserción: ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Hubo un problema con el archivo expecificado :");
			e.printStackTrace();
		}
	}

}
