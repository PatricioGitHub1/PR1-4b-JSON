package cat.iesesteveterradas.mp06.uf1.solucions.pr12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PR122cat {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Ús: java PR122cat <ruta_fitxer>");
            return;
        }

        String path = args[0];
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("El fitxer no existeix.");
            return;
        }

        if (file.isDirectory()) {
            System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Hi ha hagut un error llegint el fitxer: " + e.getMessage());
        }
    }
}
