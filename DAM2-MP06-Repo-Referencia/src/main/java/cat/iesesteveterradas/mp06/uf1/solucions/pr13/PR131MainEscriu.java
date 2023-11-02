package cat.iesesteveterradas.mp06.uf1.solucions.pr13;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PR131MainEscriu {
    public static void main(String[] args) {
        PR131Hashmap myHashMap = new PR131Hashmap();
        myHashMap.hashMap.put("Alice", 25);
        myHashMap.hashMap.put("Bob", 30);
        myHashMap.hashMap.put("Charlie", 35);
        myHashMap.hashMap.put("David", 40);
        myHashMap.hashMap.put("Eva", 45);

        String userDir = System.getProperty("user.dir");
        // Modifica la ruta per incloure també el directori pr13
        File dataDir = new File(userDir, "data" + File.separator + "pr13");

        // Comprova si el directori existeix. Si no, intenta crear-lo.
        if (!dataDir.exists()) {
            boolean dirCreated = dataDir.mkdirs();
            if (!dirCreated) {
                System.out.println("No s'ha pogut crear el directori de destí: " + dataDir.getAbsolutePath());
                return; // Sortir del programa si no es pot crear el directori
            }
        }

        File outputFile = new File(dataDir, "PR131HashMapData.ser");

        // Escriu l'objecte al fitxer
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(myHashMap);
            System.out.println("HashMap s'ha serialitzat a " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Hi ha hagut un problema escrivint al fitxer: " + e.getMessage());
        }
    }
}
