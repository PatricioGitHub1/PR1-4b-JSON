package cat.iesesteveterradas.mp06.uf1.solucions.pr11;

import java.util.*;
public class Agenda {
    private HashMap<String, String> persones = new HashMap<String, String>();

    public static void main(String args[]){
        Agenda a = new Agenda();
        a.persones.put("Metge", "(+52)-4000-5000");
        a.persones.put("Casa", "(888)-4500-3400");
        a.persones.put("Germa", "(575)-2042-3233");
        a.persones.put("Oncle", "(421)-1010-0020");
        a.persones.put("Sogres", "(334)-6105-4334");
        a.persones.put("Oficina", "(304)-5205-8454");
        a.persones.put("Advocat", "(756)-1205-3454");
        a.persones.put("Pare", "(55)-9555-3270");
        a.persones.put("Botiga", "(874)-2400-8600");
        a.mostrarAgenda();

        String contactes[] = {"Oncle", "Sogres", "Advocat", "Casa"};
        for(int i = 0; i < contactes.length; i++){
            a.persones.remove(contactes[i]);
        }
        a.mostrarAgenda();

        a.inserirContactes(contactes);
        a.mostrarAgenda();
    }

    public void mostrarAgenda(){
        System.out.println(">Agenda amb " + this.persones.size() + " telèfons");
        for(Iterator i=this.persones.keySet().iterator(); i.hasNext();){
            String k=(String)i.next();
            String v=(String)this.persones.get(k);
            System.out.println("  "+k+ " : " +v);
        }
        System.out.println("---");
        System.out.println("");
    }

    public void inserirContactes(String[] contactes) {
        for (String contacte : contactes) {
            if (!persones.containsKey(contacte)) {
                persones.put(contacte, "Número desconegut");
            }
        }
    }
}
