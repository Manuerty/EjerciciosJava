package edu.badpals;

import java.util.Scanner;

import java.nio.file.Path;


import static edu.badpals.actions.EsDirectorio;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        Path dir = Path.of(nombre);
        System.out.println("Ficheros del directorio " + dir);
        EsDirectorio(dir);
    }
}