package cat.iesesteveterradas.mp06.uf1.exemples;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Aquest exemple escriu els continguts
// d'una List<String> en un arxiu de text

public class EscripturaArxiuList {
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
            List<String> linies = new ArrayList<String>();
            linies.add("Del xoc i la confusió apareixen les pors,");
            linies.add("perills i destruccions inapreciables per la");
            linies.add("majoria de la gent, per sectors específics");
            linies.add("de la societat i la majoria de governants.");
            linies.add("La natura, a través d'huracans, terratrèmols,");
            linies.add("fam i pandèmies genera xoc i confusió.");

            Path out = Paths.get(filePath);
            Files.write(out, linies, Charset.defaultCharset());

            System.out.println("Llest");

        } catch (IOException e) { e.printStackTrace(); }
    }
}
