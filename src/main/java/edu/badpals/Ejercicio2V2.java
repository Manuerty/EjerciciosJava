package edu.badpals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2V2 {
    public static void main(String[] args) {
        System.out.println("Introduce el nombre del fichero");
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = sc.nextLine();
        Path p = Path.of(nombreArchivo);
        try (BufferedReader lector = new BufferedReader(new FileReader(String.valueOf(nombreArchivo)))) {
            Map<String, Integer> letterCount = new HashMap<>();
            String linea;
            while ((linea = lector.readLine()) != null) {
                for (char c : linea.toCharArray()) {
                    letterCount.putIfAbsent(String.valueOf(c), 1);
                    letterCount.computeIfPresent(String.valueOf(c),(k,v)-> v+1);
                }
            }
            String mostRepeatedCharacter = "\s";
            int numTimesRepeated = 0 ;
            for (Map.Entry<String , Integer> entry : letterCount.entrySet())
                if (entry.getValue() > numTimesRepeated) {
                    numTimesRepeated = entry.getValue();
                    mostRepeatedCharacter = entry.getKey();
                }
            StringBuilder sb = new StringBuilder();
            sb.append("El caracter más repetido es: ")
                            .append(mostRepeatedCharacter)
                            .append(" y aparece un total de ")
                            .append(numTimesRepeated)
                            .append(" veces.");
            System.out.println(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

