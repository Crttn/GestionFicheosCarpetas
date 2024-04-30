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
		try {
			BufferedReader br = new BufferedReader(new FileReader(nombre + ".txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datoArchivo = linea.split("	");
				archivos.add(datoArchivo);
			}
			br.close();
		} catch (IOException e) {
			System.out.println(Estilos.ANSI_RED + "Error al cargar los archivo." + Estilos.ANSI_WHITE);
		}
	}
	
	// Obtiene la ruta absoluta del archivo introducido 
		public static String obtenerRutaAbsoluta(String nombre) {
			String rutaAbsoluta;
			return rutaAbsoluta = new File(nombre).getAbsolutePath();
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
