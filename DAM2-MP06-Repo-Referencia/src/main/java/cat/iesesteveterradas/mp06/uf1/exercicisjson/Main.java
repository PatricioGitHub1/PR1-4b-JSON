package cat.iesesteveterradas.mp06.uf1.exercicisjson;

import java.util.*;


public class Main {
    static Scanner in = new Scanner(System.in); // System.in és global, Scanner també ho a de ser

    // MainExemples
    public static void main(String[] args) {
        
        boolean running = true;

        while (running) {

            String menu = "Escull una opció:";
            menu = menu + "\n 1) Gestió d'arxius";

            menu = menu + "\n 2) Sortir";
            System.out.println(menu);

            int opcio = Integer.valueOf(llegirLinia("Opció:"));
            
            try {
                switch (opcio) {
                    case 1: PR143GestioLlibreriaMain.main(args);       break;
                    case 2: running = false;                        break;
                    default: break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
		in.close();
    }

    static public String llegirLinia (String text) {
        System.out.print(text);
        return in.nextLine();
    }
}
