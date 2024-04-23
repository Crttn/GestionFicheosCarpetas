package gestionFicherosCarpetas;

import java.io.*;
import java.util.ArrayList;

public class Archivos {
	
	private static ArrayList<String[]> archivos = new ArrayList<>();
	
	public static void cargarArchivo(String nombre) {
		archivos.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(nombre + ".txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datoArchivo = linea.split(" ");
				archivos.add(datoArchivo);
			}
			br.close();
		} catch (IOException e) {
			System.out.println(Estilos.ANSI_RED + "Error al cargar los archivo." + Estilos.ANSI_WHITE);
		}
	}
	
	public static void leerArchivo() {
		for (String[] archivo : archivos) {
			for (int i = 0; i < archivo.length; i++) {
				System.out.print(archivo[i]);
				// Añadir espacios para alinear los datos
				for (int j = 0; j < archivo[i].length() + 4; j++) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	// Crear archivo de nulidad a partir de un nombre
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
