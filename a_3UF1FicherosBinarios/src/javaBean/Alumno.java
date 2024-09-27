package javaBean;

import java.io.Serializable;

public class Alumno implements Serializable {
	// para ser serializable debes implementar 
	
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private int edad;
	private String curso;
	
	public Alumno(String nombre, int edad, String curso) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.curso = curso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getCurso() {
		return curso;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", curso=" + curso + "]";
	}
	
	
	

}
