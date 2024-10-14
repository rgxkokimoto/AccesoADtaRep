package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import pojo.Empleado;

public class EscribirXMLDomListaEmpleado {
	
	public static void main(String[] args) {
		// Crear la lista de empleados
		List<Empleado> listaEmpleados = crearListaEmpleado();
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			
			// crear el nodo raiz que va a ser empleados
			Document doc = implementation.createDocument(null, "Empleados", null);
			doc.setXmlVersion("1.0");
			
			// usamos el objeto para iterar el array
			for (Empleado emp : listaEmpleados) {
				
				Element elmEmple = doc.createElement("empleado");
				doc.getDocumentElement().appendChild(elmEmple);
				
				Element eleId2 = doc.createElement("id");
				Text intId2 = doc.createTextNode(String.valueOf(emp.getId()));
				elmEmple.appendChild(eleId2);
				eleId2.appendChild(intId2);
				
				Element elmName2 = doc.createElement("nombre");
				Text txtname2 = doc.createTextNode(String.valueOf(emp.getNombre()));
				elmEmple.appendChild(elmName2);
				elmName2.appendChild(txtname2); 
				
				Element elmApellido2 = doc.createElement("apellido");
				Text txtApellido2 = doc.createTextNode(String.valueOf(emp.getApellido()));
				elmEmple.appendChild(elmApellido2);
				elmApellido2.appendChild(txtApellido2);
					
			}
			
			// UNA VEZ GENERADA LA EXTRUCTURA SE CREA LA FUENTE XML A PARTIR DE LA EXTRUCTURA
						DOMSource source = new DOMSource(doc);
						
						// Obtenemos un trasformer factory
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer  trasformer = transformerFactory.newTransformer();
						
						// Le damos formato y realizamos la trasformacion del documento a fichero
						trasformer.setOutputProperty(OutputKeys.INDENT, "yes"); // para que aparezca indemtado
						trasformer.setOutputProperty(OutputKeys.METHOD, "xml"); // para que  me meustre la version
						trasformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // añadir los 4 espacios del tabulador
						
						StreamResult fichero = new StreamResult(new File("Ficheros/empleados.xml"));
						trasformer.transform(source, fichero);

						// puedes verlo en la consola
						System.out.println("Archivo creado correctamente");
						
						StreamResult console = new StreamResult(System.out);
						trasformer.transform(source, console);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	private static List<Empleado> crearListaEmpleado() {
		
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		listaEmpleados.add(new Empleado(1, "Juan", "Coloma"));
		listaEmpleados.add(new Empleado(2, "Jorge", "polete"));
		listaEmpleados.add(new Empleado(3, "Loli", "Pama"));
		listaEmpleados.add(new Empleado(4, "Eno", "Coloma"));
		listaEmpleados.add(new Empleado(5, "Treto", "polete"));
		
		return listaEmpleados;
	}

	

}


