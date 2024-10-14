package pruebasDom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*; // esto hace que inporte todos elementos de dom ya que usaremos mas 
import org.xml.sax.SAXException;

public class LeerXMLDom {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// crar una instancia de documentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		// crear el parser 
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		// leer el archivo xml 
		Document doc = builder.parse(new File("Ficheros/empleados.xml"));
		
		// Normalizar archivo xml: quitarle todos los espacios vacios que detecte cosas invalidas 
		doc.getDocumentElement().normalize();
		
		// Obtener la lista de elementos que contiene la etiqueta empleado 
		NodeList listaEmpleados = doc.getElementsByTagName("empleado");
		
		// recorrer la lista de empleado
		for (int i = 0; i < listaEmpleados.getLength(); i++) {
			// Obtner el primer elemento del nodo principal.
			Node empleado = listaEmpleados.item(i);
			
			// Comprobar que el elemento es de tipo element y no de texto y acontiunuacion lo convertimos a titulo element
			// con element nos referimos a sus atributos
			if (empleado.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) empleado;
				
				// Obtengo los valores da cada campo del elemento empleado
				String id = element.getElementsByTagName("id").item(0).getTextContent().trim(); // recuerda usar trim
				
				String nombre = element.getElementsByTagName("nombre").item(0).getTextContent().trim();
				
				String apellido = element.getElementsByTagName("apellido").item(0).getTextContent().trim();
				
				// imprimimos sus datos
				System.out.println("Empleado id: "  + id);
				System.out.println("Empleado nombre: "  + nombre);
				System.out.println("Empleado apellido: "  + apellido);
				System.out.println("----------------------------------");

			}
			
		}
		
	}

}
