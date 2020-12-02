package vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class UI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JTextField txtIsbn;
	protected JTextField txtTitulo;
	protected JTextField txtAutor;
	protected JTextField txtPrecio;
	protected JTextField txtEditorial;
	protected JButton btnCrear;
	protected JButton btnBorrar;
	protected JTable tablaLibros;
	protected JButton btnConsultar;
	protected JComboBox<String> comboBoxFormato;
	protected JComboBox<String> comboBoxEstado;
	protected JSpinner spinnerCantidad;
	protected JButton btnAnadir;
	protected JButton btnVender;
	protected JButton btnModificar;
	protected JTabbedPane tabbedPane;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenu mnColor;
	protected JMenuItem mntmRojo;
	protected JPanel panelLibro;
	protected JMenuItem mntmDefault;
	protected JComboBox<String> comboBoxGenero;
	

	

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1099, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.BLACK);

		JPanel panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setBackground(Color.CYAN);

		JLabel lblLibreriaDeJoaquin = new JLabel("LIBRERIA DE JOAQUIN");
		lblLibreriaDeJoaquin.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelSuperior.add(lblLibreriaDeJoaquin);
		
		menuBar = new JMenuBar();
		panelSuperior.add(menuBar);
		
		mnMenu = new JMenu("Ajustes");
		mnMenu.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		mnMenu.setIcon(new ImageIcon(UI.class.getResource("/img/ajustes.png")));
		menuBar.add(mnMenu);
		
		mnColor = new JMenu("Color");
		mnMenu.add(mnColor);
		
		mntmRojo = new JMenuItem("Rojo");
		
		mnColor.add(mntmRojo);
		
		mntmDefault = new JMenuItem("Default");
		
		mnColor.add(mntmDefault);

		JPanel panelInferior = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelInferior.getLayout();
		flowLayout.setHgap(20);
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setBackground(Color.gray);

		btnCrear = new JButton("CREAR");
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelInferior.add(btnCrear);
		
		btnAnadir = new JButton("A\u00D1ADIR");
		
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelInferior.add(btnAnadir);

		btnBorrar = new JButton("BORRAR");

		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelInferior.add(btnBorrar);
		
		btnVender = new JButton("VENDER");
		
		btnVender.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelInferior.add(btnVender);
		
		btnModificar = new JButton("MODIFICAR");
		
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelInferior.add(btnModificar);

		btnConsultar = new JButton("CONSULTAR");

		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelInferior.add(btnConsultar);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelInferior.add(btnSalir);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.setBackground(Color.LIGHT_GRAY);

		panelLibro = new JPanel();
		tabbedPane.addTab("Libros", null, panelLibro, null);
		panelLibro.setBackground(Color.LIGHT_GRAY);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 21));
		

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 21));

		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtIsbn.setColumns(10);
		txtIsbn.setBackground(Color.red);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtTitulo.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtAutor.setColumns(10);

		txtEditorial = new JTextField();
		txtEditorial.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtEditorial.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtPrecio.setColumns(10);

		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(UI.class.getResource("/img/Libro Encantado.gif")));

		JLabel lblFormato = new JLabel("Formato");
		lblFormato.setFont(new Font("Tahoma", Font.PLAIN, 21));

		comboBoxFormato = new JComboBox<String>();
		comboBoxFormato.setFont(new Font("Tahoma", Font.PLAIN, 21));
		comboBoxFormato.addItem("");
		comboBoxFormato.addItem("Cartoné");
		comboBoxFormato.addItem("Rústica");
		comboBoxFormato.addItem("Grapada");
		comboBoxFormato.addItem("Espiral");

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 21));

		comboBoxEstado = new JComboBox<String>();
		comboBoxEstado.setFont(new Font("Tahoma", Font.PLAIN, 21));
		comboBoxEstado.addItem("");
		comboBoxEstado.addItem("Reedición");
		comboBoxEstado.addItem("Novedad");
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 21));
		
		spinnerCantidad = new JSpinner();
		spinnerCantidad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerCantidad.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JTextField txtspinnerCantidad=((JSpinner.DefaultEditor) spinnerCantidad.getEditor()).getTextField();
		txtspinnerCantidad.setEditable(false);
		
		JLabel lblGnero = new JLabel("G\u00E9nero");
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 21));
		
		comboBoxGenero = new JComboBox<String>();
		comboBoxGenero.setFont(new Font("Tahoma", Font.PLAIN, 21));
		comboBoxGenero.addItem("");
		comboBoxGenero.addItem("Aventura");
		comboBoxGenero.addItem("Misterio");
		GroupLayout gl_panelLibro = new GroupLayout(panelLibro);
		gl_panelLibro.setHorizontalGroup(
			gl_panelLibro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLibro.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLibro.createSequentialGroup()
									.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
										.addComponent(lblIsbn, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTitulo)
										.addComponent(lblAutor)
										.addComponent(lblEditorial)
										.addComponent(lblPrecio))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
										.addComponent(txtPrecio, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
										.addComponent(txtEditorial, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
										.addComponent(txtAutor, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
										.addComponent(txtTitulo, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
										.addComponent(txtIsbn, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
										.addComponent(spinnerCantidad, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
									.addGap(80))
								.addComponent(lblCantidad))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblImg, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFormato)
								.addComponent(lblGnero))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxGenero, 0, 405, Short.MAX_VALUE)
								.addComponent(comboBoxFormato, 0, 403, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(lblEstado)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxEstado, 0, 438, Short.MAX_VALUE)
							.addGap(16))))
		);
		gl_panelLibro.setVerticalGroup(
			gl_panelLibro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLibro.createSequentialGroup()
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIsbn, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtIsbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTitulo)
								.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAutor)
								.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEditorial)
								.addComponent(txtEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrecio))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCantidad)
								.addComponent(spinnerCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblImg, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFormato)
						.addComponent(comboBoxFormato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstado)
						.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGnero)
						.addComponent(comboBoxGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		panelLibro.setLayout(gl_panelLibro);

		JPanel panelEstanteria = new JPanel();
		tabbedPane.addTab("Estanteria", null, panelEstanteria, null);
		panelEstanteria.setBackground(Color.LIGHT_GRAY);
		panelEstanteria.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();

		tablaLibros = new JTable();
		tablaLibros.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane.setViewportView(tablaLibros);
		panelEstanteria.add(scrollPane);
	}
}
