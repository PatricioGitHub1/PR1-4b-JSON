package cat.iesesteveterradas.mp06.uf1.exemples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Aquest exemple llegeix un arxiu de text linia a linia

public class LecturaArxiuScanner {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String fileName = "Arxiu.txt";
        String filePath = basePath + fileName;

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }
        
        System.out.println("");

        File file = new File(filePath);
        Scanner scnr;
        try {
            scnr = new Scanner(file);
            while(scnr.hasNextLine()){
                String line = scnr.nextLine();
                System.out.println(line);
            } 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}