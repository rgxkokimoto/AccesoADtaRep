package escribirFicheroBinarioSecuencialBuffer;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirFichBinario {

	public static void main(String[] args) {
		//Ruta del directorio donde queremos crear el archivo
		String nombreDirectorio = "Ficheros";
		
		// creamos un objeto file 
		File archivo = new File(nombreDirectorio, "ejemplo.dat");
		
		//Verifiquemos si el archivo existe
		if (archivo.exists()) {
			System.out.println("El archivo ya existe, no se creo ningun fichero nuevo");
		} else {
			try {
				// los directorios acuerdate de crearlos si indicas que tiene que estar en un directorio y no lo tienes 
				// creado no se te va a autogenerar te va a dar error. 
				File carpeta = new File(nombreDirectorio); 
				carpeta.mkdir();
				archivo.createNewFile();
				
				System.out.println("Se ha creado un nuevo Archivcon exito");
			} catch (IOException e) {
				System.out.println("No se ha podido crear el fichero :(");
			}
		}
		
		//Escribir datos en el archivo binario de forma secuencial 
		try{
			FileOutputStream fos = new FileOutputStream(archivo);
			DataOutputStream dos = new DataOutputStream(fos);
			
			//Escribir datos en el archivo binario
			dos.writeInt(100);// escribe un int
			dos.writeDouble(3.5566);
			dos.writeUTF("Hola soy texto");
			
			System.out.println("datos introducidos");
			
			System.out.println("LOs datos han sido compilados "); // si intentas leer el archivo va a aparecer indescifrado
			
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo binario");
			e.printStackTrace();
		}
	}

}
