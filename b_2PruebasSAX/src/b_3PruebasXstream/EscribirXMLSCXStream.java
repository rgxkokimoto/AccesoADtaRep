package b_3PruebasXstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class EscribirXMLSCXStream {

	public static void main(String[] args) {
		// Crear una instancia de la clase XStream
		XStream xs = new XStream();
		
		// 2 Configurar los permisos básicos  de seguridad
		xs.addPermission(NoTypePermission.NONE);
		xs.addPermission(NullPermission.NULL);
		xs.addPermission(PrimitiveTypePermission.PRIMITIVES);
		
		Class[] clas = {ListaObjetos.class, Objeto.class};
		xs.allowTypes(clas);
		
		// permitir cualquier tipo procedente del mismo paquite
		xs.allowTypesByWildcard(new String[] { "b_3PruebasXstream.*" }); //TODO meter los paquetes en paquete vacio y actaulizar ruta
		
		// las etiquetas XML se corresponden con el nombre de los atributos de la clase, aunque se podrian cambiar
		// usando el metodo Alias
		xs.alias("ListaObjetos", ListaObjetos.class);
		xs.alias("Objeto", Objeto.class);
		
		xs.addImplicitCollection(ListaObjetos.class, "listaObjetos");
		
		// Crear una instancia de lista Objetos y añado algun objeto
		ListaObjetos listaObj = new ListaObjetos();
		listaObj.addObjetos(new Objeto("ob1", 100));
		listaObj.addObjetos(new Objeto("ob2", 200));
		listaObj.addObjetos(new Objeto("ob3", 300));
		listaObj.addObjetos(new Objeto("ob4", 400));
		
		// Serializar en xml
		try {
			FileOutputStream fos = new FileOutputStream("Ficheros/objetos.xml");
			xs.toXML(listaObj, fos);
			
			System.out.println("Archivo creado con xml");
			
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
			e.printStackTrace();
		}

		

	}

}
