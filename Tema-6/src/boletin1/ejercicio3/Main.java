package boletin1.ejercicio3;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		String nombre;
		int edad;
		double altura;
		
		int sumaEdad;
		double sumaAltura;
		int contador;
		
		try (Scanner sc = new Scanner(new FileReader("src\\boletin1\\ejercicio3\\Alumnos.txt"))) {
			while (sc.hasNextLine()) {
				String datos[] = {sc.next(), sc.next(), sc.next()};
				
				for (String dato : datos) {
					int i = 1;
					System.out.print(dato + " ");
				}
				
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado.");
		}

	}

}
