package cat.iesesteveterradas.mp06.uf1.solucions.pr12;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class PR125cp {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Arguments passed to main method:");
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("No arguments were passed to the main method.");
        }

        if (args.length != 2) {
            System.out.println("Ús: java PR125cp <ruta_origen> <ruta_destí>");
            return;
        }

        File fitxerOrigen = new File(args[0]);
        File fitxerDesti = new File(args[1]);

        // Comprovar que l'arxiu origen existeix i no és un directori
        if (!fitxerOrigen.exists() || fitxerOrigen.isDirectory()) {
            System.out.println("L'arxiu origen no existeix o és una carpeta.");
            return;
        }

        // Si el destí és un directori, afegim el nom de l'arxiu origen
        if (fitxerDesti.isDirectory()) {
            fitxerDesti = new File(fitxerDesti, fitxerOrigen.getName());
        }

        // Realitzar la còpia de l'arxiu
        try (BufferedReader br = new BufferedReader(new FileReader(fitxerOrigen));
             PrintWriter pw = new PrintWriter(new FileWriter(fitxerDesti))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                pw.println(linia);
            }
            System.out.println("La còpia s'ha completat amb èxit.");
        } catch (IOException e) {
            System.out.println("Hi ha hagut un error en la còpia de l'arxiu: " + e.getMessage());
        }
    }
}
