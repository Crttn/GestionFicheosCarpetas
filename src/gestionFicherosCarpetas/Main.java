package gestionFicherosCarpetas;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Estilos.separador();
		Estilos.menuPrincipalCartelera();
		
		int opcion;
		do {
			Estilos.separador();
			Estilos.menuPrincipal();
			opcion = Estilos.solicitarOpcion(sc);
			switch(opcion) {
			case 1:
				sc.nextLine();
				String archivo = Estilos.solicitarTexto(sc, "Introduce el nombre y la extención del archivo: ");
				Archivos.cargarArchivo(archivo);
				Entidades.generarCartaCCN("Modelo2", "Manolo", "18-2021", "Empresa004", "email@emrpesa.es");
				Entidades.imprimirCarta();
				//System.out.println(Archivos.crearListaPagos("Empresa004"));
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
			}
		} while (opcion != 3);
	}
}
