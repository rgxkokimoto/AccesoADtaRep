package a_4UF1FicherosBnRandomAcessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFicheroBinarioRandom {

	public static void main(String[] args) {
		String rutaarchivo = "Fichero/ejemplo.bin";
		
		try(RandomAccessFile archivo = new RandomAccessFile(rutaarchivo, "r")) { // solo el permiso de leer
			//Mueve el puente al inicio del archivo para comenzar  a leer
			archivo.seek(0); // cuando escribes el puntero se mantiene donde esta acuardate de limpiarlo
			
			//Leer la cadena escrita antes con writeUTF()
			String textoLeido = archivo.readUTF();
			System.out.println("Texto leido: " + textoLeido);
			
			// Leer el valor entero puesto anterormente en la clase EscribirFicheroBinarioRandom
			int numeroEntero = archivo.readInt();
			System.out.println("Entero: " + numeroEntero );
			
			boolean bool = archivo.readBoolean();
			System.out.println("Booleano: " + bool );
			
			double numDecimal = archivo.readDouble();
			System.out.println("Double leido: " + numDecimal);
			
			// como leer el booleano de nuevo debemos calcular el numero de bites basandonos en 
			// el calculo nos dira donde posicionar el 
			archivo.seek(64);
			
			System.out.println("Leemos denuevo el boolean " +  bool);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
