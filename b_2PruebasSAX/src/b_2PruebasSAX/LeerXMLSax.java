package b_2PruebasSAX; // TODO los ficheros xml estan vacios

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;



/*
 * El otro dia hablando con axel me di cuenta de que encapsular las la lógica en metodos 
 * ayuda a depurar el código ya que la pila de errores es mucho mas exacta 
 * y te dice en las zonas exactas done puede estar el error.
 * 
 * Poner un throw Directamente en el main es como tener una especie de manta gigante que te tapa 
 * las posible micro excepciones en funcionalidades concretas no permitiendo a la pila de errores desarrollarse 
 * como se debe.
 * Recuerda que la buena extructura tambien ayuda a la depuración y la encapsulación de momento me 
 * parece apropiada.
 * 
 * 
 * ENTOCES NO DEJES UN TRHOW EN EL MAIN encapsula 
*/

public class LeerXMLSax { 

	public static void main(String[] args) {
		leerFichero();
	}

	public static void leerFichero() {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance(); 
			SAXParser saxParser = factory.newSAXParser(); 
			XMLReader procXmlReader = saxParser.getXMLReader(); 
			GestionContenido gestor = new GestionContenido(); 			
			procXmlReader.setContentHandler(gestor); 
			
			// Definir el archivo XML a leer ya con contenido
			// es un poco redundante leer un xml para rellenarlo en otro archivo xml
			InputSource archivoXML = new InputSource("Ficheros/empleados.xml"); 
			
			imprimirEnConsola(procXmlReader, archivoXML);
			
			imprimirEnXml(procXmlReader, archivoXML);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void imprimirEnConsola(XMLReader procXmlReader, InputSource archivoXML) throws SAXException {
		// 1. PROCESAR E IMPRIMIR archivo xml en CONSOLA
		try {
			System.out.println("-----------");
			procXmlReader.parse(archivoXML);
			System.out.println("-----------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void imprimirEnXml(XMLReader procXmlReader, InputSource archivoXML) throws SAXException {
		// 2 PROCESAR e IMPRIMIR  contenido XML en archivo XML 
		try {
			PrintStream fileOut = new PrintStream(new FileOutputStream("Ficheros/empleados_generado_con_sax.xml"));
			System.setOut(fileOut);
			procXmlReader.parse(archivoXML);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
