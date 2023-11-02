package cat.iesesteveterradas.mp06.uf1.exemples;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;

// En aquest exemple es llegeixen
// dades primitives JAVA d'un arxiu binari
// S'hauràn de llegir en el mateix
// ordre que s'han escrit

// Com que els objectes NO són
// dades de tipus primitiu en JAVA
// llegim els seus bytes
// amb la funció "readSerializableObject"

// Per transformar de bytes a Objecte,
// l'objecte ha de ser serializable

public class LecturaDadesPrimitives {
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
            FileInputStream fis = new FileInputStream(filePath);
            DataInputStream dis = new DataInputStream(fis);

            String cad = dis.readUTF();
            int num = dis.readInt();
            boolean bool = dis.readBoolean();
            char chr = dis.readChar();
            double dou = dis.readDouble();
            Objecte obj = (Objecte) readSerializableObject(dis);

            System.out.println("String > " + cad);
            System.out.println("Enter > " + num);
            System.out.println("Booleà > " + bool);
            System.out.println("Caràcter > " + chr);
            System.out.println("Double > " + dou);
            System.out.println("Objecte > " + obj);

            fis.close();
            dis.close();
            
        } catch (IOException e) { e.printStackTrace(); }
    }

    static Object readSerializableObject (DataInputStream dis) {
        try {
            // Llegeix la longitud de l'array
            int lgth = dis.readInt();
            byte[] data = new byte [lgth];

            // LLegeix l'array que conté l'objecte
            dis.readFully(data, 0, lgth);

            // Transforma l'array de bytes en objecte
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);
            return is.readObject();

        } catch (ClassNotFoundException e) { e.printStackTrace();
        } catch (UnsupportedEncodingException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace(); }
        return new AbstractMethodError();
    }
}
