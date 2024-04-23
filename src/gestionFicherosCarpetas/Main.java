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
				Archivos.leerArchivo();
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
