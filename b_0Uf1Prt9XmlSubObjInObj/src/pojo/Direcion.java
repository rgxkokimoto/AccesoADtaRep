package pojo;

public class Direcion {
	
	//Dirección contendrá atributos como calle, ciudad, provincia y código postal.
	
	private String calle;
	private String ciudad;
	private String provincia;
	private int codpos;
	
	public Direcion(String calle, String ciudad, String provincia, int codpos) {
		this.calle = calle;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.codpos = codpos;
	}

	public String getCalle() {
		return calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public int getCodpos() {
		return codpos;
	}
	
	
	
	

}
