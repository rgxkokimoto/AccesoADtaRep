import java.io.File;
import java.io.IOException;

public class crearFichero {

	public static void main(String[] args) {
		// ruta donde creamos el archivo 
		String nombreDirectorio = "Ficheros";
		
		// crear un objeto file para poder crear el fichero "ejemplo.txt dnetro del directorio Ficheros"
		File archivo = new File(nombreDirectorio, "ejemplo3.txt");
		
		//Finalmente creamos el fichero
		if (archivo.exists()) {
			System.out.println("el archivo ya existe ");
			
		} else {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				System.out.println("No se pudo crear el fichero debido posiblemente a falta de permisos oh errores de sistema ");
				e.printStackTrace();
			}
			System.out.println("Archivo creado con exito");
		} 

	}

}
