package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscrituraEmpleadosFicheroBinario {	
		
	static final int TAM_NOMBRe = 10; //tamaño maximo del nombre
	static final int TAM_REG = TAM_NOMBRe * 2 + 4 + 8; //Tamaño del registro
	
	public static void main(String[] args) {
		
		//Incluir manulamente información de empleados
		String[] nombres = {"Jorge","David", "Pablo", "Ines", "Paula"};
		int[] departamentos = {10,10,20,20,30};
		double [] salarios = {28000.6,33000.0,42000.4,27000.2,37000.5};
		
		try(RandomAccessFile raf = new RandomAccessFile("Ficheros/empleados.dat", "rw")) {
			
			// Me posiciono al final del archivo
			raf.seek(raf.length());
			
			// Escribir los datos de los empleados
			StringBuffer sb;
			for (int i = 0; i < departamentos.length; i++) {
				
				// Escribir los nombres
				sb = new StringBuffer(nombres[i]); // guardo cada nombre e el string buffer 
				sb.setLength(TAM_NOMBRe); //Ajusto el tamaño a los caracteres pedidos
				// si tiene mas de 10 lo recorta y si tiene menos añade espacios
				raf.writeChars(sb.toString());//Finalmente escribo el nombre en el archivo				
				// Escritura del departamento
				raf.writeInt(departamentos[i]);
				//escritora salario
				raf.writeDouble(salarios[i]);
				
			}
			System.out.println("Datos de empleados escritos correctamente");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
