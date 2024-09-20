package edu.badpals;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Ejercicio5 {
    public static void main(String[] args) {
        System.out.println("Introduce el nombre del fichero");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        Map<String, List<String>> cars = new HashMap<>();
        try{
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (int i = 2; i < lines.size(); i += 2) {
                String[] line = lines.get(i).split(" ", 2);
                String brand = line[0];
                String model = line[1];
                if(cars.containsKey(brand)) {
                    cars.get(brand).add(model);
                }else{
                        List<String> models = new ArrayList<>();
                        models.add(model);
                        cars.put(brand, models);
                    }
            }
            TreeMap<String, List<String>> sortedCars = new TreeMap<>(cars);
            sortModels(sortedCars);
            String sortedFileName = fileName.replace(".txt", "_sorted.txt");
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(sortedFileName));
            for (Map.Entry<String, List<String>> entry : sortedCars.entrySet()) {
                writer.write(entry.getKey());
                writer.write(" ");
                StringBuilder stringOfModels = new StringBuilder();
                for (String model : entry.getValue()) {
                    stringOfModels.append(model)
                            .append(", ");
                }
                stringOfModels = new StringBuilder(stringOfModels.substring(0, stringOfModels.length() - 2));
                writer.write(stringOfModels.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }

    private static void sortBrands(Map<String, List<String>> cars) {

    }

    private static void sortModels(Map<String, List<String>> cars) {
        for (Map.Entry<String, List<String>> entry : cars.entrySet()) {
            entry.getValue().sort(Comparator.naturalOrder());
        }

    }
}
