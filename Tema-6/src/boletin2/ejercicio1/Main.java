package boletin2.ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		final String FICHERO = "src\\boletin2\\ejercicio1\\carta.txt";
        int numCaracteres = 0;
        int numLineas = 0;
        int numPalabras = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FICHERO))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                numLineas++;

                // Contar caracteres (incluye todos los caracteres de la línea)
                numCaracteres += linea.length();

                // Contar palabras (separadas por espacios)
                // Evita contar palabras en líneas vacías
                if (!linea.isEmpty()) {
                    String[] palabras = linea.split(" ");
                    numPalabras += palabras.length;
                }
            }

            System.out.println("Número de líneas: " + numLineas);
            System.out.println("Número de palabras: " + numPalabras);
            System.out.println("Número de caracteres: " + numCaracteres);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
	}

}
