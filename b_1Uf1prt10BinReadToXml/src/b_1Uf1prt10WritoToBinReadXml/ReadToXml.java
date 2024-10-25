package b_1Uf1prt10WritoToBinReadXml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

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

public class ReadToXml {
	
	static ArrayList<Empleado> listEmple; // la hazemos global para que pueda moverse entre try catch
	
	public static void main(String[] args) {
//		Paso 3: Leer el archivo binario
//		A modo de comprobación, leemos el archivo binario empleadosObj.dat y obtenemos la lista de empleados para generar el XML.
		
		leerArchivoBinario();
		
		//Paso 4: Generar el archivo XML con DOM, desde el archivo binario.
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance(); 
			DocumentBuilder builder = factory.newDocumentBuilder(); 
			DOMImplementation implement = builder.getDOMImplementation();
			
			// Loqs es para crear el nodo raiz del xml.
			Document nodoRaiz = implement.createDocument(null, "Empleados", null);
			nodoRaiz.setXmlVersion("1.0");
			
			// FASE DE CREACIÓN DE NODOS 
			
			// usamos un forech de tipo empleado para 
			
			// Después de leer los empleados desde el archivo binario, usamos DOM para generar un archivo XML con la estructura proporcionada.

			
			for (Empleado emple : listEmple) {
				
				Element nEmple = nodoRaiz.createElement("empleado");
				nodoRaiz.getDocumentElement().appendChild(nEmple);
				
				Element nId = nodoRaiz.createElement("id");
				Text intId2 = nodoRaiz.createTextNode(String.valueOf(emple.getId()));
				nEmple.appendChild(nId);
				nId.appendChild(intId2);
				
				Element nNombre = nodoRaiz.createElement("nombre");
				Text tNombre = nodoRaiz.createTextNode(String.valueOf(emple.getNombre()));
				nEmple.appendChild(nNombre);
				nNombre.appendChild(tNombre);
				
				Element nDepartamento = nodoRaiz.createElement("departamento");
				Text tDepartamento = nodoRaiz.createTextNode(String.valueOf(emple.getDepartamento()));
				nEmple.appendChild(nDepartamento);
				nDepartamento.appendChild(tDepartamento);
				
				Element nSalario = nodoRaiz.createElement("salario");
				Text tSalario = nodoRaiz.createTextNode(String.valueOf(emple.getSalario()));
				nEmple.appendChild(nSalario);
				nSalario.appendChild(tSalario);
				
			}		

			//Usar un Transformer para generar el archivo XML
			// UNA VEZ GENERADA LA EXTRUCTURA SE CREA LA FUENTE XML A PARTIR DE LA EXTRUCTURA
			DOMSource source = new DOMSource(nodoRaiz);
			
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
			System.out.println("Error al configurar Document builder");
		}

  

	}

	public static void leerArchivoBinario() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ficheros/empleadosObj.dat"));
			
			boolean have = true;
			Empleado empleLine;
			listEmple = new ArrayList<Empleado>(); 
			
			while (have) {
				try {
					empleLine = (Empleado) ois.readObject();
					listEmple.add(empleLine); // atmbien añadimos cada lectura a un array
				} catch (IOException | ClassNotFoundException e) {
					have = false;
				}
			}
			
			ois.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
