import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroSecuencial {

	public static void main(String[] args) {
		// 1º define la ruta del fichero que quieres leer 
		String rutaArchivo = "Ficheros/ejemplo.txt";
		
		// 2º Vamos a leer de forma secuencial de izq --> der y de arriba a abajo
		try {
			// creamos un objeto para leer 
			BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
			
			//3º creo el string que almacenara una linea por cada registro
			String linea;
			//4º itera cada lectura con un bucle
			while ((linea = lector.readLine()) != null) { // cuando dejan de exitir las lineas para
				System.out.println(linea ); // imprime cada línea del archivo
			}
			
		} catch (IOException e) {
			System.out.println("Ocurrio un problema al leer el archivo " + rutaArchivo);
			e.printStackTrace();
		}

	}

}
