package gestionFicherosCarpetas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Entidades {

	static ArrayList<String[]> carta = new ArrayList<>();

	// Enviar cartas con la entidad CNI
	public static void generarCartaCNI(String nomArchivo) {
		String nombreEmpleado = "Jose Juan";
		String nombreCargo = "R";
		String nombreEmpresa = "CNI";

		try (BufferedReader br = new BufferedReader(new FileReader(nomArchivo + ".txt"))) {
			carta.clear();
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] lineaCarta = linea.split("	");
				carta.add(lineaCarta);
			}
		} catch (IOException e) {
			System.out.println("Error al generar la carta de nulidad.");
		}
	}
	
	// Enviar cartas con la entidad CNN
	public static void generarCartaCCN(String nomArchivo) {
		String nombreEmpleado = "Chema Alonso";
		String nombreCargo = "F";
		String nombreEmpresa = "CNN";

		try (BufferedReader br = new BufferedReader(new FileReader(nomArchivo + ".txt"))) {
			carta.clear();
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] lineaCarta = linea.split("	");
				carta.add(lineaCarta);
			}
		} catch (IOException e) {
			System.out.println("Error al generar la carta de nulidad.");
		}
	}
	
	public static void rellenarCarta() {
		
	}

	public static void imprimirCarta() {
		for (String[] linea : carta) {
			for (int i = 0; i < linea.length; i++) {
				System.out.println(linea[i]);
			}
		}
		System.out.println("");
	}
}
