package boletin1.ejercicio3;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		String nombre;
		int edad;
		double altura;
		
		int sumaEdad = 0;
		double sumaAltura = 0;
		int contador = 0;
		
		try (Scanner sc = new Scanner(new FileReader("src\\boletin1\\ejercicio3\\Alumnos.txt"))) {
			while (sc.hasNextLine()) {
				int i = 1;
				
				String datos[] = {sc.next(), sc.next(), sc.next()};
				
				for (String dato : datos) {
					System.out.print(dato + " ");
					
					switch (i) {
					case 1 -> {
						contador++;
					}
					case 2 -> {
						sumaEdad += Integer.parseInt(dato);
					}
					case 3 -> {
						sumaAltura += Double.parseDouble(dato);
					}
					}
					
					i++;
				}
				
				System.out.println();
			}
			
			System.out.println(sumaEdad + "\n" + sumaAltura);
			
		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado.");
		}

	}

}
