package controlador;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import modelo.Libro;
import modelo.MyObjectOutputStream;

public class AlmacenUnico<T> {

	private File file;
	private FileOutputStream flujoW;
	private FileInputStream flujoR;
	private ObjectInputStream adaptadorR;
	private ObjectOutputStream adaptadorW;
	private boolean estado = false;
	private final String PATH = "libro.dat";

	public AlmacenUnico() {
		super();
		createFile();
	}

	public void createFile() {
		file = new File(PATH);

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean almacena(T obj) {
		try {
			if (!this.file.exists() || this.file.length() == 0) {
				createFile();
				flujoW = new FileOutputStream(file);
				adaptadorW = new ObjectOutputStream(flujoW);
			} else {
				flujoW = new FileOutputStream(file, true);
				adaptadorW = new MyObjectOutputStream(flujoW);
			}
			adaptadorW.writeObject((T) obj);
			
		} catch (IOException e) {
			estado = false;
			e.printStackTrace();
		}
		try {
			adaptadorW.close();
			flujoW.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return estado;
	}

	public HashMap<String, Libro> recuperar() {
		HashMap<String, Libro> obj = new HashMap<String, Libro>();
		try {
			flujoR = new FileInputStream(file);
			adaptadorR = new ObjectInputStream(flujoR);
			Object libreo = adaptadorR.readObject();
			while (libreo != null) {
				obj.put(((Libro) libreo).getISBN(), (Libro) libreo);
				libreo = adaptadorR.readObject();
			}
			adaptadorR.close();
			flujoR.close();
		} catch (IOException | ClassNotFoundException e) {
			estado = false;
			try {
				adaptadorR.close();
				flujoR.close();
			} catch (Exception e2) {
			}
		}
		try {
			adaptadorW.close();
			flujoW.close();
		} catch (Exception e) {
		}
		return obj;
	}

	public boolean isEstado() {
		return estado;
	}
	
	
	
	public boolean eliminar() {
		try {
			this.file.delete();
            this.file.createNewFile();
            return true;
		} catch (Exception e) {
			System.out.println("Tus muertos");
		}
		return false;
	}
}
