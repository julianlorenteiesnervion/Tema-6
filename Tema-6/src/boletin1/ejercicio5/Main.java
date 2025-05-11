package boletin1.ejercicio5;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Tema-6\\src\\boletin1\\ejercicio5\\datos.txt", true))) {
			Scanner reader = new Scanner(System.in);
			
			System.out.print("Nombre: ");
			bw.write(reader.nextLine());
			
			System.out.print("Edad: ");
			bw.write(" " + reader.nextInt());
			
			bw.newLine();
			
			reader.close();
			
		} catch (IOException e) {
			System.err.println("Archivo no encontrado.");
		}

	}

}
