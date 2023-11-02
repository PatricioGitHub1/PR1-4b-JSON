package cat.iesesteveterradas.mp06.uf1.exemples;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// En aquest exemple s'escriu un arxiu
// binari amb dades primitives JAVA
// S'hauràn de llegir en el mateix
// ordre que s'han escrit

// Com que els objectes NO són
// dades de tipus primitiu en JAVA
// per escriure'ls els passem a bytes
// amb la funció "writeSerializableObject"

// Per transformar un objecte a bytes
// ha de ser serializable

public class EscripturaDadesPrimitives {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "ArxiuEscriuPrimitives.dat";

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
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF("Hola");
            dos.writeInt(44);
            dos.writeBoolean(true);
            dos.writeChar('A');
            dos.writeDouble(2.46);

            Objecte obj = new Objecte("Escriptori", "Estudiar");
            writeSerializableObject(obj, dos);
            
            dos.flush();
            fos.close();
            dos.close();

            System.out.println("Llest");
            
        } catch (IOException e) { e.printStackTrace(); }
    }

    static void writeSerializableObject (Object obj, DataOutputStream dos) {
        try {
            // Transforma l'objecte a bytes[]
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            byte [] data = bos.toByteArray();

            // Guarda la longitud de l'array
            dos.writeInt(data.length);
            
            // Guarda els bytes de l'objecte
            dos.write(data);
        } catch (IOException e) { e.printStackTrace(); }
    }
}
