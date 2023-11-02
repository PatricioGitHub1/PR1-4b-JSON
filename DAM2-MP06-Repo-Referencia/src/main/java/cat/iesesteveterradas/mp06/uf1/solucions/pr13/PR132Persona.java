package cat.iesesteveterradas.mp06.uf1.solucions.pr13;

import java.io.Serializable;

public class PR132Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private String cognom;
    private int edat;

    public PR132Persona(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    // Getters i setters si són necessaris
    public String getNom() { return nom; }
    public String getCognom() { return cognom; }
    public int getEdat() { return edat; }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Cognom: " + cognom + ", Edat: " + edat;
    }
}
