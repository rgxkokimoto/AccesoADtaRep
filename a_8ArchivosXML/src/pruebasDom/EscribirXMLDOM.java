package pruebasDom;

import java.io.File;

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

public class EscribirXMLDOM {

	public static void main(String[] args) {
				
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// nos facilita el metodo  para crear un documento xml
			DOMImplementation implem = builder.getDOMImplementation();
			
			Document doc = implem.createDocument(null, "empleados", null);
			
			doc.setXmlVersion("1.0");
			
			// crear primer elemento empleado y añadirlo al nodo raiz 
			Element elementoEmpleado1 = doc.createElement("empleado");
			doc.getDocumentElement().appendChild(elementoEmpleado1);
			
			// crear elementos finales en el documento xml y añadirlos al elemento 
			// empleado1 se crean sueltos pero se deben enganchar 
			
			// creo el elemento id (Element o Text) y luego se  asignaasigna a un nodo existente (elemento Empleado)
			Element elementoId1 = doc.createElement("id");
			Text textoId1 = doc.createTextNode("1"); // se le asigna ya con un texto
			// enganche 
			elementoEmpleado1.appendChild(elementoId1);
			elementoId1.appendChild(textoId1);
				
			Element elmName1 = doc.createElement("nombre"); // creas el elemento
			Text textoName1 = doc.createTextNode("Axel"); // representa el contenido textual 
			elementoEmpleado1.appendChild(elmName1); // añadimos el nombre al elemento mas grande 
			elmName1.appendChild(textoName1); // añadimos el texto al elemento nombre
			
			Element elmApellido1 = doc.createElement("apellido");
			Text txtApellido1 = doc.createTextNode("Leon");
			elementoEmpleado1.appendChild(elmApellido1);
			elmApellido1.appendChild(txtApellido1);
			
			Element elmEmail1 = doc.createElement("email");
			Text txtEmail1 = doc.createTextNode("Axel@gmail.com");
			elementoEmpleado1.appendChild(elmEmail1);
			elmEmail1.appendChild(txtEmail1);
			
			// AHORA OTRO EMPLEADO 
			
			Element elmEmple2 = doc.createElement("empleado");
			doc.getDocumentElement().appendChild(elmEmple2);
			
			Element eleId2 = doc.createElement("id");
			Text intId2 = doc.createTextNode("2");
			elmEmple2.appendChild(eleId2);
			eleId2.appendChild(intId2);
			
			Element elmName2 = doc.createElement("nombre");
			Text txtname2 = doc.createTextNode("Paco");
			elmEmple2.appendChild(elmName2);
			elmName2.appendChild(txtname2); 
			
			Element elmApellido2 = doc.createElement("apellido");
			Text txtApellido2 = doc.createTextNode("Cuco");
			elmEmple2.appendChild(elmApellido2);
			elmApellido2.appendChild(txtApellido2);
			
			Element elmEmail2 = doc.createElement("email");
			Text txtEmail2 = doc.createTextNode("Cuco@gmail.com");
			elmEmple2.appendChild(elmEmail2);
			elmEmail2.appendChild(txtEmail2);
			
			// UNA VEZ GENERADA LA EXTRUCTURA SE CREA LA FUENTE XML A PARTIR DE LA EXTRUCTURA
			DOMSource source = new DOMSource(doc);
			
			// Obtenemos un trasformer factory
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer  trasformer = transformerFactory.newTransformer();
			
			// Le damos formato y realizamos la trasformacion del documento a fichero
			trasformer.setOutputProperty(OutputKeys.INDENT, "yes"); // para que aparezca indemtado
			trasformer.setOutputProperty(OutputKeys.METHOD, "xml"); // para que  me meustre la version
			trasformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // añadir los 4 espacios del tabulador
			
			StreamResult fichero = new StreamResult(new File("Ficheros/empleados2.xml"));
			trasformer.transform(source, fichero);

			// puedes verlo en la consola
			System.out.println("Archivo creado correctamente");
			
			StreamResult console = new StreamResult(System.out);
			trasformer.transform(source, console);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
