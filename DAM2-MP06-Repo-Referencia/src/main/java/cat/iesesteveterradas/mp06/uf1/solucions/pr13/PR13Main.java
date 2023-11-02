package cat.iesesteveterradas.mp06.uf1.solucions.pr13;

import java.io.IOException;
import java.util.Scanner;

public class PR13Main {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        boolean running = true;
        while (running) {
            System.out.println("Escull una opció:");
            System.out.println("0) PR130MainPersonesHashmap");
            System.out.println("1) PR131MainEscriu");
            System.out.println("2) PR131MainLlegeix");
            System.out.println("3) PR132Main");
            System.out.println("4) PR133MainTreballadors");
            System.out.println("5) PR134GestorEstudiants");
            System.out.println("100) Sortir");
            System.out.print("Opció: ");

            int opcio = in.nextInt();
            in.nextLine(); // Consume newline left-over

            switch (opcio) {
                case 0:
                    PR130MainPersonesHashmap.main(args);
                    break;
                case 1:
                    PR131MainEscriu.main(args);
                    break;
                case 2:
                    PR131MainLlegeix.main(args);
                    break;
                case 3:
                    PR132Main.main(args);
                    break;
                case 4:
                    PR133MainTreballadors.main(args);
                    break;
                case 5:
                    PR134GestorEstudiants.main(args);
                    break;
                case 100:
                    running = false;
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
                    break;
            }
        }
        in.close();
    }
}
