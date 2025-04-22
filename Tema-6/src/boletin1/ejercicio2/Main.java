package boletin1.ejercicio2;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {

		int suma = 0;
		int contador = 0;
		
		try (Scanner sc = new Scanner(new FileReader("src\\boletin1\\ejercicio2\\Enteros.txt"))) {
			
			while (sc.hasNextInt()) {
				suma += sc.nextInt();
				contador++;
			}
			
			
			System.out.println("Suma: " + suma + "\nMedia: " + suma / contador);
			
		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado.");
		}
		
	}

}
