package boletin1.ejercicio6;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		
		final String DESORDENADO = "src\\boletin1\\ejercicio6\\Desordenados.txt";
		final String ORDENADO = "src\\boletin1\\ejercicio6\\Ordenados.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ORDENADO, true))) {
			try (BufferedReader br = new BufferedReader(new FileReader(DESORDENADO))) {
				List<Integer> lista = new ArrayList<>();
				
				String linea;
				
				while ((linea = br.readLine()) != null) {
					lista.add(Integer.parseInt(linea));
				}
				System.out.println(lista);
				
				Collections.sort(lista);
				
				System.out.println(lista);
			}
		} catch (IOException e) {
			System.err.println(e);
		}

	}

}
