package escribirFicheroBinarioObjeto;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javaBean.Alumno;

public class EscribirFichBinObject {

	public static void main(String[] args) {
		// Creamos un array de objetos de tipos alumno
		Alumno[] alumnos = {
				new Alumno("Juan", 20, "2Dam"),
				new Alumno("Miguel", 12, "2Dam"),
				new Alumno("Carlos", 23, "2Dam"),
				new Alumno("Jhon", 45, "2Dam"),
				new Alumno("Josua", 33, "2Dam"),
		};
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Ficheros/alumnos.dat"))) {
			// para cada objeto de tipo alumno en el array alunos se escribe en el archimo recorriendolo
			for (Alumno alumno : alumnos) {
				oos.writeObject(alumno);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
