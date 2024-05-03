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
				String[] lineaCarta = linea.split(" ");
				carta.add(lineaCarta);
			}
		} catch (IOException e) {
			System.out.println("Error al generar la carta de nulidad.");
		}
	}
	
	// Enviar cartas con la entidad CNN
	public static void generarCartaCCN(String nomArchivo, String nomCliente, String numNulidad, String nomEmpresa, String correo) {
		String nombreEmpleado = "Chema Alonso";
		String nombreCargo = "F";
		String nombreEmpresa = "Centro Criptográfico Nacional";

		try (BufferedReader br = new BufferedReader(new FileReader(nomArchivo + ".txt"))) {
			carta.clear();
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] lineaCarta = linea.split(" ");
				carta.add(lineaCarta);
			}
			
			for (String[] fila : carta) {
				for (int i = 0; i < fila.length; i++) {
					if (fila[i].equals("[Nombre_cliente],")) {
						fila[i] = nomCliente;
					}
					if (fila[i].equals("[Numero_nulidad].")) {
						fila[i] = numNulidad;
					}
					if (fila[i].equals("[nombre_empresa],")) {
						fila[i] = nomEmpresa;
					}
					if (fila[i].equals("[total_servicios].")) {
						
					}
					if (fila[i].equals("[Lista_pago_servicios]")) {
						String lista = Archivos.crearListaPagos(nombreEmpresa);
						fila[i] = lista;
					}
					if (fila[i].equals("[correo_empresa_nulidad]")) {
						fila[i] = correo;
					}
					if (fila[i].equals("[Su_nombre]")) {
						fila[i] = nombreEmpleado;
					}
					if (fila[i].equals("[Su_cargo]")) {
						fila[i] = nombreCargo;
					}
					if (fila[i].equals("[Su_empresa]")) {
						fila[i] = nombreEmpresa;
					}
				}
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
				System.out.print(linea[i] + " ");
			}
			System.out.println("");
		}
	}
}
