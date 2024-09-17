/*package edu.badpals;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println("Introduce el nombre del fichero");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Introduce ela letra a buscar" );
        String letra = sc.nextLine();
        Path p = Path.of(nombre);
        int contador = 0;
        try (var lector = new Scanner(p);) {
            while (lector.hasNextLine())
                if (lector){
                    contador++;
                }
            System.out.println("El numero de veces que aparece la letra " + letra + " es: " + contador);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}*/
