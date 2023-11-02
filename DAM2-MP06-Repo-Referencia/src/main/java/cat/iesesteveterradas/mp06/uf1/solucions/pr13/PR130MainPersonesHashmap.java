package cat.iesesteveterradas.mp06.uf1.solucions.pr13;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PR130MainPersonesHashmap {
    public static void main(String[] args) {
        // Crear el HashMap amb les dades predefinides
        HashMap<String, Integer> persones = new HashMap<>();
        persones.put("Alice", 25);
        persones.put("Bob", 30);
        persones.put("Charlie", 35);
        persones.put("David", 40);
        persones.put("Eva", 45);

        String userDir = System.getProperty("user.dir");
        File dataDir = new File(userDir, "data/pr13");
        File fitxer = new File(dataDir, "PR130persones.dat");

        // Escriure les dades al fitxer amb DataOutputStream
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fitxer))) {
            for (Map.Entry<String, Integer> entrada : persones.entrySet()) {
                dos.writeUTF(entrada.getKey());
                dos.writeInt(entrada.getValue());
            }
        } catch (IOException e) {
            System.out.println("Hi ha hagut un problema escrivint al fitxer: " + e.getMessage());
        }

        // Llegir les dades del fitxer amb DataInputStream
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fitxer))) {
            while (dis.available() > 0) {
                String nom = dis.readUTF();
                int edat = dis.readInt();
                System.out.println("Nom: " + nom + ", Edat: " + edat);
            }
        } catch (IOException e) {
            System.out.println("Hi ha hagut un problema llegint el fitxer: " + e.getMessage());
        }
    }
}
