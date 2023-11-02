package cat.iesesteveterradas.mp06.uf1.solucions.pr12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PR120ReadFile {
    public static void main(String[] args) {
        // Utilitzem la ruta relativa al fitxer des de l'arrel del projecte
        String filePath = "./src/main/java/cat/iesesteveterradas/mp06/uf1/solucions/pr12/PR120ReadFile.java";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                System.out.printf("%d: %s%n", lineNumber++, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}