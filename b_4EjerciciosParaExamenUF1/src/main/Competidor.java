package main;

public class Competidor {
	
//	o id: número entero único generado automáticamente por el programa.
//	o nombre: nombre del competidor (máximo 30 caracteres).
//	o vehiculo: modelo del vehículo del competidor (máximo 20 caracteres).
//	o tiempo: tiempo total en minutos que tardó en completar la carrera.
	
	private int id;
	private String nombre;
	private String vehiculo;
	private double tiempo; // en minutos
	
	public Competidor(int id, String nombre, String vehiculo, double tiempo) {
		this.id = id;
		this.nombre = nombre;
		this.vehiculo = vehiculo;
		this.tiempo = tiempo;
	}
	
	// gets and sets TODO
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public double getTiempo() {
		return tiempo;
	}
	
	// toString

	@Override
	public String toString() {
		return "id: " + id + " nombre: " + nombre + " vehiculo: " + vehiculo + " tiempo: " + tiempo;
	}

	
	
	

}
