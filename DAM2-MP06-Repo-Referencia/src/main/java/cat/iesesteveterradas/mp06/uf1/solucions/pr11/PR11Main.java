package cat.iesesteveterradas.mp06.uf1.solucions.pr11;

import java.io.IOException;
import java.util.Scanner;

public class PR11Main {
    static Scanner in = new Scanner(System.in); // System.in és global

    // Main
    public static void main(String[] args) throws IOException {
        boolean running = true;
        while (running) {
            String menu = "Escull una opció:";
            menu = menu + "\n 0) Agenda";
            menu = menu + "\n 1) Agenda2";
            menu = menu + "\n 2) BotigaVideojocs";
            menu = menu + "\n 100) Sortir";
            System.out.println(menu);

            int opcio = Integer.valueOf(llegirLinia("Opció:"));
            try {
                switch (opcio) {
                    case 0: Agenda.main(args); break;
                    case 1: Agenda2.main(args); break;
                    case 2: BotigaVideojocs.main(args); break;
                    case 100: running = false; break;
                    default: System.out.println("Opció no vàlida."); break;
                }
            } catch (Exception e) {
                System.out.println("S'ha produït un error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        in.close();
    }

    static public String llegirLinia(String text) {
        System.out.print(text);
        return in.nextLine();
    }
}
