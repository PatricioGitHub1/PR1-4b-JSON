package cat.iesesteveterradas.mp06.uf1.solucions.pr13;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PR133MainTreballadors {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Path dataPath = obtenirDataPath();
            if (!Files.exists(dataPath)) {
                System.out.println("El fitxer no existeix.");
                return;
            }

            List<String[]> treballadors = llegirTreballadors(dataPath);
            String[] capçaleres = treballadors.remove(0); // Elimina la primera línia que conté les capçaleres
            TreballadorsPrinter.imprimirTreballadors(treballadors, capçaleres);
            processarAccioUsuari(treballadors, dataPath, capçaleres);
            TreballadorsPrinter.imprimirTreballadors(treballadors, capçaleres);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Path obtenirDataPath() {
        String userDir = System.getProperty("user.dir");
        return Paths.get(userDir, "data", "pr13", "PR133treballadors.csv");
    }

    private static List<String[]> llegirTreballadors(Path dataPath) throws IOException {
        List<String> lines = Files.readAllLines(dataPath);
        List<String[]> treballadors = new ArrayList<>();
        for (String line : lines) {
            treballadors.add(line.split(","));
        }
        return treballadors;
    }

    private static void processarAccioUsuari(List<String[]> treballadors, Path dataPath, String[] capçaleres) throws IOException {
        System.out.print("Introdueix l'ID del treballador a modificar: ");
        String id = in.nextLine();

        System.out.print("Quina dada vols modificar? (Nom, Cognom, Departament, Salari): ");
        String camp = in.nextLine().toLowerCase();

        System.out.print("Introdueix el nou valor: ");
        String nouValor = in.nextLine();

        if (modificarTreballador(treballadors, id, camp, nouValor, capçaleres)) {
            guardarTreballadors(dataPath, treballadors, capçaleres);
            System.out.println("S'ha modificat el fitxer amb èxit.");
        } else {
            System.out.println("No s'ha trobat el treballador o no s'ha especificat el camp correctament.");
        }
    }

    private static boolean modificarTreballador(List<String[]> treballadors, String id, String camp, String nouValor, String[] capçaleres) {
        int campIndex = obtenirIndexCamp(camp, capçaleres);
        if (campIndex == -1) {
            System.out.println("Camp no vàlid.");
            return false;
        }

        for (int i = 0; i < treballadors.size(); i++) {
            String[] treballador = treballadors.get(i);
            if (treballador[0].equals(id)) {
                treballador[campIndex] = nouValor;
                return true;
            }
        }
        return false;
    }

    private static int obtenirIndexCamp(String camp, String[] capçaleres) {
        for (int i = 0; i < capçaleres.length; i++) {
            if (capçaleres[i].toLowerCase().replace(" ", "").equals(camp)) {
                return i;
            }
        }
        return -1;
    }

    private static void guardarTreballadors(Path dataPath, List<String[]> treballadors, String[] capçaleres) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(dataPath)) {
            bw.write(String.join(",", capçaleres));
            bw.newLine();
            for (String[] treballador : treballadors) {
                bw.write(String.join(",", treballador));
                bw.newLine();
            }
        }
    }
}

class TreballadorsPrinter {
    public static void imprimirTreballadors(List<String[]> treballadors, String[] capçaleres) {
        // Calcular l'ample de cada columna basat en les capçaleres
        int[] columnWidths = new int[capçaleres.length];
        for (int i = 0; i < capçaleres.length; i++) {
            columnWidths[i] = capçaleres[i].length() + 2; // +2 per l'espaiat
            for (String[] treballador : treballadors) {
                if (treballador[i].length() + 2 > columnWidths[i]) {
                    columnWidths[i] = treballador[i].length() + 2;
                }
            }
        }

        // Imprimir la línia de capçalera
        imprimirSeparadorTaula(columnWidths);
        for (int i = 0; i < capçaleres.length; i++) {
            System.out.printf("| %-" + (columnWidths[i] - 2) + "s ", capçaleres[i]);
        }
        System.out.println("|");
        imprimirSeparadorTaula(columnWidths);

        // Imprimir les files de dades
        for (String[] treballador : treballadors) {
            for (int i = 0; i < treballador.length; i++) {
                System.out.printf("| %-" + (columnWidths[i] - 2) + "s ", treballador[i]);
            }
            System.out.println("|");
        }

        // Imprimir la línia final de la taula i una línia en blanc
        imprimirSeparadorTaula(columnWidths);
        System.out.println();
    }

    private static void imprimirSeparadorTaula(int[] columnWidths) {
        for (int width : columnWidths) {
            System.out.print("+");
            System.out.print("-".repeat(width));
        }
        System.out.println("+");
    }
}