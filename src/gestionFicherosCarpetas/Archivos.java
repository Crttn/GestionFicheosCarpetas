package gestionFicherosCarpetas;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivos {

	// Lista donde se almacenan todos los datos del archivo de nulidad
	private static ArrayList<String[]> archivos = new ArrayList<>();

	// Carga los datos del arvhico de nulidad en el arrayList para su mejor manejo
	public static void cargarArchivo(String nombre) {
		archivos.clear();
		try (BufferedReader br = new BufferedReader(new FileReader(nombre + ".txt"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datoArchivo = linea.split("	");
				archivos.add(datoArchivo);
			}
		} catch (IOException e) {
			System.out.println(Estilos.ANSI_RED + "Error al cargar los archivo." + Estilos.ANSI_WHITE);
		}
	}

	// Obtiene la ruta absoluta del archivo introducido
	public static String obtenerRutaAbsoluta(String nombre) {
		String rutaAbsoluta;
		return rutaAbsoluta = new File(nombre).getAbsolutePath();
	}

	
	// Obtiene el id del pago y genera una lista
	public static String crearListaPagos(String empresa) {
		StringBuilder listaPagos = new StringBuilder();

		for (String[] archivo : archivos) {
			if (archivo.length >= 2 && archivo[1].equals(empresa)) {
				if (listaPagos.length() > 0) {
					listaPagos.append("\n");
				}
				listaPagos.append("IdPago: " + archivo[0] + " Total: " + archivo[2] + "€");
			}
		}
		return listaPagos.toString();
	}
	
	public static String obtenerTotalPago(String empresa) {		
		double sum = 0;
		
		for (String[] archivo : archivos) {
			if (archivo[1].equals(empresa)) {
				String formateado = archivo[2].replace(".", "");
				double cantidad = Double.parseDouble(formateado);
				sum += cantidad;
			}
		}
		System.out.println(sum);
		return Double.toString(sum);
	}

	public static void crearNulidad() {

	}

	// Obtener todos los registros del archivo
	public static void leerArchivo() {
		for (String[] archivo : archivos) {
			for (int i = 0; i < archivo.length; i++) {
				System.out.print(archivo[i] + "	");
			}
			System.out.println();
		}
	}

	// Obtener un valor a partir del id de pago
	public static void obtenerIdpago(String id) {
		for (String[] archivo : archivos) {
			if (archivo[0].equals(id)) {
				System.out.println(archivo[8]);
			}
		}
	}
	
	public static void obtenerFecha(String id) {
		for (String[] archivo : archivos) {
			if (archivo[0].equals(id)) {
				System.out.println(archivo[3]);
			}
		}
	}

	public static void crearArchivos() {
		for (int i = 0; i < archivos.size(); i++) {
			System.out.println(i++);
		}
	}

	// Crear archivo de nulidad a partir de un nombre || Generar los correos
	public static void crearArchivo(String nombre) {
		File archivo;
		archivo = new File(nombre + ".txt");
		try {
			if (archivo.createNewFile()) {
				System.out.println("Archivo creado con éxito");
			} else {
				System.out.println("Error al crear el archivo");
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
	}
}
