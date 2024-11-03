package b_3PruebasXstream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaObjetos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//
	private List<Objeto> listaObjetos;
	
	ListaObjetos( ) {
		listaObjetos = new ArrayList<Objeto>();
	}
	
	public void addObjetos(Objeto objeto) {
		listaObjetos.add(objeto);
	}
	
	public List<Objeto> getListaObject () {
		return listaObjetos;
	}
	
}
