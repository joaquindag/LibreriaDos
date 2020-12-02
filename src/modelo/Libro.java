package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Libro implements Serializable {

	private String ISBN;
	private String titulo;
	private String autor;
	private String editorial;
	private float precio;
	private String formato;
	private String estado;
	private int cantidad;
	private String genero;

	public Libro(String iSBN, String titulo, String autor, String editorial, float precio, String formato,
			String estado, int cantidad, String genero) {
		super();
		this.ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.precio = precio;
		this.formato = formato;
		this.estado = estado;
		this.cantidad = cantidad;
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFormato() {
		return formato;
	}

	public String getEstado() {
		return estado;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public float getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "ISBN: " + ISBN + "\nTitulo: " + titulo + "\nAutor: " + autor + "\nEditorial: " + editorial
				+ "\nFormato: " + formato + "\nEstado: " + estado + "\nPrecio: " + precio + "\nCantidad: " + cantidad
				+ "\nGenero: " + genero;
	}

}
