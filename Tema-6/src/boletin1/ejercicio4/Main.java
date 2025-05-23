package boletin1.ejercicio4;

import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);

		// Constante con la dirección relativa del fichero
		final String FICHERO = "Tema-6\\src\\boletin1\\ejercicio4\\Cadenas.txt";
		
		// Entrada del usuario
		String entrada;

		// Try-catch para el writer
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {
			// Preguntamos por la cadena
			System.out.print("Introduce texto: ");
			
			// Mientras no sea "fin"
			while (!(entrada = reader.nextLine()).toLowerCase().equals("fin")) {
				
				// Escribimos y añadimos una nueva línea
				bw.write(entrada);
				bw.newLine();
				
				// Volvemos a preguntar
				System.out.print("Introduce texto: ");
			}
		} catch (IOException e) { // Lanzamos excepción si no se encuentra
			System.err.println("Archivo no encontrado.");
		}
		
		reader.close();
		
	}

}
