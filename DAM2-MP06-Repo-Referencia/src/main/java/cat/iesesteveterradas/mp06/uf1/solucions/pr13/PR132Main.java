package cat.iesesteveterradas.mp06.uf1.solucions.pr13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PR132Main {
    public static void main(String[] args) {
        List<PR132Persona> persones = new ArrayList<>();
        persones.add(new PR132Persona("Maria", "López", 36));
        persones.add(new PR132Persona("Gustavo", "Ponts", 63));
        persones.add(new PR132Persona("Irene", "Sales", 54));

        String userDir = System.getProperty("user.dir");
        File dataDir = new File(userDir, "data/pr13");

        // Comprovar si el directori existeix i, si no, crear-lo
        if (!dataDir.exists() && !dataDir.mkdirs()) {
            System.out.println("No s'ha pogut crear el directori: " + dataDir.getAbsolutePath());
            return; // Sortir del programa si no es pot crear el directori
        }

        File outputFile = new File(dataDir, "PR132people.dat");

        // Escriure l'objecte List al fitxer
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(persones);
            System.out.println("Llista de persones guardada a " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Hi ha hagut un problema escrivint al fitxer: " + e.getMessage());
        }

        // Llegir l'objecte List del fitxer
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(outputFile))) {
            List<PR132Persona> personesLlegides = (List<PR132Persona>) ois.readObject();
            for (PR132Persona persona : personesLlegides) {
                System.out.println(persona);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Hi ha hagut un problema llegint el fitxer: " + e.getMessage());
        }
    }
}
