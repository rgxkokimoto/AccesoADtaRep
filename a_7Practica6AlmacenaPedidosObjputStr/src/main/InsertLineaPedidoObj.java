package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import pojo.LineaProducto;
import pojo.Producto;

public class InsertLineaPedidoObj {

	public static void main(String[] args) {
		
		// sin teclado por arrays 
		
		// array de 5 objetos LineaPedido
		
		ArrayList<Producto> listPorducts = new ArrayList<Producto>();
		
		// Crear algunos objetos Producto
		listPorducts.add(new Producto(1, "Queso chedart", 4.45));
		listPorducts.add(new Producto(2, "Queso Manchego", 9.5));
		listPorducts.add(new Producto(3, "Gouda", 7.45));
		listPorducts.add(new Producto(4, "La Vaca que rie", 5.45));
		listPorducts.add(new Producto(5, "Provolone", 2.5));		
		
		//Crea las líneas de pedidos con diferentes datos 
		
		// tambien se podia hacer así
		//LineaProducto [] arraylineasProducts = new LineaProducto[5];
		
		//LineaProducto[0] new LineaProducto(1, listPorducts.get(0), 4, 0, "12/03/2023")
		//LineaProducto[1] new LineaProducto(1, listPorducts.get(0), 4, 0, "12/03/2023");
		//LineaProducto[2] new LineaProducto(1, listPorducts.get(0), 4, 0, "12/03/2023");
		//LineaProducto[3] new LineaProducto(1, listPorducts.get(0), 4, 0, "12/03/2023");
		//LineaProducto[4] new LineaProducto(1, listPorducts.get(0), 4, 0, "12/03/2023");
		
		LineaProducto [] arrayLineasPrducts = {
				new LineaProducto(1, listPorducts.get(0), 4, 0, "12/03/2023"),
				new LineaProducto(1, listPorducts.get(1), 3, 0, "12/03/2023"),
				new LineaProducto(1, listPorducts.get(2), 4, 0, "12/03/2023"),
				new LineaProducto(1, listPorducts.get(3), 5, 0, "12/03/2023"),
				new LineaProducto(1, listPorducts.get(4), 1, 0, "12/03/2023")		
		};
		
		// Escribir los objetos LineaPedidos en el fichero binario "LineasPedidos.dat"
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Ficheros/lineasPedidos.dat"))) {
			
			for (LineaProducto lineaProducto : arrayLineasPrducts) {
				oos.writeObject(lineaProducto);
			}
			
			System.out.println("Datos de las lineas de pedidos introducidos correctamente en el fichero");
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el fichero lineasPedidos.dat");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No se pudieron meter los datos en el fichero clientes.dat");
			e.printStackTrace();
		}
		
	}

}
