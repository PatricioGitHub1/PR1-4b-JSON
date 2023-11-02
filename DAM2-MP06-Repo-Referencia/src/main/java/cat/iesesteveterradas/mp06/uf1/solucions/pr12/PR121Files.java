package cat.iesesteveterradas.mp06.uf1.solucions.pr12;

import java.io.File;
import java.io.IOException;

public class PR121Files {
    public static void main(String[] args) {
        // Obté el directori actual de treball
        String userDir = System.getProperty("user.dir");
        File dataDir = new File(userDir, "data/pr12");
        File myFilesDir = new File(dataDir, "myFiles");
        File file1 = new File(myFilesDir, "file1.txt");
        File file2 = new File(myFilesDir, "file2.txt");
        File renamedFile = new File(myFilesDir, "renamedFile.txt");

        // Assegura't que els directoris existents
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }
        if (!myFilesDir.exists()) {
            myFilesDir.mkdir();
        }

        // Crear els arxius si no existeixen
        try {
            if (file1.createNewFile()) {
                System.out.println(file1.getName() + " ha estat creat.");
            }
            if (file2.createNewFile()) {
                System.out.println(file2.getName() + " ha estat creat.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Renombrar l'arxiu file2.txt a renamedFile.txt
        if (file2.exists()) {
            if (file2.renameTo(renamedFile)) {
                System.out.println("L'arxiu ha estat renombrat a " + renamedFile.getName());
            } else {
                System.out.println("No s'ha pogut renombrar l'arxiu.");
            }
        }

        // Mostrar el contingut del directori myFiles
        llistarContingutDirectori(myFilesDir);

        // Eliminar l'arxiu file1.txt
        if (file1.delete()) {
            System.out.println(file1.getName() + " ha estat eliminat.");
        } else {
            System.out.println("No s'ha pogut eliminar l'arxiu " + file1.getName());
        }

        // Mostrar el contingut del directori myFiles després d'eliminar l'arxiu
        llistarContingutDirectori(myFilesDir);
    }

    private static void llistarContingutDirectori(File dir) {
        String[] llistat = dir.list();
        System.out.println("Els arxius de la carpeta són:");
        if (llistat != null) {
            for (String fileName : llistat) {
                System.out.println(fileName);
            }
        }
    }
}
