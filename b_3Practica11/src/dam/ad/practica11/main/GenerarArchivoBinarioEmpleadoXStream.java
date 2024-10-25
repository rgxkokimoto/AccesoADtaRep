package dam.ad.practica11.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import dam.ad.practica11.pojos.Empleado;
import dam.ad.practica11.pojos.ListaEmpleados;

public class GenerarArchivoBinarioEmpleadoXStream {

	public static void main(String[] args) {
		
		// p1 crear lista empleados
		
		ListaEmpleados listEmple = creaArrayEmples();
		
		// p2 crear archivo binario empleadosOBJ.dat
		
		crearArchivoBinario(listEmple);
		
		//p3 generar archivo empleadosXStream.xml usando Xstream
		
		DesdeBinarioToXml();
		
		//p4 ller el archivo xml con XStream

	}
	
	// TODO como añadir una libreria: click izq en proyecto > Built Path > Configure Builpath Path... > Claspath > addExternal Jars...

	private static void DesdeBinarioToXml() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ficheros/empleadosObj.dat"))) {
			
			ListaEmpleados listaEmpleados = (ListaEmpleados) ois.readObject();
			
			// Creamos la instancea de xstream
			
			XStream xs = new XStream();
			
			// 2 Configurar los permisos básicos  de seguridad
			xs.addPermission(NoTypePermission.NONE);
			xs.addPermission(NullPermission.NULL);
			xs.addPermission(PrimitiveTypePermission.PRIMITIVES);
			
			Class[] clas = {ListaEmpleados.class, Empleado.class};
			xs.allowTypes(clas);
			
			// permitir cualquier tipo procedente del mismo paquite
			xs.allowTypesByWildcard(new String[] { "dam.ad.practica11" }); // 
			
			xs.alias("Empleados", ListaEmpleados.class);
			xs.alias("empleado", Empleado.class); // a cada elemento
			
			xs.addImplicitCollection(ListaEmpleados.class, "listaEmpleados");
			
			FileOutputStream fos = new FileOutputStream("Ficheros/empleadosXStream.xml");
			xs.toXML(listaEmpleados,fos);
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Archivo empleadosOBJ.dat no encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error general inesperado");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada");
			e.printStackTrace();
		}
		
	}

	private static void  crearArchivoBinario(ListaEmpleados le) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Ficheros/empleadosOBJ.dat"))) {
			
			oos.writeObject(le);
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ocurrio un error inesperado");
			e.printStackTrace();
		}
		
	}

	private static ListaEmpleados creaArrayEmples() {
		
		String[] nombres = {"Alberto", "Guillermo", "Alejandro", "Ana", "Patricia"};
		int[] departamentos = {10, 20, 30, 20, 10};
		double[] salarios = {2000.00, 1500.50, 3000.40, 2300.60, 1900.10};
		
		ListaEmpleados listEmple = new ListaEmpleados();
		
		for (int i = 0; i < nombres.length; i++) {
			listEmple.addEmple(new Empleado(i+ 1, nombres[i], departamentos[i], salarios[i]));
		}
		
		return listEmple;
	}

}
