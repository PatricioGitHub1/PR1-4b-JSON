package cat.iesesteveterradas.mp06.uf1.exemples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

// En aquest exemples es
// llegeix una llista d'objectes
// serializables des de un arxiu binari

// És pràctic guardar-ho en una llista
// perquè així no cal saber quants objectes
// cal llegir

public class LecturaLlistes {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "ArxiuEscriuLlistes.dat";

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }
        
        System.out.println("");

		try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);

			ArrayList<Objecte> llista = new ArrayList<>(Arrays.asList((Objecte[]) ois.readObject()));

            for (int cnt = 0; cnt < llista.size(); cnt = cnt + 1) {
                System.out.println(llista.get(cnt));
            }

            ois.close();
			fis.close();

        } catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }
    }
}
