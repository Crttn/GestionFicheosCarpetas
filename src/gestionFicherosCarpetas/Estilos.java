package gestionFicherosCarpetas;

import java.util.Scanner;

public class Estilos {
	
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static int solicitarOpcion(Scanner sc) {
		System.out.print("\nIntroduce la opción: ");
		return sc.nextInt();
	}
	
	public static String solicitarTexto(Scanner sc, String texto) {
		System.out.println(texto);
		return sc.nextLine();
	}

	public static void menuPrincipalCartelera() {
		System.out.println("\n"
				+ "╔═╗╔═╗╔╗╔╔═╗╦═╗╔═╗╦═╗  ╔═╗═╗ ╦╔═╗╔═╗╔╦╗╦╔═╗╔╗╔╔╦╗╔═╗  ╔╗╔╦ ╦╦  ╦╔╦╗╔═╗╔╦╗\r\n"
				+ "║ ╦║╣ ║║║║╣ ╠╦╝╠═╣╠╦╝  ║╣ ╔╩╦╝╠═╝║╣  ║║║║╣ ║║║ ║ ║╣   ║║║║ ║║  ║ ║║╠═╣ ║║\r\n"
				+ "╚═╝╚═╝╝╚╝╚═╝╩╚═╩ ╩╩╚═  ╚═╝╩ ╚═╩  ╚═╝═╩╝╩╚═╝╝╚╝ ╩ ╚═╝  ╝╚╝╚═╝╩═╝╩═╩╝╩ ╩═╩╝\n");
	}
	
	public static void menuPrincipal() {
		System.out.println("Elige una entidad gubernamental: ");
		System.out.println("1. Centro Nacional de Inteligencia ");
		System.out.println("2. Centro Criptológico Nacional");
	}
	
	public static void separador() {
		for (int i = 0; i < 100; i++) {
			System.out.print("═");
		}
		System.out.println("");
	}
	
}
