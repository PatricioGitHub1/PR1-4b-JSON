package cat.iesesteveterradas.mp06.uf1.solucions.pr12;

import java.io.IOException;
import java.util.Scanner;

public class PR12Main {
    static Scanner in = new Scanner(System.in); // System.in és global

    // Main
    public static void main(String[] args) throws InterruptedException, IOException {
        boolean running = true;
        while (running) {
            String menu = "Escull una opció:";
            menu = menu + "\n 0) PR120ReadFile";
            menu = menu + "\n 1) PR121Files";
            menu = menu + "\n 2) PR122cat";
            menu = menu + "\n 3) PR123Append";
            menu = menu + "\n 4) PR123Sobreescriu";
            menu = menu + "\n 5) PR124Linies";
            menu = menu + "\n 6) PR125cp";
            menu = menu + "\n 100) Sortir";
            System.out.println(menu);

            int opcio = Integer.valueOf(llegirLinia("Opció:"));
            try {
                switch (opcio) {
                    case 0: PR120ReadFile.main(args); break;
                    case 1: PR121Files.main(args); break;
                    case 2: PR122cat.main(args); break;
                    case 3: PR123Append.main(args); break;
                    case 4: PR123Sobreescriu.main(args); break;
                    case 5: PR124Linies.main(args); break;
                    case 6: PR125cp.main(args); break;
                    case 100: running = false; break;
                    default: System.out.println("Opció no vàlida."); break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        in.close();
    }

    static public String llegirLinia(String text) {
        System.out.print(text);
        return in.nextLine();
    }
}
