package und11_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;



public class Principal {

	public static void main(String[] args) {
		ArrayList <Escritor>escritores=new ArrayList<Escritor>();
		int opc;
		do {
			opc=menu();
			switch(opc) {
			case 1:
				alta(escritores);
				break;
			case 2:
				borrarLibro(escritores);
				break;
			case 3:
				listar(escritores);
				break;
			case 4:
				borrarEscritor(escritores);
				break;
			case 5:
				ordernar(escritores);
				break;
			case 6:
				listarEscritores(escritores);
				break;
			case 7:
				numero(escritores);
				break;
			case 8:
				mostrar(escritores);
			}
		}while(opc!=9);

	}

	private static int menu() {
		System.out.println("=======================M E N U===================");
		System.out.println("1) Introducir un libro\r\n"+
				"2) Borrar un libro por su isbn.\r\n" + 
				"3) Listar el primer y el último de los libros publicados a partir del nombre y el apellido del escritor.\r\n" + 
				"4) Borrar el escritor y todos sus libros a partir del nombre y apellido del escritor.\r\n" + 
				"5) Ordenar los escritores por fecha de nacimiento.\r\n" + 
				"6) Listar los escritores ordenados por el número de libros publicados.\r\n" + 
				"7) Mostrar el número de libros de un genero determinado, de cualquier escritor.\r\n" + 
				"8) Mostrar los libros que contienen una determinada palabra en su título.\r\n" + 
				"9) Salir");
		return Util.leerInt(1, 9);
	}

	private static void alta(ArrayList<Escritor> escritores) {
		String auxNombre=Util.introducirCadena("Introduce nombre de escritor: ");
		String auxApe=Util.introducirCadena("Introduce nombre de apellido");
		boolean existe=false;
		int posi = 0;
		for(int i=0;i<escritores.size();i++) {
			if(escritores.get(i).getApellido().equalsIgnoreCase(auxApe) && escritores.get(i).getNombre().equalsIgnoreCase(auxNombre)) {
				existe=true;
				posi=i;
				break;
			}
		}

		if(existe) {
			Libro auxLibro=new Libro();
			auxLibro.setDatos();
			escritores.get(posi).addLibro(auxLibro);
			System.out.println("Libro añadido");
		}else {
			Escritor aux=new Escritor();
			aux.setDatos(auxNombre, auxApe);
			Libro auxLibro=new Libro();
			auxLibro.setDatos();
			aux.addLibro(auxLibro);
			escritores.add(aux);
			System.out.println("Escritor añadido");
		}

	}

	private static void borrarLibro(ArrayList<Escritor> escritores) {
		System.out.println("Introduce ISBN");
		String auxIsbn=Util.introducirCadena();
		for(Escritor e:escritores) {
			Iterator <String>i=e.getLibros().keySet().iterator();
			while(i.hasNext()) {
				String auxLibro=i.next();
				if(auxLibro.equals(auxIsbn)) {
					System.out.println("Quieres borrar el libro: "+e.getLibros().get(auxLibro).getTitulo()+" (S/N)?");
					char opc=Util.respCharList("SN");
					if(opc=='S') {
						i.remove();
						System.out.println("Libro borrado");
						break;
					}
				}
			}
		}

	}

	private static void listar(ArrayList<Escritor> escritores) {
		String auxNombre=Util.introducirCadena("Introduce nombre de escritor: ");
		String auxApe=Util.introducirCadena("Introduce nombre de apellido: ");
		for(Escritor e:escritores) {
			if(e.getApellido().equalsIgnoreCase(auxApe) && e.getNombre().equalsIgnoreCase(auxNombre)) {
				if(e.getPrimerLibroPublicado()!=null) {
					System.out.println(e.getPrimerLibroPublicado().getTitulo()+" "+e.getPrimerLibroPublicado().getIsbn());
				}
				if(e.getUltimoLibroPublicado()!=null) {
					System.out.println(e.getUltimoLibroPublicado().getTitulo()+" "+e.getUltimoLibroPublicado().getIsbn());
				}
				break;
			}
		}
	}

	private static void borrarEscritor(ArrayList<Escritor> escritores) {
		String auxNombre=Util.introducirCadena("Introduce nombre de escritor: ");
		String auxApe=Util.introducirCadena("Introduce nombre de apellido: ");
		for(Escritor e:escritores) {
			if(e.getApellido().equalsIgnoreCase(auxApe) && e.getNombre().equalsIgnoreCase(auxNombre)) {
				System.out.println("Estas seguro de borrar al este escritor? (S/N)");
				char opc=Util.respCharList("SN");
				if(opc=='S') {
					escritores.remove(escritores.indexOf(e));
					System.out.println("Escritor eliminado");
				}else {
					System.out.println("Escritor no eliminado");
				}
				break;
			}
		}

	}

	private static void ordernar(ArrayList<Escritor> escritores) {
		Collections.sort(escritores);
		listarTodo(escritores);

	}

	private static void listarTodo(ArrayList<Escritor> escritores) {
		for(Escritor e:escritores) {
			System.out.println(e.getApellido()+", "+e.getNombre()+" Nº de libros"+e.getNumeroLibros());
		}

	}

	private static void listarEscritores(ArrayList<Escritor> escritores) {
		for(int i=0;i<escritores.size();i++) {
			for(int j=0;j<escritores.size();j++) {
				if(escritores.get(i).getNumeroLibros()<escritores.get(j).getNumeroLibros()) {
					Escritor aux=escritores.get(i);
					escritores.set(i, escritores.get(j));
					escritores.set(j, aux);

				}
			}
		}
		listarTodo(escritores);

	}

	private static void numero(ArrayList<Escritor> escritores) {
		/*
		String auxNombre=Util.introducirCadena("Introduce nombre de escritor: ");
		String auxApe=Util.introducirCadena("Introduce nombre de apellido: ");
		String auxGenero=Util.introducirCadena("Introduce genero: ");
		for(Escritor e:escritores) {
			if(e.getApellido().equalsIgnoreCase(auxApe) && e.getNombre().equalsIgnoreCase(auxNombre)) {
				System.out.println("Numero de libro del genero: "+e.getNumeroLibrosPorGenero(auxGenero));
				break;
			}
		}
		 */
		int cont=0;
		String auxGenero=Util.introducirCadena("Introduce genero: ");
		for(Escritor e:escritores) {
			cont=cont+e.getNumeroLibrosPorGenero(auxGenero);
		}
		System.out.println("Numero de libro del genero: "+cont);
	}

	private static void mostrar(ArrayList<Escritor> escritores) {


		String auxTitulo=Util.introducirCadena("Introduce palabra o fragmento del titulo");
		auxTitulo=auxTitulo.toLowerCase();
		for(Escritor e:escritores) {
			Iterator <Libro>i=e.getLibros().values().iterator();
			while(i.hasNext()) {
				Libro auxLibro=i.next();
				if(auxLibro.getTitulo().toLowerCase().contains(auxTitulo.toLowerCase())) {
					System.out.println(auxLibro.getTitulo());
				}
			}
		}
	}

}


