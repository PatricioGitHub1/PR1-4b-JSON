package cat.iesesteveterradas.mp06.uf1.solucions.pr11;

import java.util.Scanner;
import java.util.TreeMap;

public class BotigaVideojocs {

    private TreeMap<String, Double> inventari = new TreeMap<>();

    public void afegirProducte(String nom, double preu) {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("El nom del producte no pot ser nul o buit.");
        }
        if (inventari.containsKey(nom)) {
            System.out.println("El producte ja existeix.");
            return;
        }
        inventari.put(nom, preu);
    }

    public void actualitzarPreu(String nom, double nouPreu) {
        if (!inventari.containsKey(nom)) {
            System.out.println("Producte desconegut.");
            return;
        }
        inventari.put(nom, nouPreu);
    }

    public void eliminarProducte(String nom) {
        if (!inventari.containsKey(nom)) {
            System.out.println("Producte desconegut.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Estàs segur d’esborrar el producte " + nom + "? (si/no)");
        String input = scanner.nextLine();
        if ("si".equalsIgnoreCase(input)) {
            inventari.remove(nom);
        }
    }

    public void mostrarProductes() {
        inventari.forEach((nom, preu) -> System.out.println("Producte: " + nom + ", Preu: " + preu));
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcio;
        do {
            System.out.println("\n1. Afegeix producte");
            System.out.println("2. Actualitza preu");
            System.out.println("3. Elimina producte");
            System.out.println("4. Mostra productes");
            System.out.println("5. Sortir");
            System.out.print("Selecciona una opció: ");
            opcio = scanner.nextInt();
            scanner.nextLine();  // Consumir el salt de línia

            String nom;
            double preu;
            switch (opcio) {
                case 1:
                    System.out.print("Introdueix el nom del producte: ");
                    nom = scanner.nextLine();
                    System.out.print("Introdueix el preu del producte: ");
                    preu = scanner.nextDouble();
                    afegirProducte(nom, preu);
                    break;
                case 2:
                    System.out.print("Quin producte vols actualitzar?: ");
                    nom = scanner.nextLine();
                    System.out.print("Introdueix el nou preu: ");
                    preu = scanner.nextDouble();
                    actualitzarPreu(nom, preu);
                    break;
                case 3:
                    System.out.print("Quin producte vols eliminar?: ");
                    nom = scanner.nextLine();
                    eliminarProducte(nom);
                    break;
                case 4:
                    mostrarProductes();
                    break;
                case 5:
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        } while (opcio != 5);
        scanner.close();
    }

    public static void main(String[] args) {
        BotigaVideojocs botiga = new BotigaVideojocs();
        botiga.mostrarMenu();
    }
}
