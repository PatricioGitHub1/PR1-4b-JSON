package cat.iesesteveterradas.mp06.uf1.exemples;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// Aquest exemple llegeix un arxiu de text en una List<String>

public class LecturaArxiuList {
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
            List<String> linies = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            for (int cnt = 0; cnt < linies.size(); cnt = cnt + 1) {
                System.out.println(linies.get(cnt));
            }
        } catch (IOException e) { e.printStackTrace(); }

    }
}
