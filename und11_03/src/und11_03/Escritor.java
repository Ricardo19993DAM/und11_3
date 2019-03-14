package und11_03;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

public class Escritor extends Persona implements Comparable <Persona>{
	private boolean premiado;
	private Map<String,Libro> libros=new HashMap <String,Libro>();
	public boolean isPremiado() {
		return premiado;
	}
	public void setPremiado(boolean premiado) {
		this.premiado = premiado;
	}
	public Map<String, Libro> getLibros() {
		return libros;
	}
	public void setLibros(Map<String, Libro> libros) {
		this.libros = libros;
	}
	public Escritor(boolean premiado, Map<String, Libro> libros) {
		super();
		this.premiado = premiado;
		this.libros = libros;
	}
	public Escritor() {
		super();
	}
	public Libro getPrimerLibroPublicado() {
		Libro indicador = null;
		if(libros.size()!=0) {
			boolean primero=true;
			for(Libro l:libros.values()) {
				if(primero) {
					indicador=l;
					primero=false;
				}
				if(l.getFechaPubli().isBefore(indicador.getFechaPubli())) {
					indicador=l;
				}
			}
		}

		return indicador;
	}
	public Libro getUltimoLibroPublicado() {
		Libro indicador = null;
		if(libros.size()!=0) {
			boolean primero=true;
			for(Libro l:libros.values()) {
				if(primero) {
					indicador=l;
					primero=false;
				}
				if(l.getFechaPubli().isAfter(indicador.getFechaPubli())) {
					indicador=l;
				}
			}
		}

		return indicador;
	}
	public int getNumeroLibrosPorGenero(String genero) {
		int cont=0;
		Iterator <Libro>li=libros.values().iterator();
		while(li.hasNext()) {
			if(li.next().getGenero().equalsIgnoreCase(genero)) {
				cont++;
			}
		}
		return cont;
	}
	public int getNumeroLibros() {
		return libros.size();
	}
	public void addLibro(Libro nuevo) {
		libros.put(nuevo.getIsbn(), nuevo);
	}
	public void setDatos(String name,String ape,Libro li) {
		super.setDatos(name,ape);
		String clave=li.getIsbn();
		libros.put(clave, li);
	}
	@Override
	public int compareTo(Persona p) {
		return fechaNac.compareTo(p.getFechaNac());
	}
	
	
	
}
