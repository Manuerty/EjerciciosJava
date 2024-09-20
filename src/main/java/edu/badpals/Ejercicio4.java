package edu.badpals;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println("Introduce el nombre del fichero");
        Scanner sc = new Scanner(System.in);
        String FileName = sc.nextLine();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FileName));
            String correctAnswers = lines.get(0);
            Map<String, Double> answers = new HashMap<>();
            StringBuilder sb;
            for (int i = 2; i < lines.size(); i += 2) {
                String[] line = lines.get(i).split(" ", 2);
                String student = line[0];
                String studentAnswers = line[1];
                double score = 0;
                for (int j = 0; j < studentAnswers.length(); j++) {
                    if (studentAnswers.charAt(j) == correctAnswers.charAt(j)) {
                        score += 0.5;
                    } else if (studentAnswers.charAt(j) == ' ') {
                        score += 0;
                    } else {
                        score -= 0.15;
                    }
                    answers.put(student, score);
                }
            }
            sb = new StringBuilder();
            sb.append("Resultados: ");
            sb.append('\n');
            for (Map.Entry<String, Double> entry : answers.entrySet()) {
                sb.append(entry.getKey())
                        .append(" ")
                        .append(String.format("%.2f", entry.getValue()))
                        .append(" puntos")
                        .append('\n');
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
