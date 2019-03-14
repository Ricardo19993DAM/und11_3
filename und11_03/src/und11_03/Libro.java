package und11_03;

import java.time.LocalDate;

public class Libro {
	private String isbn;
	private String titulo;
	private String genero;
	private LocalDate fechaPubli;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String sibn) {
		this.isbn = sibn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public LocalDate getFechaPubli() {
		return fechaPubli;
	}
	public void setFechaPubli(LocalDate fechaPubli) {
		this.fechaPubli = fechaPubli;
	}
	public void setDatos() {
		System.out.println("Introduce titulo: ");
		titulo=Util.introducirCadena();
		System.out.println("Introduce genero");
		genero=Util.introducirCadena();
		fechaPubli=Util.leerFecha("Introduce fecha de publicacion -->(dd/mm/aaaa)");
		System.out.println("Introduce ISBN: ");
		isbn=Util.introducirCadena();
	}
}
