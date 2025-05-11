package boletin1.ejercicio1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		double suma = 0;
		double contador = 0;
		
		try (Scanner sc = new Scanner(new FileReader("Tema-6\\src\\boletin1\\ejercicio1\\NumerosReales.txt"))) {
			
			// Mientras haya un siguiente número...
			while (sc.hasNextDouble()) {
				suma += sc.nextDouble(); // Añadimos el siguiente número
				contador++; // Incrementamos el contador para la media
			}
			
			// Mostrar por pantalla los resultados
			System.out.println("Suma: " + suma + "\nMedia: " + suma / contador);
			
		} catch (FileNotFoundException e) { // Recogemos la excepción en caso de que se lance
			System.err.println("Archivo no encontrado.");
		}

	}

}
