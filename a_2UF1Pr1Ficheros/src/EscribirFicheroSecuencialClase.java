import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFicheroSecuencialClase {

	public static void main(String[] args) {
		String rutaArchivo = "Ficheros/ejemplo.txt";
		
		//EScribimos la frase "Hello World" en el fichero de forma secuecial
		try {
			//parametros del metodo: ruta , true si quieres añadir oh rescribir 
			BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo,true)); 
			escritor.write("Hello World");
			escritor.newLine();// podrias usar n/ tambien
			System.out.println("Escritura completada");
			
			escritor.close();// no te olvides de cerrar el escritor cuando acabes
			
		} catch (IOException e) {
			System.out.println("Ocurrio un error al escribir el archivo");
			e.printStackTrace();
		}
		
		

	}

}
