package b_2PruebasSAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido extends DefaultHandler {
	// el overide sirve para demostrar que se le hizo modificaciones en una subclase de una clase padre 
	// asi ayuda a controlar mejor las excepciones 
	
//	  @Override
//	  public void startDocument() throws SAXException {
//	  System.out.println("ha comenzado la lectura del documento"); }
	
  
	  @Override
	  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	      System.out.println("<" + qName + ">");
	  }
	  
	  // 
	
	  @Override
	  public void characters(char[] ch, int start, int length) throws SAXException {
	      String contenido = new String(ch, start, length).trim();
	      if (!contenido.isEmpty()) {
	          System.out.println(contenido);
	      }
	  }
	
	  @Override
	  public void endElement(String uri, String localName, String qName) throws SAXException {
	      System.out.println("</" + qName + ">");
	  }
	  
		/*
		 * @Override public void endDocument() throws SAXException {
		 * System.out.println("\nFin del documento XML"); }
		 */
	
}
