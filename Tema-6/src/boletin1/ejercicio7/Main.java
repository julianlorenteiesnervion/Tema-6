package boletin1.ejercicio7;

import java.util.*;
import java.io.*;

public class Main {
	
	// Dirección del fichero de la agenda
	public static final String FICHERO = "Tema-6\\src\\boletin1\\ejercicio7\\Agenda.txt";
	
	// Mapa con los contactos
	public static Map<String, Integer> agenda = new TreeMap<>();

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		
		// Nos traemos la información del fichero al mapa
		leerAgenda();
		
		// Mensajes repetitivos
		String menu = "1. Nuevo contacto.\n2. Buscar por nombre.\n3. Mostrar todos.\n4. Salir.\nEscoge una opción: ";
		String preguntaContacto = "Nombre del contacto: ";
		String preguntaNumero= "Número del contacto: ";
		
		// Variables para guardar temporalmente el nombre y número del contacto
		String nombre;
		int numero;
		
		do {
			// Mostramos menú y el usuario escoge la opción
			System.out.print(menu);
			numero = reader.nextInt();
			reader.nextLine();
			
			switch (numero) {
			case 1 -> { // Nuevo contacto
				System.out.print(preguntaContacto);
				nombre = reader.nextLine();
				
				System.out.print(preguntaNumero);
				numero = reader.nextInt();
				reader.nextLine();
				
				if (agregarContacto(nombre, numero)) {
					System.out.println("Contacto agregado.");
				} else {
					System.err.println("La agenda está llena o el contacto ya existe.");
				}
			}
			case 2 -> { // Buscar por nombre
				System.out.print(preguntaContacto);
				nombre = reader.nextLine();
				
				if (agenda.containsKey(nombre)) {
					System.out.println("Nombre: " + nombre + "\tTeléfono: " + agenda.get(nombre));
				} else {
					System.err.println("El contacto no existe en la agenda.");
				}
			}
			case 3 -> { // Mostrar todos los contactos
				for (String nombreAgenda : agenda.keySet()) {
					System.out.println("Nombre: " + nombreAgenda + "\tTeléfono: " + agenda.get(nombreAgenda));
				}
			}
			case 4 -> { // Salir del programa
				System.out.println("Actualizando la agenda...");
				actualizarAgenda();
				System.out.println("Agenda actualizada.");
				System.out.println("Saliendo del programa...");
			}
			default -> System.err.println("Opción no válida.");
			}
		} while (numero != 4);
		
		reader.close();
	}
	
	// Método para guardar en el mapa la información que hay en el fichero de la agenda
	static void leerAgenda() {
		try (Scanner reader = new Scanner(new FileReader(FICHERO))) {
			
			String datos[];
			
			String linea;
			
			// Mientras haya una línea, guardamos en agenda los datos de la línea
			while (reader.hasNextLine()) {
				linea = reader.nextLine();
				
				datos = linea.split(" ");
				
				agenda.put(datos[0], Integer.parseInt(datos[1]));
			}
			
		} catch (FileNotFoundException e) { // Si el fichero no se encuentra, lo creamos
			try (FileWriter fw = new FileWriter(FICHERO)) {
				System.out.println("Archivo creado en " + FICHERO);
			} catch (IOException e1) { // Error a la hora de crear el archivo
				System.err.println("Error al crear el archivo.");
			}
		}
	}
	
	// Agregar contacto al mapa
	static boolean agregarContacto(String nombre, int numero) {
		boolean res = false;
		
		if (agenda.size() < 20 && !agenda.containsKey(nombre)) {
			agenda.put(nombre, numero);
			res = true;
		}
		
		return res;
	}
	
	// Método para actualizar el fichero de la agenda con los nuevos cambios
	public static void actualizarAgenda() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO))) {
			for (String nombre : agenda.keySet()) {
				bw.write(nombre + " " + agenda.get(nombre));
				bw.newLine();
			}
		} catch (IOException e) {
			System.err.println("Error al escribir en el fichero: " + e.getMessage());
		}
	}

}
