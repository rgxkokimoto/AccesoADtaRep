import java.io.File;
import java.util.Iterator;

public class ComprobarDirectorio {

	public static void main(String[] args) {
		//Instanciamos objeto de la clase file y pasamos el nombre del directorio a comprobar nombre de tu directorio 
		File file = new File("Ficheros");
		
		// Verificamos si el fichero o el directorio existe 
		if (file.exists()) {
			System.out.println("El fichero o directorio ya existe");
			
			//Verificar si es un directorio oh fichero
			if (file.isDirectory()) {
				
				System.out.println("Es un directorio");
				System.out.println("Nombre: " + file.getName());
				System.out.println("Ruta Completa: " + file.getAbsolutePath());
				System.out.println("Tamaño directorio: " +  file.length());
				
				// Mostrar lista de archivos  dentro del directorio
				File[] listaArch = file.listFiles();
				System.out.println("\nLista de archivos del directorio");
				System.out.println("-----------------------------------");
				
				for (File nombre : listaArch) {
					System.out.println(nombre.getName()); // Imprimir por pantalla cada uno de los nombres de archivo 
				}
				
			} else if (file.isFile()){
				System.out.println("es un fichero");
				
			} else {
				System.out.println("el elemento no existe :(");
			}
			
		}
	}

}
