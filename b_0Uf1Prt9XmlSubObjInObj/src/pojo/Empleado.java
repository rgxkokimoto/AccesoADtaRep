package pojo;

public class Empleado {
	
	// Empleado contendrá atributos como id, nombre, apellido y un objeto Dirección
	
	private int id;
	private String nombre;
	private String apellido;
	private Object Direcion;
	
	public Empleado(int id, String nombre, String apellido, Object direcion) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		Direcion = direcion;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Object getDirecion() {
		return Direcion;
	}
	
	

}
