package dam.ad.practica11.pojos;

import java.io.Serializable;

public class Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private int departamento;
	private double salario;
	
	public Empleado(int id, String nombre, int departamento, double salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDepartamento() {
		return departamento;
	}

	public double getSalario() {
		return salario;
	}
	
	
	
	

}
