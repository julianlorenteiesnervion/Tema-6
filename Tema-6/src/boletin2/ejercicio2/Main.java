package boletin2.ejercicio2;

import java.io.*;
import java.util.*;

public class Main {

	final static String FICHERO = "Tema-6\\src\\boletin2\\ejercicio2\\firmas.txt";
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.print("\n--- Libro de Firmas ---\n1. Mostrar firmas\n2. Añadir nueva firma\n3. Salir\nElige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
            case 1 -> {
            	mostrarFirmas();
            }
            case 2 -> {
            	System.out.print("Introduce tu nombre: ");
            	String nombre = sc.nextLine();
            	añadirFirma(nombre);
            }
            case 3 -> {
            	System.out.println("Saliendo del programa...");
            }
            default -> {
            	System.out.println("Opción no válida.");
            }
        }
        }

        sc.close();
    }

    private static void mostrarFirmas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHERO))) {
            String linea;
            System.out.println("\n--- Firmas recogidas ---");
            boolean hayFirmas = false;

            while ((linea = reader.readLine()) != null) {
                System.out.println("- " + linea);
                hayFirmas = true;
            }

            if (!hayFirmas) {
                System.out.println("No hay ninguna firma todavía.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("El libro de firmas aún no existe.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void añadirFirma(String nuevaFirma) {
        Set<String> firmas = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FICHERO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                firmas.add(linea.trim().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            // No pasa nada si no existe
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        if (firmas.contains(nuevaFirma.trim().toLowerCase())) {
            System.out.println("Error: esa firma ya está registrada.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FICHERO, true))) {
            writer.write(nuevaFirma);
            writer.newLine();
            System.out.println("Firma añadida con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
	}
}
