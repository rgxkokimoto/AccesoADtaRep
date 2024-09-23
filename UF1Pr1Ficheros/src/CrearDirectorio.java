import java.io.File;

public class CrearDirectorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombreDirectorio = "Ficheros";
		
		//Creamos un objeto File para el directorio 
		File directorio = new File(nombreDirectorio);
		
		// creamos el directorio con el nombre definido.  
		// Recomendacion: comprobar si existe el directorio 
		if (directorio.exists()) {
			System.out.println("El directorio ya existe no se ha creado ningun directorio");
		} else {
			directorio.mkdir(); // sino lo crea 
			System.out.println("Directorio creado"); // crea un fichero en el work space fichero 
		}

	}

}
