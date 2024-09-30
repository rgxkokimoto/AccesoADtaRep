package pojo;

import java.io.Serializable;

public class Cliente implements Serializable{ 
	// UNA CLASE SERIALIZABLE puede tener objetos trancribibles a archivos binarios
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // estas deben tener un id 
	
	private String nombre;
	private String apellido;
	private String email;
	private String direccion;
	private String fechaAlta;
	private String provincia;
	private String ciudad;
	
	public Cliente(String nombre, String apellido, String email, String direccion, String fechaAlta, String provincia,
			String ciudad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.fechaAlta = fechaAlta;
		this.provincia = provincia;
		this.ciudad = ciudad;
	}
	
	@Override
	public String toString() {
		return "Cliente: " + nombre 
				+ "Apellido: " + apellido 
				+ "Email: " + email 
				+ "Direccion: " + direccion
				+ "Fecha Alta: " + fechaAlta 
				+ "Provincia: " + provincia 
				+ "Ciudad: " + ciudad;
	}
	
	
	
	
	
}
