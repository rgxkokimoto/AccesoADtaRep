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
import pojo.Direcion;
import pojo.Empleado;

public class Ej9EmpleadoXml {

	public static void main(String[] args) {
		
		List<Empleado> listEmple = crearListaEmpleado();
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			
			// crear el nodo raiz que va a ser empleados
			Document doc = implementation.createDocument(null, "Empleados", null);
			doc.setXmlVersion("1.0");
			
			// Crear nodos de empleados de forma dinámica
			for (Empleado emple : listEmple) {
				
				Element elmEmple = doc.createElement("empleado");
				doc.getDocumentElement().appendChild(elmEmple);
				
				Element eleId2 = doc.createElement("id");
				Text intId2 = doc.createTextNode(String.valueOf(emple.getId()));
				elmEmple.appendChild(eleId2);
				eleId2.appendChild(intId2);
				
				Element elmName2 = doc.createElement("nombre");
				Text txtname2 = doc.createTextNode(String.valueOf(emple.getNombre()));
				elmEmple.appendChild(elmName2);
				elmName2.appendChild(txtname2); 
				
				Element elmApellido2 = doc.createElement("apellido");
				Text txtApellido2 = doc.createTextNode(String.valueOf(emple.getApellido()));
				elmEmple.appendChild(elmApellido2);
				elmApellido2.appendChild(txtApellido2);
				
			//Agregar la dirección de forma programática
				Element eleDir = doc.createElement("direcion");
				elmEmple.appendChild(eleDir);
				
				Element eleCalle = doc.createElement("calle");
				Text txtCalle = doc.createTextNode(String.valueOf(((Direcion) emple.getDirecion()).getCalle()));
				eleDir.appendChild(eleCalle);
				eleCalle.appendChild(txtCalle);
				
				Element eleCiudad = doc.createElement("ciudad");
				Text txtCiudad = doc.createTextNode(String.valueOf(((Direcion) emple.getDirecion()).getCiudad()));
				eleDir.appendChild(eleCiudad);
				eleCiudad.appendChild(txtCiudad);
				
				Element eleProvincia = doc.createElement("provincia");
				Text txtProvincia = doc.createTextNode(String.valueOf(((Direcion) emple.getDirecion()).getProvincia()));
				eleDir.appendChild(eleProvincia);
				eleProvincia.appendChild(txtProvincia);
				
				Element eleCPostal = doc.createElement("cPostal");
				Text txtCPostal = doc.createTextNode(String.valueOf(((Direcion) emple.getDirecion()).getCodpos()));
				eleDir.appendChild(eleCPostal);
				eleCPostal.appendChild(txtCPostal);
				
			}
			
			//Usar un Transformer para generar el archivo XML
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
			e.printStackTrace();
		}

	}

	private static List<Empleado> crearListaEmpleado() {
			
			List<Empleado> listEmple = new ArrayList<Empleado>();
			
			Direcion dir1 = new Direcion("Calle Alboran 12", "El Berrueco", "Madrid", 28001);
		    Direcion dir2 = new Direcion("Calle Bonachon 23", "Barcelona", "Cataluña", 68001);
		    Direcion dir3 = new Direcion("Calle Cañaveral 35", "Valencia", "Valencia", 46001);
			
			listEmple.add(new Empleado(1, "Manuel", "Azaña", dir1));
			listEmple.add(new Empleado(2, "Miguel", "Cervantes", dir2));
			listEmple.add(new Empleado(3, "Pablo", "Neruda", dir3));
			
			return listEmple;
	}

}
