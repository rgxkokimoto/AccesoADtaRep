package b_1Uf1prt10WritoToBinReadXml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadToXml {

	public static void main(String[] args) {
//		Paso 3: Leer el archivo binario
//		A modo de comprobación, leemos el archivo binario empleadosObj.dat y obtenemos la lista de empleados para generar el XML.
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleadosObj.dat"));
			
			boolean have = true;
			
			Empleado empleLine;
			
			while (have) {
				try {
					empleLine = (Empleado) ois.readObject();
					// TODO
				} catch (IOException | ClassNotFoundException e) {
					
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		Pista: usa ObjectInputStream.
//
//		Paso 4: Generar el archivo XML con DOM, desde el archivo binario.
//
//		Después de leer los empleados desde el archivo binario, usamos DOM para generar un archivo XML con la estructura proporcionada.
//
//		Este paso leerá el archivo binario empleadosObj.dat y generará el XML directamente a partir de la lectura, y muy importante debe leerse directamente desde el fichero binario, no desde el array que con el que se ha creado el archivo binario.
//
//		Pista: Lee cada objeto empleado del archivo binario (sigue usando ObjectInputStream), y crea un bucle while para leer cada objeto y escribir el XML con DOM.
//
//		Paso 5: Estructura del archivo XML generado
//
//		El archivo XML generado tendrá la siguiente estructura:
//
  

	}

}
