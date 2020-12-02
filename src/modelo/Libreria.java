package modelo;

import java.util.HashMap;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.AlmacenUnico;

public class Libreria implements Estanteriable {
	private HashMap<String, Libro> mapaLibros;
	private AlmacenUnico<Libro> almacen;

	public Libreria() {
		super();
		this.almacen = new AlmacenUnico<Libro>();
		iniciarFichero();
	}

	private void iniciarFichero() {
		try {
			leerEstanteria();
		} catch (Exception e) {
		}
		if (null == this.mapaLibros) {
			this.mapaLibros = new HashMap<String, Libro>();
		}
	}

	public void rellenarTabla(JTable tablaLibros) {
		String nombresColumnas[] = { "ISBN", "TITULO", "EDITORIAL", "AUTOR", "PRECIO", "CANTIDAD" };
		String[][] filasTabla = new String[this.mapaLibros.size()][nombresColumnas.length];
		int i = 0;
		for (HashMap.Entry<String, Libro> entry : mapaLibros.entrySet()) {
			filasTabla[i][0] = entry.getKey();
			filasTabla[i][1] = entry.getValue().getTitulo();
			filasTabla[i][2] = entry.getValue().getEditorial();
			filasTabla[i][3] = entry.getValue().getAutor();
			filasTabla[i][4] = String.valueOf(entry.getValue().getPrecio()) + "€";
			filasTabla[i][5] = String.valueOf(entry.getValue().getCantidad());
			i++;
		}
		DefaultTableModel tablaCompleta = new DefaultTableModel(filasTabla, nombresColumnas);
		tablaLibros.setModel(tablaCompleta);
	}

	public String obtenerIdSeleccionando(JTable tablaLibros) {
		int i = 0;
		for (HashMap.Entry<String, Libro> entry : mapaLibros.entrySet()) {
			if (tablaLibros.getSelectedRow() == i) {
				return entry.getKey();
			}
			i++;
		}
		return null;
	}

	public void anadirCantidad(int cantidadNueva, String ISBNSelecionado) {
		mapaLibros.get(ISBNSelecionado).setCantidad(mapaLibros.get(ISBNSelecionado).getCantidad() + cantidadNueva);
	}

	public void eliminarLibro(int index) {
		String ISBN = obtenerISBNconcreto(index);
		borrarLibro(ISBN);
		this.mapaLibros.remove(ISBN);
	}

	public void eliminarLibro(String ISBN) {
		this.mapaLibros.remove(ISBN);
	}

	public void venderCantidad(int cantidadNueva, String ISBNSelecionado) {
		if (mapaLibros.get(ISBNSelecionado).getCantidad() > cantidadNueva) {
			mapaLibros.get(ISBNSelecionado).setCantidad(mapaLibros.get(ISBNSelecionado).getCantidad() - cantidadNueva);
		} else {
			mapaLibros.get(ISBNSelecionado).setCantidad(0);
		}
	}

	public String obtenerISBNconcreto(int index) {
		Set<String> conjunto = this.mapaLibros.keySet();
		String ISBN = null;
		if (conjunto.size() != 0) {
			Object[] array = conjunto.toArray();
			ISBN = (String) array[index];
		}
		return ISBN;
	}

	public boolean comprobarISBNExiste(String iSBNSeleccionado) {
		return mapaLibros.containsKey(iSBNSeleccionado);
	}

	public Libro getLibro(String iSBN) {
		return mapaLibros.get(iSBN);
	}

	@Override
	public boolean insertarLibro(Libro libro) {
		leerEstanteria();
		mapaLibros.put(libro.getISBN(), libro);
		guardarEstanteria(libro);
		return true;
	}

	private boolean guardarEstanteria(Libro libro) {
		return almacen.almacena(libro);

	}

	private void leerEstanteria() {
		this.mapaLibros = (HashMap<String, Libro>) almacen.recuperar();
	}

	@Override
	public boolean borrarLibro(String ISBN) {
		leerEstanteria();
		almacen.eliminar();
		eliminarLibro(ISBN);
		for (String key : mapaLibros.keySet()) {
			guardarEstanteria(getLibro(key));
		}
		return true;
	}

	@Override
	public Libro buscarLibro(Integer index) {
		return null;
	}

	public HashMap<String, Libro> getMapaLibros() {
		return mapaLibros;
	}
	}
