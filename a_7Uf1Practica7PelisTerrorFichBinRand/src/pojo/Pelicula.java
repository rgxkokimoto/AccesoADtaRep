package pojo;

public class Pelicula {
	
	private int id; 
	private String titulo;
	private int ano ;
	private int duracion;
	private String director;
	private String sinopsis;
	
	public Pelicula(int id, String titulo, int ano, int duracion, String director, String sinopsis) {
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.duracion = duracion;
		this.director = director;
		this.sinopsis = sinopsis;
	}
	
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public int getAno() {
		return ano;
	}
	public int getDuracion() {
		return duracion;
	}
	public String getDirector() {
		return director;
	}
	public String getSinopsis() {
		return sinopsis;
	}

	@Override
	public String toString() {
		return "titulo: " + titulo + ", año: " + ano + ", duración: " + duracion + ", director: " + director
				+ ", sinopsis: " + sinopsis;
	}
	
	
}
