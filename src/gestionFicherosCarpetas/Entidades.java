package gestionFicherosCarpetas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
	public static void generarCartaCCN(String nomArchivo, String nomCliente, String numNulidad, String nomEmpresa,
			String correo) {
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
						fila[i] = Archivos.obtenerTotalPago(nomEmpresa) + " €";
					}
					if (fila[i].equals("[Lista_pago_servicios]")) {
						fila[i] = Archivos.crearListaPagos(nomEmpresa);
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

	static ArrayList<String> empresasParaEnviar = new ArrayList<>();

	public static void obtenerNombreEmpresaUnico() {
		String empresa = "";

		for (String[] registro : Archivos.archivos) {
			empresa = registro[1];

			if (!empresasParaEnviar.contains(empresa)) {
				empresasParaEnviar.add(empresa);
			}
		}
	}

	public static void crearCartasCNN() {

		obtenerNombreEmpresaUnico();

		for (String registro : empresasParaEnviar) {
			generarCartaCCN("Modelo2.txt", registro, registro, registro, registro);
			
		}
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
