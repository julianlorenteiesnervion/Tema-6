package boletin1.ejercicio6;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		// Ficheros
		final String DESORDENADO = "src\\boletin1\\ejercicio6\\Desordenados.txt";
		final String ORDENADO = "src\\boletin1\\ejercicio6\\Ordenados.txt";
		
		// Writer
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ORDENADO)); BufferedReader br = new BufferedReader(new FileReader(DESORDENADO))) {
				// Lista de números
				List<Integer> lista = new ArrayList<>();
				
				String linea;
				
				// Leer y guardar en la lista los números
				while ((linea = br.readLine()) != null) {
					lista.add(Integer.parseInt(linea));
				}
				
				Collections.sort(lista); // Ordenamos la lista
				
				// Escribir en "Ordenados.txt" la lista ordenada
				for (int num : lista) {
					bw.write(String.valueOf(num));
					bw.newLine();
			}
		} catch (IOException e) {
			System.err.println(e);
		}

	}

}
