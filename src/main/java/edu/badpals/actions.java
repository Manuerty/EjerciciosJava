package edu.badpals;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class actions {
    static String permisoLectura = "-";
    static String permisoEscritura = "-";
    static String permisoEjecucion = "-";

    public static void EsDirectorio(Path f){
        if (Files.isDirectory(f)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(f);) {
                for (Path fichero: stream) {
                    if (Files.isDirectory(fichero)) {
                        checkPermissions(fichero);
                        System.out.println(fichero.getFileName() + " es un directorio y posees los siguientes permisos d"+permisoLectura+permisoEscritura+permisoEjecucion);
                    } else {
                        checkPermissions(fichero);
                        System.out.println(fichero.getFileName() + " es un fichero y posees los siguientes permisos -"+permisoLectura+permisoEscritura+permisoEjecucion);
                    }
                }
            } catch (IOException | DirectoryIteratorException ex) {
                System.err.println(ex);
            }
        } else {
            System.err.println(f.toString()+" no es un directorio");
        }
    }

    public static void checkPermissions( Path fichero){
        if (Files.isExecutable(fichero)) {
            permisoEjecucion = "x";
        }
        if (Files.isWritable(fichero)) {
            permisoEscritura = "w";
        }
        if (Files.isReadable(fichero)) {
            permisoLectura = "r";
        }
    }
}
