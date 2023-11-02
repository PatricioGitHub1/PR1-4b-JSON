package cat.iesesteveterradas.mp06.uf1.exemples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Aquest exemple escriu un text 
// en un arxiu amb FileWriter
// Després el torna a obrir per afegir-hi més text
// amb el paràmetre 'append'

public class EscripturaArxiuWriter {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "ArxiuEscriu.txt";

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }

        System.out.println("");

        try {
            FileWriter fw0 = new FileWriter(filePath);
            fw0.write("Sometimes life hits you in the head with a brick\n"); 
            fw0.write("Don’t lose faith. I’m convinced that the only\n");
            fw0.close();

            FileWriter fw1 = new FileWriter(filePath, true);
            fw1.write("thing that kept me going was that I loved what I did.\n");
            fw1.write("You’ve got to find what you love.\n");
            fw1.close();

            System.out.println("Llest");

        } catch (IOException e) { e.printStackTrace(); }
    }
}
