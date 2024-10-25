package dam.ad.practica11.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaEmpleados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Lista como atributo
	public  List<Empleado> listaEmpleados;
	
	
	
	public ListaEmpleados() {
		listaEmpleados = new ArrayList<Empleado>();
	}

	public void addEmple(Empleado emp) {
		listaEmpleados.add(emp);
	}
	
	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	
	

}
