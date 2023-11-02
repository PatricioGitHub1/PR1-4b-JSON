package cat.iesesteveterradas.mp06.uf1.exemples;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Aquest exemple mostra algunes
// opcions per gestionar arxius
// des de codi Java a través de File

public class GestioArxius {
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

        try {
            // Comprovar que un arxiu existeix
            File f0 = new File(filePath);
            if (f0.exists()) {
                System.out.println("L'arxiu \"" + f0.getName() + "\" existeix");
            }

            // Crear un arxiu
            File f1 = new File(basePath + "ArxiuTmp.txt");
            boolean arxiuCreat = f1.createNewFile();
            if (arxiuCreat) {
                System.out.println("S'ha creat l'arxiu \"" + f1.getName() + "\"");
            } else {
                System.out.println("No s'ha pogut crear l'arxiu \"" + f1.getName() + "\"");
            }

            TimeUnit.SECONDS.sleep(1);

            // Esborrar un arxiu
            boolean arxiuBorrat = f1.delete();
            if (arxiuBorrat) {
                System.out.println("S'ha borrat l'arxiu \"" + f1.getName() + "\"");
            } else {
                System.out.println("No s'ha pogut borrar l'arxiu \"" + f1.getName() + "\"");
            }

            // Comprovar si una ruta és un directori
            File f2 = new File(basePath);
            boolean esDirectori = f2.isDirectory();
            if (esDirectori) {
                System.out.println("La ruta \"" + f2.getName() + "\" és un directori");
            } else {
                System.out.println("La ruta \"" + f2.getName() + "\" NO és un directori");
            }

            // Comprovar si una ruta és un arxiu
            File f3 = new File(filePath);
            boolean esArxiu = f3.isFile();
            if (esArxiu) {
                System.out.println("La ruta \"" + f3.getName() + "\" és un arxiu");
            } else {
                System.out.println("La ruta \"" + f3.getName() + "\" NO és un arxiu");
            }

        } catch (IOException e) { e.printStackTrace(); 
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
