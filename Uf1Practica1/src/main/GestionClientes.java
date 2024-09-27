package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import pojo.Cliente;

public class GestionClientes {
	
	private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>(); 
	private static Scanner scn = new Scanner(System.in); 

	public static void main(String[] args) {
		
		// TODO Añade un bucle while para presentar el menú con las opciones: Añadir cliente, Ver clientes, Guardar en texto, Salir.
		
		// MENU ------
		boolean exit = false; // variable para controlar el menu y matarlo 
		// cargarClientesTexto(); // metodo de jorge
		
		while (!exit) {
			
			System.out.println("\nELIJA LA OPCIÓN QUE DESEE"); 
			System.out.println("1. Añadir Cliente");
			System.out.println("2. Ver Clientes");
			System.out.println("3. Salir");			
			
			int opc = Integer.parseInt(scn.nextLine()); //Jorge son metodos del año pasado si prefieres otra forma comentamelo.
			
			switch (opc) {
			case 1:
				aniadirCliente(); // no uso ñ porque se supone que puede dar a errores de formato 
				break;
				
			case 2:
				verCliente();
				break;
			
			case 3:
				exit = true; // el propio caso desestabiliza el bucle 
				System.out.println("Saliendo del programa");
				break;

			default:
				System.out.println("Opción no valida");
				break;
			}
			
		}
		
		scn.close(); // Para cerrar el Scanner
		//End.-----------
	}

	private static void verCliente() {
		cargarClientesTexto();
		
		System.out.println("\nLista de clientes guardados en la app");
		System.out.println("--------------------------------------");
		
		for (Cliente cliente : listaClientes) {
			System.out.println(cliente);
	    }
		listaClientes.clear();// limpia la lista para que no existan duplicados. 
	}

	private static void aniadirCliente() {
		// pidiendo datos indiviudales al usario y asignandoselo a las variables embajadoras
		System.out.print("Nombre: ");
		String nom = scn.nextLine();
		System.out.print("Apellido: ");
		String apll = scn.nextLine();
		System.out.print("Email: ");
		String email = scn.nextLine();
		System.out.print("Dirección: ");
		String dir = scn.nextLine();
		System.out.print("Fecha Alta: ");
		String fechA= scn.nextLine();
		System.out.print("Provincia: ");
		String prov = scn.nextLine();
		System.out.print("Ciudad: ");
		String ciu = scn.nextLine();
		
		// asociando las embajadoras al pojo 
		Cliente cliente = new Cliente(nom, apll, email, dir, fechA, prov, ciu);
		//listaClientes.add(cliente); // TODO Jorge si lo vamos a guardar mas tarde en el metodo cargarClientesTexto
		// esto no va a crear duplicados?
		System.out.println("Cliente añadido: ");
		
		guardarCliente(cliente); // guarda el cliente en el fichero 
	}

	private static void guardarCliente(Cliente cliente) {
		// guardamos al cliente y su información al crearlo 
		// ponemos append:true para que no sobrecriba datos del anterior cliente 
		try(BufferedWriter writeCli = new BufferedWriter(new FileWriter("cliente.txt",true)) ) {  
			// escribe en el archivo que le indique si no exite lo crea
			// no va a crear nuevos archivos una vez exita depende del segundo parametro si sobre escribe oh añade info.
			writeCli.write(
			cliente.getNombre() 
			+ "," + cliente.getApellido() 
			+ "," + cliente.getEmail() 
			+ "," + cliente.getDireccion() 
			+ "," + cliente.getFechaAlta() 
			+ "," + cliente.getProvincia() 
			+ "," + cliente.getCiudad());
			writeCli.newLine();// importante para que no se junten 2 clientes en una misma línea esto afectaria a la carga posterior
			System.out.println("El cliente ha sido guardado en el archivo de texto");
		} catch (IOException e) {
			System.out.println("Hubo un error al guardar al cliente en el archivo de texto");
		}
	}
	
	private static void cargarClientesTexto() {

    File file = new File("cliente.txt");
    // En caso de que no exitiera esto evitara errores 
    if (!file.exists()) {
        System.out.println("El archivo cliente.txt no existe. No se cargarán clientes.");
        return;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader("cliente.txt"))) {
        String linea;
        while ((linea = reader.readLine()) != null) { // mientras existan lineas sigue leyendo 
            String[] dato = linea.split(","); // cada cliente puede verse como un array divisible de forma secuencial
            Cliente cliente = new Cliente(dato[0], dato[1], dato[2], dato[3], dato[4], dato[5], dato[6]); 
            // al fragmentarel texto plano del txt hacemos que estos datos vuelvan a ser atributos de la clase cliente
            // lo que permite su utilización , modificaión y guardado para posterior uso.
            listaClientes.add(cliente); 
        }
        System.out.println("Clientes cargados desde archivo de texto.");
    } catch (IOException e) {
        System.out.println("Error al cargar clientes.");
        e.printStackTrace();
    }
}

}
