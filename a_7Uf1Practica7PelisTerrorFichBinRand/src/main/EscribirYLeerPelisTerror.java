package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import pojo.Pelicula;

public class EscribirYLeerPelisTerror {
	
//	0º calculo de tamaño total del registro epecifico 
//	Id : 4 
//	titulo : 35 * 2 
//	Año : 4
//	Duración : 4
//	director : 35 * 2 
//	sinopsis : 1000 * 2
	
	// caracteres
	static final int TAM_TITULO = 35; 
	static final int TAM_DIRECTOR = 35;
	static final int TAM_SINOPSIS = 1000;
	
	// al hacer la cuenta asi nos aseguramos a futuro de que si se cambia un dato se pueda modifiacar mas facil
	static final int TAM_REGnormal = TAM_DIRECTOR * 2 + TAM_TITULO * 2 + TAM_SINOPSIS * 2 + 4 + 4 + 4; //bytes
	private static ArrayList<Pelicula> listFilms = new ArrayList<Pelicula>(); // aqui guardaremos las peliculas con su id 

	public static void main(String[] args) {

		
		try(RandomAccessFile raf = new RandomAccessFile("Ficheros/PelisTerror.dat", "rw"))	{
			
			// primero hay que comprobar que el fichero que vamos a rellenar no esta ya con contenido
			int posActIds;
			
			if (raf.length() != 0) {
				posActIds = ultIdDelArchivo(raf); // Si no esta vacio una serie de metodos buscaran donde esta el final y se sacaran los ids 
												  // empezando despues del último id que estuviera en el archivo
				sacarPeliculasFichSec(posActIds); // este metodo saca los datos del fichero secuencial y los encapsula en objetos Pelicula
												  // Añadiendo el id que le corresponda segun el estado del archivo.
			} else {
				// el archivo esta vacio.
				posActIds = 0;
				sacarPeliculasFichSec(posActIds); // asi sacaremos los ids orientandolo a el archivo binario
			}
			
			// Ahora vamos a escribir los datos en el archivo 
			
			escribirDatInBinFich(raf);
			
			// 4 Lectura 
			
			readDatOfBinFich(raf);
			
			raf.close(); // ponme al final
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	

	}

	public static void readDatOfBinFich(RandomAccessFile raf) throws IOException {
		raf.seek(0);
		
		int id;
		char [] cTitulo = new char[TAM_TITULO];
		String titulo;
		int ano;
		int duracion; 
		char [] cDirector = new char[TAM_DIRECTOR];
		String director;
		char [] cSinopsis = new char[TAM_SINOPSIS];
		String sinopsis;
		
		
		
		while (raf.getFilePointer() < raf.length()) {
			
			id = raf.readInt();
			
			for (int i = 0; i < cTitulo.length; i++) {
				cTitulo[i] = raf.readChar();
			}
			titulo = new String(cTitulo).trim();
			
			ano = raf.readInt();
			duracion = raf.readInt();
			
			for (int i = 0; i < cDirector.length; i++) {
				cDirector[i] = raf.readChar();
			}
			
			director = new String(cDirector).trim();
			for (int i = 0; i < cSinopsis.length; i++) {
				cSinopsis[i] = raf.readChar();
			}
			
			sinopsis = new String(cSinopsis).trim();
			
			System.out.println("id: " +  id + "titulo: " + titulo + ", año: " + ano + ", duración: " + duracion + ", director: " + director
			+ "\n, sinopsis: " + sinopsis);
			
		}
	}

	public static void escribirDatInBinFich(RandomAccessFile raf) throws IOException {
		raf.seek(raf.length());
		
		StringBuffer sbt;
		StringBuffer sbd;
		StringBuffer sbs;
		
		for (Pelicula peli : listFilms) {
			// id
			raf.writeInt(peli.getId());
			// titulo
			sbt = new StringBuffer(peli.getTitulo());
			sbt.setLength(TAM_TITULO);
			raf.writeChars(sbt.toString());
			// año
			raf.writeInt(peli.getAno());
			//duracción
			raf.writeInt(peli.getDuracion());
			//director
			sbd = new StringBuffer(peli.getDirector());
			sbd.setLength(TAM_DIRECTOR);
			raf.writeChars(sbd.toString());
			//sinopsis
			sbs = new StringBuffer(peli.getSinopsis());
			sbs.setLength(TAM_SINOPSIS);
			raf.writeChars(sbs.toString());
		}
	}
	
	// funciones 

	private static int ultIdDelArchivo(RandomAccessFile raf) throws IOException {
		int posActIds;
		raf.seek(raf.length() - TAM_REGnormal);// Posicionando detras de ultima edición para descubrir ultimo id
		int ult_id = raf.readInt(); // capturar id de último fichero
		posActIds = ult_id ;
		
		return posActIds;
	}

	public static void sacarPeliculasFichSec(int posActIds) {
		
		try(BufferedReader read = new BufferedReader(new FileReader("Ficheros/pelis_terror.txt"))) {
			//iniciar variables necesarias
			String line;// para leer cada línea del pelis_terror.txt
			String [] peliDisec; // para fragmentar las lineas en atributos
			int id = posActIds; // para llevar un conteo del id
			Pelicula peli; // para crear el objeto y guardarlo en un arrayList
			
			while ((line = read.readLine()) != null) { // sigo sin enender exta extructura dentro de la condición hay una acción
				peliDisec = line.split("-");
				
				// TODO convertir datos Aqui se podria controlar el tipo de datos que vienen del fichero y porner medidas en caso de que no fueran correctos
				int ano = Integer.parseInt(peliDisec[1]);
				int duraccion = Integer.parseInt(peliDisec[2]);
				id ++;
				peli = new Pelicula(id ,peliDisec[0] ,ano ,duraccion , peliDisec[3], peliDisec[4]);
				listFilms.add(peli);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
