package com.dam.practica5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

public class insertarLibrosAlea {
	
	/*Candidato EXAMEN Menu que utiliza metodos de lectura randoms para acceder a un archivo binario
	 * Puede controlar el archivo para meter y sacar info*/
	
	static final int TAM_TITULO = 30;
	static final int TAM_AUTOR = 20;
	static final int TAM_REGnormal = (TAM_TITULO * 2) + (TAM_AUTOR*2) + 4 + 4 + 4;

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		§ ID (int): número entero, único y consecutivo (4 bytes).
//		§ Título (String): máximo de 30 caracteres (60 bytes).
//		§ Autor (String): máximo de 20 caracteres (40 bytes).
//		§ Año de edición (int): número entero (4 bytes).
//		§ Número de páginas (int): número entero (4 bytes).
//		o Tamaño total de cada registro: 112 bytes
		
		// 3
		
		try(RandomAccessFile raf = new RandomAccessFile("Ficheros/libros.dat", "rw")) {
					
			boolean end = false;
			String opc;
			
			while (!end) {
				
				System.out.println("Escoja un opción:"); 
				System.out.println("\n1. Añadir libro");
				System.out.println("2. Ver libros");				
				System.out.println("3. Salir\n");
				System.out.print("User: ");
				opc = sc.nextLine();
				
				switch (opc) {
				case "1":
					addBook(raf);
					break;
				case "2":
					readListBooks(raf);
					break;
				case "3":
					end = true;
					raf.close();
					break;
				default:
					System.out.println("Introduzca un dato correcto :(");
					break;
				}

			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void readListBooks(RandomAccessFile raf) throws IOException , FileNotFoundException {
		
		raf.seek(0);
		
		int id;
		char cTitulo [] = new char [TAM_TITULO]; 
		String titulo;
		char cAutor [] = new char [TAM_AUTOR];
		String autor;
		int ano;
		int numPage;
		
		while (raf.getFilePointer() < raf.length()) {
			
			id = raf.readInt();
			for (int i = 0; i < cTitulo.length; i++) {
				cTitulo[i] = raf.readChar();
			}
			titulo = new String(cTitulo).trim(); // TODO ESTO FUNCIONARA?
			for (int i = 0; i < cAutor.length; i++) {
				cAutor[i] = raf.readChar();
			}
			autor = new String(cAutor).trim();
			ano = raf.readInt();
			numPage = raf.readInt();
			
			System.out.println("id: " + id + ", titulo: " + titulo + ", autor: " + autor + ", año: "
					+  ano + ", Número de página: " + numPage);
			
		}
		
	}

	private static void addBook(RandomAccessFile raf) throws IOException , FileNotFoundException {
		// DEBEMOS TENER CUIDADO AL CONTROLAR LA EXTRUCTURA DEL ARCHIVO 
		// usar metodos como setLength no puede pararecer a la primera la opción mas valida
		// pero es muy eficiente para mantener la extructura de forma correcta 	
		
		int posActIds = comprubStateFich(raf);
	
		raf.writeInt(posActIds);
		
		System.out.print("Introduzca titulo del del libro: max 30 caractéres");
		String titulo = sc.nextLine();
		StringBuffer sbt = new StringBuffer(titulo);
		sbt.setLength(TAM_TITULO);
		raf.writeChars(sbt.toString()); // se supone que funciona mejor que writeUTC
		
		System.out.print("Introduzca el nombre del autor: max 20 caracteres");
		String autor = sc.nextLine();
		StringBuffer sba = new StringBuffer(autor);
		sba.setLength(TAM_AUTOR);
		raf.writeChars(sba.toString());
		
		System.out.print("Introduzca el año de edición");
		raf.writeInt(Integer.parseInt(sc.nextLine()));
		
		System.out.println("Introduce el número de paginas");
		raf.writeInt(Integer.parseInt(sc.nextLine()));
		
	}

	private static int comprubStateFich(RandomAccessFile raf) throws IOException {
		int posActIds;
		
		if (raf.length() != 0) {
			System.out.println("El archivo ya tiene contenido");
			
			// metodo para conseguir último id
			posActIds = ultIdDelArchivo(raf);
			
			// como no esta vacio posicionate al final del archivo 
			raf.seek(raf.length());
			
		} else {
			System.out.println("Archivo vacio");
			posActIds = 1;
			
		}
		return posActIds;
	}

	private static int ultIdDelArchivo(RandomAccessFile raf) throws IOException {
		int posActIds;
		raf.seek(raf.length() - TAM_REGnormal);// Posicionando detras de ultima edición para descubrir ultimo id
		int ult_id = raf.readInt(); // capturar id de último fichero
		posActIds = ult_id + 1;
		
		return posActIds;
	}

}
