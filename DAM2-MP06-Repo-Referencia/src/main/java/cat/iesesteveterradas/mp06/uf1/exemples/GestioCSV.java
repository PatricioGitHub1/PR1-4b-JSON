package cat.iesesteveterradas.mp06.uf1.exemples;

import java.io.File;
import java.util.Arrays;
import java.util.List;

// En aquest exemple es fa servir
// UtilsCSV per llegir i modificar
// les dades d'un CSV

public class GestioCSV {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String fileName = "Arxiu.csv";
        String filePath = basePath + fileName;

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }
        
        System.out.println("");

        List<String> csv = UtilsCSV.read(filePath);

        String[] columnes = UtilsCSV.getKeys(csv);
        System.out.println("Les columnes són: " + Arrays.toString(columnes));

        int posicioColumna = UtilsCSV.csvGetColumnPosition(csv, "titol");
        System.out.println("La columna \"titol\" està a la posició "+ posicioColumna);

        String[] dadesTitol = UtilsCSV.getColumnData(csv, "titol");
        dadesTitol = Arrays.copyOfRange(dadesTitol, 1, dadesTitol.length); // Treu el primer element, que és el nom de la columna
        System.out.println("Els títols de l'arxiu són: " + Arrays.toString(dadesTitol));

        int numLiniaTitanic = UtilsCSV.getLineNumber(csv, "titol", "Titanic");
        System.out.println("La fila on està \"Titanic\" és la " + numLiniaTitanic);

        int numLiniaAvatar = UtilsCSV.getLineNumber(csv, "id", "123");
        System.out.println("La fila on està \"Avatar\" és la " + numLiniaAvatar);

        String strLiniaAvatar = csv.get(numLiniaAvatar);
        System.out.println("El text de la fila \"d'Avatar\" és \"" + strLiniaAvatar + "\"");

        String[] arrAvatar = UtilsCSV.getLineArray(strLiniaAvatar);
        System.out.println("L'array de dades de la fila \"d'Avatar\" és " + Arrays.toString(arrAvatar));

        int posAny = UtilsCSV.csvGetColumnPosition(csv, "any");
        int oldAny = Integer.parseInt(arrAvatar[posAny]);
        int nouAny = (int) ((Math.random() * (2020 - 1999)) + 1999);
        UtilsCSV.update(csv, numLiniaAvatar, "any", Integer.toString(nouAny));
        UtilsCSV.write(filePath, csv);
        System.out.println("S'ha canviat l'any \"d'Avatar\", era " + oldAny + " i s'ha posat " + nouAny);

        System.out.println("\nDades del CSV:");
        UtilsCSV.list(csv);
    }
}