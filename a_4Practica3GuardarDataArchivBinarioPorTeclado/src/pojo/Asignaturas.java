package pojo;

import java.io.Serializable;

// RECUERDA 
// los archivos binarios serializables deven implementar esta clase 
// sino te saldra este error java.io.NotSerializableException: pojo.Asignaturas

public class Asignaturas implements Serializable{
	
	private static final long serialVersionUID = 1L; // tambien recuerda declarar su UID

	private String codAsignatura;
	private String nombre;
	private String profesor;
	private int numHoras;
	
	public Asignaturas(String codAsignatura, String nombre, String profesor, int numHoras) {
		super();
		this.codAsignatura = codAsignatura;
		this.nombre = nombre;
		this.profesor = profesor;
		this.numHoras = numHoras;
	}

	public String getCodAsignatura() {
		return codAsignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public String getProfesor() {
		return profesor;
	}

	public int getNumHoras() {
		return numHoras;
	}

	@Override
	public String toString() {
		return "Código: " + codAsignatura + " " 
				+ "Nombre: " + nombre + " " 
				+ "Profesor: " + profesor + " "
				+ "Horas: " + numHoras;
	}
	
	
	
}
