package edu.badpals;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("Introduce el nombre del fichero");
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = sc.nextLine();
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

    }
}
