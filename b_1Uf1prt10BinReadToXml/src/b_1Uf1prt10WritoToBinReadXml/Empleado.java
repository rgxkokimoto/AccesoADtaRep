package b_1Uf1prt10WritoToBinReadXml;

import java.io.Serializable;

public class Empleado implements Serializable{
	
	//id, nombre, departamento y salario.
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private int departamento;
	private double salario;
	
	public Empleado(int id, String nombre, int departamento, double salario) {
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
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
