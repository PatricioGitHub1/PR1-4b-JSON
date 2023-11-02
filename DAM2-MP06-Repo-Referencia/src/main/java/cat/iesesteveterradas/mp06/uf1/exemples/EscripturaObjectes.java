package cat.iesesteveterradas.mp06.uf1.exemples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// En aquest exemple s'escriu un arxiu
// binari amb objectes JAVA serializables
// S'hauràn de llegir en el mateix
// ordre que s'han escrit

public class EscripturaObjectes {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "ArxiuEscriuObjectes.dat";

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }

        System.out.println("");

        try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

            Objecte obj0 = new Objecte("Escriptori", "Estudiar");
            Objecte obj1 = new Objecte("Telèfon", "Perdre el temps");

			oos.writeObject(obj0);
            oos.writeObject(obj1);

			oos.close();
			fos.close();

            System.out.println("Llest");

		} catch (IOException e) { e.printStackTrace(); }
    }
}
