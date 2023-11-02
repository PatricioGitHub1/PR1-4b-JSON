package cat.iesesteveterradas.mp06.uf1.exemples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// En aquest exemples es
// guarda una llista d'objectes
// serializables en un arxiu binari

public class EscripturaLlistes {
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

        Objecte obj0 = new Objecte("Escriptori", "Estudiar");
        Objecte obj1 = new Objecte("Telèfon", "Perdre el temps");

        ArrayList<Objecte> llista = new ArrayList<>();
        llista.add(obj0);
        llista.add(obj1);

		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(llista.toArray(new Objecte[0]));
			oos.close();
			fos.close();

            System.out.println("Llest");

		} catch (IOException e) { e.printStackTrace(); }
    }
}
