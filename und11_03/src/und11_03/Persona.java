package und11_03;

import java.time.LocalDate;

public class Persona {
	protected String id;
	protected String nombre;
	protected String apellido;
	protected LocalDate fechaNac;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public Persona(String id, String nombre, String apellido, LocalDate fechaNac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
	}
	public Persona() {
		super();
	}
	public void setDatos(String anem,String ape) {
		System.out.println("Introduce ID: ");
		id=Util.introducirCadena();
		fechaNac=Util.leerFecha("Introduce fecha de nacimiento con este formato --> (dd/mm/aaaa)");
		nombre=anem;
		apellido=ape;

	}
}
