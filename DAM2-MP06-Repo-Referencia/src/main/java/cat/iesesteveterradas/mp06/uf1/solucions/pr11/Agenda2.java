package cat.iesesteveterradas.mp06.uf1.solucions.pr11;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class Agenda2 {
    private TreeMap llista = new TreeMap();

    public static void main(String args[]) {
        // Crearem una nova agenda ordenada
        Agenda2 a2 = new Agenda2();

        // Afegirem una sèrie de parells <key,value> a l’agenda
        a2.llista.put("Metge", "(+52)-4000-5000");
        a2.llista.put("Casa", "(888)-4500-3400");
        a2.llista.put("Germa", "(575)-2042-3233");
        a2.llista.put("Oncle", "(421)-1010-0020");
        a2.llista.put("Sogres", "(334)-6105-4334");
        a2.llista.put("Oficina", "(304)-5205-8454");
        a2.llista.put("Advocat", "(756)-1205-3454");
        a2.llista.put("Pare", "(55)-9555-3270");
        a2.llista.put("Botiga", "(874)-2400-8600");

        // Cridem un mètode que mostrarà la llista de contactes de l’agenda.
        // L’orde establert als element inserits al TreeMap és ascendent
        // del seu ordre d’inserció.
        mostrarAgenda(a2.llista);

        // Definirem dos subarbres utilitzant mètodes específics
        SortedMap AO = a2.llista.subMap("A", "O");
        SortedMap PZ = a2.llista.tailMap("P");

        System.out.println("---- Agenda A-O ----");
        mostrarAgenda(AO);
        System.out.println("---- Agenda P-Z ----");
        mostrarAgenda(PZ);
    }

    public static void mostrarAgenda(Map m) {
        System.out.println("> Agenda amb " + m.size() + " telefons");
        for (Iterator i = m.keySet().iterator(); i.hasNext(); ) {
            String k = (String) i.next();
            String v = (String) m.get(k);
            System.out.println("  " + k + " : " + v);
        }
        System.out.println("---");
        System.out.println("");
    }
}

/*
El fet que el mètode mostrarAgenda en la classe Agenda2 sigui static implica diverses coses:

No necessita una instància de la classe per ser cridat: Un mètode static pertany a la classe mateixa i no a una instància específica d'aquesta classe. Això vol dir que pots cridar al mètode sense haver de crear un objecte de la classe. En el cas del codi proporcionat, es crida al mètode mostrarAgenda directament des del mètode main sense la necessitat d'utilitzar una instància de Agenda2.

No pot accedir directament a variables d'instància no estàtiques: Un mètode estàtic no pot accedir directament a les variables d'instància no estàtiques de la classe o cridar a altres mètodes no estàtics de la classe llevat que es creï una instància de la classe. En aquest codi, això no és un problema ja que mostrarAgenda treballa amb el paràmetre Map m que se li passa i no intenta accedir a cap altre membre no estàtic de la classe.

Memòria: Els mètodes estàtics no s'associen amb objectes individuals. En canvi, es carreguen a la memòria una vegada i s'associen amb la classe. Això pot ser més eficient si només necessites un mètode específic i no vols instanciar tota la classe.

Comparant-ho amb l'exercici anterior (que anomenes exercici 0):

A l'exercici anterior, el mètode mostrarAgenda era un mètode d'instància i no estàtic. Per tant, necessitaves una instància de la classe Agenda (que es creava amb Agenda a = new Agenda();) per cridar aquest mètode, fent servir a.mostrarAgenda();.

En el cas d'Agenda2, no hi ha necessitat d'una instància específica per cridar al mètode mostrarAgenda, ja que és un mètode estàtic i es crida directament des del mètode main fent servir mostrarAgenda(a2.llista);.
*/