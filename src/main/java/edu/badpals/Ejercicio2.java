package edu.badpals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println("Introduce el nombre del fichero");
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = sc.nextLine();
        System.out.println("Introduce la letra a buscar" );
        String letraBuscada = String.valueOf(sc.nextLine().charAt(0));
        try (BufferedReader lector = new BufferedReader(new FileReader(String.valueOf(nombreArchivo)))) {
            String linea;
            long timesChar = 0;
            /*try(BufferedReader lector = new BufferedReader(new FileReader(ruta));){
                int total = 0;
                String linea;
                while ((linea = lector.readLine()) != null) {
                    for (Character c : linea.toCharArray()) {
                        if (focusCharater == c) {
                            total++;
                        }
                    }
                }
                System.out.println("El caracter aparece " + total + " vez/veces");
            } */
            while ((linea = lector.readLine()) != null) {
                timesChar += linea
                        .chars()
                        .filter(c -> c == letraBuscada.charAt(0))
                        .count();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("La letra ")
                    .append(letraBuscada)
                    .append(" aparece ")
                    .append(timesChar)
                    .append(" veces en el fichero: ")
                    .append(nombreArchivo);
            System.out.println(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
