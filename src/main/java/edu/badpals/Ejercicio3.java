package edu.badpals;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("Introduce el nombre del fichero");
        Scanner sc = new Scanner(System.in);
        String FileName = sc.nextLine();
        StringBuilder ScreenMessage = new StringBuilder();
        ScreenMessage.append("Introduce el tipo de ordenación que quieres")
                        .append('\n')
                        .append("1. Ascendente case-sensitive")
                        .append('\n')
                        .append("2. Ascendente case-insensitive")
                        .append('\n')
                        .append("3. Descendente case-sensitive")
                        .append('\n')
                        .append("4. Descendente case-insensitive");

        System.out.println(ScreenMessage);
        String SelectedMethod = sc.nextLine();
        while (!SelectedMethod.matches("[1-4]")) {
            System.out.println("Opción no válida");
            System.out.println(ScreenMessage);
            SelectedMethod = sc.nextLine();
        }
        try {
            List<String> lines = Files.readAllLines(Paths.get(FileName));
            List<String> sortedLines = sortLines(lines, SelectedMethod);
            String sortedFileName = newFileName(FileName, SelectedMethod);
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(sortedFileName));

            for (String line : sortedLines) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            System.err.println("No se ha realizado la escritura " + e.getMessage());
        }
        catch (IllegalArgumentException e){
            System.err.println("El tipo de ordenación no es válido. ");
        }





    }

    private static List<String> sortLines(List<String> lines, String selectedMethod) throws IllegalArgumentException  {
        switch (selectedMethod) {
            case "1":
                System.out.println("Ascendente case-sensitive");
                return  lines.stream().sorted().toList();
            case "2":
                System.out.println("Ascendente case-insensitive");
                return lines.stream().sorted(String.CASE_INSENSITIVE_ORDER).toList();
            case "3":
                System.out.println("Descendente case-sensitive");
                return lines.stream().sorted(Comparator.reverseOrder()).toList();
            case "4":
                System.out.println("Descendente case-insensitive");
                return lines.stream().sorted(String.CASE_INSENSITIVE_ORDER.reversed()).toList();
            default:
                throw new IllegalArgumentException("Opción no válida");

        }
    }

    private static String newFileName(String fileName, String selectedMethod) throws IllegalArgumentException {
        switch (selectedMethod) {
            case "1":
                return  fileName.replace(".txt", "_ascendente_case_sensitive.txt");
            case "2":
                return fileName.replace(".txt", "_ascendente_case_insensitive.txt");
            case "3":
                return fileName.replace(".txt", "_descendente_case_sensitive.txt");
            case "4":
                return fileName.replace(".txt", "_descendente_case_insensitive.txt");
            default:
                throw new IllegalArgumentException("Opción no válida");
        }
    }
}
