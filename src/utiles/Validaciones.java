package utiles;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Validaciones {
	public static boolean validateLetters(String nombre, String campo) {
		boolean bandera=false;
		if(Pattern.matches("[a-zA-Z\\s]+", nombre)) {
			bandera=true;
		} else {
			errorField(campo);
		}
		return bandera;
	}
	
	public static boolean validateISBN(String nombre,String campo) {
		boolean bandera=false;
		if(nombre.length()==13 && isNumber(nombre,campo)) {
			bandera=true;
		} else {
			JOptionPane.showMessageDialog(null, "Fallo en ISBN");
		}
		return bandera;
	}
	public static boolean validateISBN(String nombre) {
		boolean bandera=false;
		if(nombre.length()==13 && isNumber(nombre)) {
			bandera=true;
		} 
		return bandera;
	}
	
	public static boolean isNumber(String nombre,String campo) {
		boolean bandera=false;
		if(Pattern.matches("[0-9]*", nombre)) {
			bandera=true;
		} else {
			errorField(campo);
		}
		return bandera;
	}
	public static boolean isNumber(String nombre) {
		boolean bandera=false;
		if(Pattern.matches("[0-9]*", nombre)) {
			bandera=true;
		} 
		return bandera;
	}
	
	public static boolean isNumberFloat(String nombre,String campo) {
		try {
			Float.parseFloat(nombre);
			char charAt=nombre.charAt(nombre.length()-1);
			if(charAt=='f'||charAt=='d') {
				return false;
			}
		} catch (NumberFormatException e) {
			errorField(campo);
			return false;
		}
		return true;
	}
	
	public static boolean isNtWhite(String nombre,String campo) {
		if(nombre=="") {
			errorField(campo);
			return false;
		}
		return true;
	}
	
	public static void errorField(String campo) {
		JOptionPane.showMessageDialog(null, "Fallo en "+campo);
		
	}
}
