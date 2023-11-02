package cat.iesesteveterradas.mp06.uf1.solucions.pr12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PR123Sobreescriu {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        File dataDir = new File(userDir, "data/pr12");

        // Assegurar que el directori data existeix
        if (!dataDir.exists() && !dataDir.mkdirs()) {
            System.out.println("No s'ha pogut crear el directori 'data'.");
            return;
        }

        File outputFile = new File(dataDir, "frasesMatrix.txt");

        try (FileWriter writer = new FileWriter(outputFile, false)) { // false per a sobreescriure
            writer.write("Yo sólo puedo mostrarte la puerta\n");
            writer.write("Tú eres quien la tiene que atravesar\n");
            System.out.println("S'ha sobreescrit el contingut al fitxer " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Hi ha hagut un problema escrivint a l'arxiu: " + e.getMessage());
        }
    }
}
