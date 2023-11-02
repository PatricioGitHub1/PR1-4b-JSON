package cat.iesesteveterradas.mp06.uf1.solucions.pr12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PR124Linies {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        File dataDir = new File(userDir, "data/pr12");

        // Assegurar que el directori data existeix
        if (!dataDir.exists() && !dataDir.mkdirs()) {
            System.out.println("No s'ha pogut crear el directori 'data'.");
            return;
        }

        File outputFile = new File(dataDir, "numeros.txt");
        Random random = new Random();

        try (FileWriter writer = new FileWriter(outputFile)) {
            for (int i = 0; i < 10; i++) {
                // Generar número aleatori i escriure'l amb un salt de línia
                int randomNumber = random.nextInt();
                writer.write(randomNumber + "\n");
            }
            System.out.println("S'ha escrit el fitxer: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Hi ha hagut un problema escrivint a l'arxiu: " + e.getMessage());
        }
    }
}
