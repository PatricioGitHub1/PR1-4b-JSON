package cat.iesesteveterradas.mp06.uf1.solucions.pr13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class PR131MainLlegeix {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        File dataDir = new File(userDir, "data/pr13");
        File inputFile = new File(dataDir, "PR131HashMapData.ser");

        System.out.println("Llegint el HashMap serialitzat de " + inputFile.getAbsolutePath());

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            PR131Hashmap myHashMap = (PR131Hashmap) ois.readObject();
            // Utilitzem un bucle for per iterar sobre el conjunt d'entrades del HashMap
            for (Map.Entry<String, Integer> entry : myHashMap.hashMap.entrySet()) {
                System.out.println("Nom: " + entry.getKey() + ", Edat: " + entry.getValue());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
