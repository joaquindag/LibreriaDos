package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Libreria;
import modelo.Libro;
import utiles.Validaciones;
import vista.UI;

public class ParaUI extends UI {
	private static final long serialVersionUID = 1L;
	private Libreria libreria = new Libreria();

	public ParaUI() {
		super();
		libreria.rellenarTabla(tablaLibros);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Libro libro = new Libro(txtIsbn.getText(), txtTitulo.getText(), txtAutor.getText(),
							txtEditorial.getText(), Float.parseFloat(txtPrecio.getText()),
							comboBoxFormato.getSelectedItem().toString(), comboBoxEstado.getSelectedItem().toString(),
							(Integer) spinnerCantidad.getValue(), comboBoxGenero.getSelectedItem().toString());
					if (ValidarDatos()) {
						if (!libreria.comprobarISBNExiste(txtIsbn.getText())) {
							libreria.insertarLibro(libro);
							libreria.rellenarTabla(tablaLibros);
							vaciarCampos();
							JOptionPane.showMessageDialog(null, "Libro guardado correctamente");
						} else {
							JOptionPane.showMessageDialog(null, "ISBN existente");
						}
					} 
				} catch (Exception e2) {
					decirFallo();
				}
			}
		});

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				libreria.eliminarLibro(tablaLibros.getSelectedRow());
				libreria.rellenarTabla(tablaLibros);
				JOptionPane.showMessageDialog(null, "Libro borrado");
			}
		});

		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vaciarCampos();
				JTextField txtISBNAComprobar = new JTextField();
				JOptionPane.showOptionDialog(null, txtISBNAComprobar, "Introduce ISBN", JOptionPane.CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if (!txtISBNAComprobar.getText().isEmpty()) {
					if (libreria.comprobarISBNExiste(txtISBNAComprobar.getText())) {
						JOptionPane.showMessageDialog(null, libreria.getLibro(txtISBNAComprobar.getText()));
					} else {
						JOptionPane.showMessageDialog(null, "No existe libro con tal ISBN");
					}
				}
			}
		});

		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String ISBNSeleccionado = libreria.obtenerIdSeleccionando(tablaLibros);
					JTextField txtModificar = new JTextField();
					JOptionPane.showOptionDialog(null, txtModificar, "Introduce cantidad", JOptionPane.CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if (!txtModificar.getText().isEmpty()) {
						if (Integer.parseInt(txtModificar.getText()) > 0) {
							libreria.anadirCantidad(Integer.parseInt(txtModificar.getText()), ISBNSeleccionado);
							libreria.rellenarTabla(tablaLibros);
							JOptionPane.showMessageDialog(null, "Cantidad agregada");
						} else {
							JOptionPane.showMessageDialog(null, "La cantidad es menor que 0");
						}
					}
					vaciarCampos();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "No hay libro seleccionado");
				}

			}
		});

		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String ISBNSeleccionado = libreria.obtenerIdSeleccionando(tablaLibros);
					JTextField txtVender = new JTextField();
					JOptionPane.showOptionDialog(null, txtVender, "Introduce cantidad", JOptionPane.CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if (!txtVender.getText().isEmpty()) {
						libreria.venderCantidad(Integer.parseInt(txtVender.getText()), ISBNSeleccionado);
						libreria.rellenarTabla(tablaLibros);
						JOptionPane.showMessageDialog(null, "Cantidad vendida");
					}
					vaciarCampos();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "No hay libro seleccionado");
				}

			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ISBN = txtIsbn.getText();
				if (ISBN.isEmpty()) {
					int i = tablaLibros.getSelectedRow();
					if (i >= 0) {
						rellenarCamposDatosLibro(libreria.obtenerISBNconcreto(i));
						tabbedPane.setSelectedIndex(0);
					} else {
						String isbnSeleccionado = JOptionPane.showInputDialog("Introduce el ISBN");
						if (isbnSeleccionado != null && !isbnSeleccionado.isEmpty()) {
							if (libreria.comprobarISBNExiste(isbnSeleccionado)) {
								rellenarCamposDatosLibro(isbnSeleccionado);
								tabbedPane.setSelectedIndex(0);
							} else {
								JOptionPane.showInputDialog(null, "ISBN no existe");
							}
						}
					}
				} else {
					libreria.eliminarLibro(ISBN);
					registrarLibro(ISBN);
					txtIsbn.setEnabled(true);
				}

			}
		});

		mntmRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelLibro.setBackground(Color.RED);
			}
		});
		mntmDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelLibro.setBackground(Color.LIGHT_GRAY);
			}
		});

		txtIsbn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				txtIsbn.setBackground(Color.red);
				txtIsbn.setForeground(Color.white);
				if (Validaciones.validateISBN(txtIsbn.getText())) {
					txtIsbn.setForeground(Color.GREEN);
					txtIsbn.setBackground(Color.WHITE);
				}
			}

			public void keyTyped(KeyEvent e) {
				if (Validaciones.validateISBN(txtIsbn.getText())) {
					e.consume();
				}
			}
		});
		;
	}
	
	private boolean ValidarDatos() {
		if (Validaciones.validateISBN(txtIsbn.getText(), "ISBN")
				&& Validaciones.validateLetters(txtAutor.getText(), "Autor")
				&& Validaciones.validateLetters(txtEditorial.getText(), "Editorial")
				&& Validaciones.isNumberFloat(txtPrecio.getText(), "Precio")
				&& Validaciones.isNtWhite(comboBoxFormato.getSelectedItem().toString(), "Formato")
				&& Validaciones.isNtWhite(comboBoxEstado.getSelectedItem().toString(), "Estado")
				&& Validaciones.isNtWhite(comboBoxGenero.getSelectedItem().toString(), "Genero")) {
			return true;
		}
		return false;
	}

	private void decirFallo() {
		Validaciones.validateISBN(txtIsbn.getText(), "ISBN");
		Validaciones.validateLetters(txtAutor.getText(), "Autor");
		Validaciones.validateLetters(txtEditorial.getText(), "Editorial");
		Validaciones.isNumberFloat(txtPrecio.getText(), "Precio");
		Validaciones.isNtWhite(comboBoxFormato.getSelectedItem().toString(), "Formato");
		Validaciones.isNtWhite(comboBoxEstado.getSelectedItem().toString(), "Estado");
		Validaciones.isNtWhite(comboBoxGenero.getSelectedItem().toString(), "Genero");
	}

	private void registrarLibro(String ISBN) {
		String titulo = txtTitulo.getText();
		String autor = txtAutor.getText();
		String editorial = txtEditorial.getText();
		float precio = Float.parseFloat(txtPrecio.getText());
		Libro libro = new Libro(ISBN, titulo, autor, editorial, precio, (String) comboBoxFormato.getSelectedItem(),
				(String) comboBoxEstado.getSelectedItem(), (int) spinnerCantidad.getValue(),
				(String) comboBoxGenero.getSelectedItem());
		libreria.insertarLibro(libro);
		libreria.rellenarTabla(tablaLibros);
		vaciarCampos();
	}

	public void rellenarCamposDatosLibro(String ISBN) {
		Libro libro = libreria.getLibro(ISBN);
		txtIsbn.setText(libro.getISBN());
		txtIsbn.setEnabled(false);
		txtAutor.setText(libro.getAutor());
		txtTitulo.setText(libro.getTitulo());
		txtEditorial.setText(libro.getEditorial());
		txtPrecio.setText(String.valueOf(libro.getPrecio()));
		spinnerCantidad.setValue(libro.getCantidad());
		comboBoxEstado.setSelectedItem(libro.getFormato());
		comboBoxFormato.setSelectedItem(libro.getEstado());
		comboBoxGenero.setSelectedItem(libro.getGenero());

	}

	public void vaciarCampos() {
		txtAutor.setText("");
		txtEditorial.setText("");
		txtPrecio.setText("");
		txtTitulo.setText("");
		txtIsbn.setText("");
		comboBoxEstado.setSelectedIndex(0);
		comboBoxFormato.setSelectedIndex(0);
		spinnerCantidad.setValue(0);
		comboBoxGenero.setSelectedIndex(0);
	}
}
