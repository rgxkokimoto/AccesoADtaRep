import java.io.File;

public class comprobarFichero {

	public static void main(String[] args) {
		// Establecer ruta del directorio 
		File file = new File("Ficheros" , "ejemplo.txt");
		
		if (file.exists()) {
			System.out.println("El fichero oh directorio ya existe");
			
			if (file.isDirectory()) {
				System.out.println("Es un direcotio");
			} else if(file.isFile()) {
				System.out.println("Es un fichero");
			} else {
				System.out.println("El elemento no existe");
			}
			
		} 

	}

}
