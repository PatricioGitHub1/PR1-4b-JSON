package cat.iesesteveterradas.mp06.uf1.solucions.pr13;


import java.io.RandomAccessFile;

public class PR134GestorEstudiants {
    private static final int ID_SIZE = 4; // bytes per l'ID (enter)
    private static final int CHAR_SIZE = 2; // bytes per caràcter (UTF-16)
    private static final int NAME_SIZE = 20; // caràcters per al nom
    private static final int GRADE_SIZE = 4; // bytes per la nota (float)
    private static final int RECORD_SIZE = ID_SIZE + (NAME_SIZE * CHAR_SIZE) + GRADE_SIZE; // mida fixa d'un registre

    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("./data/pr13/estudiants.dat", "rw")) {
            // Afegir estudiants
            afegirEstudiant(raf, 1, "Maria", 6);
            afegirEstudiant(raf, 2, "Gustavo", 7);

            // Consultar i mostrar estudiants
            mostrarEstudiant(raf, 1);
            mostrarEstudiant(raf, 2);

            // Actualitzar nota d'estudiants
            actualitzarNotaEstudiant(raf, 1, 8);
            actualitzarNotaEstudiant(raf, 2, 9);

            // Consultar i mostrar estudiants actualitzats
            mostrarEstudiant(raf, 1);
            mostrarEstudiant(raf, 2);

            imprimirTaulaEstudiants(raf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void afegirEstudiant(RandomAccessFile raf, int id, String nom, float nota) throws Exception {
        raf.seek((id - 1) * RECORD_SIZE); // Posiciona el punter al registre correcte
        raf.writeInt(id);
        raf.writeChars(formatNom(nom));
        raf.writeFloat(nota);
    }

    public static void mostrarEstudiant(RandomAccessFile raf, int id) throws Exception {
        raf.seek((id - 1) * RECORD_SIZE); // Posiciona el punter al registre correcte
        System.out.println("Id: " + raf.readInt());
        System.out.println("Nom: " + llegirNom(raf));
        System.out.println("Nota: " + raf.readFloat());
    }

    public static void actualitzarNotaEstudiant(RandomAccessFile raf, int id, float novaNota) throws Exception {
        raf.seek((id - 1) * RECORD_SIZE + ID_SIZE + (NAME_SIZE * CHAR_SIZE)); // Salta ID i nom
        raf.writeFloat(novaNota);
    }

    private static String formatNom(String nom) {
        return String.format("%1$-" + NAME_SIZE + "s", nom);
    }

    public static void imprimirTaulaEstudiants(RandomAccessFile raf) throws Exception {
        // Assegurem-nos que comencem a llegir des de l'inici del fitxer
        raf.seek(0);

        // Capsaleres de la taula
        System.out.println("Id  | Nom                 | Nota");
        System.out.println("----+---------------------+-----");

        // Llegim cada registre fins a arribar al final del fitxer
        while (raf.getFilePointer() < raf.length()) {
            int id = raf.readInt();
            String nom = llegirNom(raf);
            float nota = raf.readFloat();
            System.out.printf("%-4d| %-20s| %.2f%n", id, nom, nota);
        }
        System.out.printf("");
    }

    private static String llegirNom(RandomAccessFile raf) throws Exception {
        char[] nomChars = new char[NAME_SIZE];
        for (int i = 0; i < NAME_SIZE; i++) {
            nomChars[i] = raf.readChar();
        }
        return new String(nomChars).trim();
    }
}
