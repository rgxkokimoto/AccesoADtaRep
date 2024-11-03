package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;import java.util.RandomAccess;

public class Ejrc1 {
	
	static final int TAM_ID = 4;
	static final int TAM_NOMBRE = 30;
	static final int TAM_VEHICULO = 20;
	static final int TAM_TIEMPO = 8;
	
	static final int TAM_REGULAR = (TAM_NOMBRE * 2) + (TAM_VEHICULO * 2) + TAM_ID + TAM_TIEMPO;
	
	static ArrayList<Competidor> aListCompetidores;

	public static void main(String[] args) {
		aListCompetidores = new ArrayList<Competidor>();
				
		ArrayList<String> dataComp = leerCompetidores(); //1
		
		guardarEnBinario(dataComp); //2
		
		mostrarCompetidores(); //3

	}

	private static void guardarEnBinario(ArrayList<String> dataFich) {
		
		try(RandomAccessFile raf = new RandomAccessFile("Ficheros/competidores.dat","rw")) {
			int posActId;
			
			// si existen datos quiero encontrar el ultimo para saber donde insertar los nuevos si no empiezo desde el principio
			if (raf.length() != 0) {
				posActId = ultIdArchivo(raf); // descrubre el ultimo id del archivo
			} else {
				posActId = 0;
			}
			raf.seek(raf.length());
			
			ordenarData(dataFich,posActId); // uso los datos sacados del fichero y los guardo segun su posición correcta
			
			// usamos SB porque su metodo setLengh hace que los strings tengan un numero de caracteres por defecto
			// si hubiera un dato mas grande de lo establecido no rompera la extructura solo cortara el dato.
			StringBuilder sbn;// nombre
			StringBuilder sbv;// vehiculo
			
			for (Competidor comp : aListCompetidores) {
				// importante mantener el orden
				raf.writeInt(comp.getId());
				sbn = new StringBuilder(comp.getNombre()); 
				sbn.setLength(TAM_NOMBRE);
				raf.writeChars(sbn.toString());
				sbv = new StringBuilder(comp.getVehiculo());
				sbv.setLength(TAM_VEHICULO);
				raf.writeChars(sbv.toString());
				raf.writeDouble(comp.getTiempo());
			}
			
			aListCompetidores.clear();
			
		} catch (FileNotFoundException e) {
			System.out.println("Al leer el archivo binario el fichero no fue encontrado");
		} catch (IOException e) {
			System.out.println("Hubo un problema al leer el archivo binario o al leer el último id de este");
		}
		
	}

	private static void ordenarData(ArrayList<String> dataComp, int posActId) {
		
		Competidor competidor;
		
		String [] disecLine;
		for (String line : dataComp) {
			disecLine = line.split(";");
			posActId ++;
			competidor = new Competidor(posActId, disecLine[0], disecLine[1], Double.parseDouble(disecLine[2]));
			aListCompetidores.add(competidor);
		} 

	}

	private static int ultIdArchivo(RandomAccessFile raf) throws IOException {
		int posActIds;
		raf.seek(raf.length() - TAM_REGULAR);// Posicionando justo antes del último objeto para saber su id
		posActIds = raf.readInt(); // capturar id de último fichero
		return posActIds;
	}

	private static void mostrarCompetidores() {
//		Mostrar competidores desde el fichero binario: Implementa un método que lea los registros del fichero
//		binario y los muestre en consola para verificar que los datos se han almacenado correctamente.
//		
//		o Implementa una clase de lectura que recorra el archivo binario y 
//		muestre los datos de los competidores, verificando que los registros 
//		están bien formateados y el ID es correcto.
		
		try(RandomAccessFile raf = new RandomAccessFile("Ficheros/competidores.dat", "r")){
			
			raf.seek(0);
			Competidor competidor;
			
			int id;
			char [] nomC = new char[TAM_NOMBRE];
			String nom;
			char [] vecC = new char[TAM_VEHICULO];
			String vec;
			double time;
			
			while (raf.getFilePointer() < raf.length()) {
				id = raf.readInt();
				for (int i = 0; i < nomC.length; i++) {
					nomC[i] = raf.readChar();
				}
				nom = new String(nomC).trim();
				for (int i = 0; i < vecC.length; i++) {
					vecC[i] = raf.readChar();
				}
				vec = new String(vecC).trim();
				time = raf.readDouble();
				
				competidor = new Competidor(id, nom, vec, time);
				aListCompetidores.add(competidor);
				
			}
			
			for (Competidor comp : aListCompetidores) {
				System.out.println(comp);
			}
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("No pudo ser encontrado el archivo binario, en el metodo para imprimirlo" );
		} catch (IOException e) {
			System.out.println("Hubo un problema en la lectura.");
			e.printStackTrace();
		}
		
	}

	private static ArrayList<String> leerCompetidores() {
		
		ArrayList<String> datosCompetidores = new ArrayList<String>();
		
		// esto es un try-with recources si te fijas cierra automaticamente 
		//br por lo que no necesitas el metodo close.
		try(BufferedReader br = new BufferedReader(new FileReader("Ficheros/competidores.txt"))){
			String line;
			// en estos casos en los que tienes que iterar una linea puedes debes usar 
			// una variable y asignarle el metodo de lectura es mas eficiente.
			while ((line = br.readLine()) != null) {
				datosCompetidores.add(line);
			}
						
		} catch (FileNotFoundException e) {
	        System.out.println("El archivo no se encontró: " + e.getMessage());
		} catch (IOException e) {
	        System.out.println("Error al leer el archivo: " + e.getMessage());
		}	
		
		return datosCompetidores;

	}

}
