//3. Añadir atributos:
//
//o Define los atributos: nombre, apellido, email, direccion, fechaAlta, provincia y ciudad.
//
//4. Crea los getters y setters del POJO que usarás más tarde en la clase principal.
//
//5. Constructor y método toString():
//
//o Crea un constructor que inicialice todos los atributos de la clase.
//
//o Define el método toString() para mostrar los detalles del cliente.
package pojo;

public class Cliente {
	
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
	
	//#TODO borra los que no se usen 

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return nombre + " " + apellido + ", Email: " + email + 
				", Dirección: " + direccion + ", Fecha Alta: " 
				+ fechaAlta + ", Provincia: " + provincia 
				+ ", Ciudad: " + ciudad;
	}
	
}
