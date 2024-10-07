package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LecturaEmpleadosFichBinAleatorio {
	
	static final int TAM_NOMBRe = 10; //tamaño maximo del nombre
	static final int TAM_REG = TAM_NOMBRe * 2 + 4 + 8; //Tamaño del registro
	
	public static void main(String[] args) {
		
		try(RandomAccessFile raf = new RandomAccessFile("Ficheros/empleados.dat", "r")) {
			
			//Posicionar el puntero donde interese este casoa al principio
			raf.seek(0);
			
			// variables 
			String nombre;
			char [] cNombre = new char[TAM_NOMBRe];
			int depto;
			double salario;
			
			// Leer el archivo y mostrar el contenido de cada elemento 
			while (raf.getFilePointer() < raf.length()) { // siempre que exiatn datos se sigue leyendo
				
				//Lecturar del nombre
				for (int i = 0; i < cNombre.length; i++) {
					cNombre[i] = raf.readChar(); // Leer cada caracter del nombre hatsa 10 carcateres
					
				}
				nombre = new String(cNombre).trim(); // recuerda el porque de esto 	sb.setLength(TAM_NOMBRe)
				
				depto = raf.readInt();
				
				salario = raf.readDouble();
				
				System.out.println( "Nombre: " + nombre + " - Departamentos: " + depto + " - salario. " +  salario);
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
