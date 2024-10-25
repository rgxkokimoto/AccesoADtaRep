package b_3PruebasXstream;

// Jorge dice que esto puede ser el mejor sistema para hacer migraciones

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class LeerXMLStream {

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
				xs.allowTypesByWildcard(new String[] { "b_3PruebasXstream.*" }); // 
				
				// las etiquetas XML se corresponden con el nombre de los atributos de la clase, aunque se podrian cambiar
				// usando el metodo Alias
				xs.alias("ListaObjetos", ListaObjetos.class);
				xs.alias("Objeto", Objeto.class);
				
				xs.addImplicitCollection(ListaObjetos.class, "listaObjetos");
				
				
		// Establecemos canal al fichero XML y volcamos/deserializamos el contenido en un objeto de tipo ListaObjetos que podemos 
		// despues leer
				
		try {
			
			FileInputStream fis = new FileInputStream("Ficheros/objetos.xml");
			ListaObjetos listObj = (ListaObjetos) xs.fromXML(fis);
			
			// Mostrar el contenido de la lista ya deserializada por consolola
			for (Objeto obj : listObj.getListaObject()) {
				System.out.println("Nombre: " + obj.getNombre() + " Valor: " + obj.getValor());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
