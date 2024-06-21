package main;

import java.util.ArrayList;
import java.util.List;

public class Pays implements Comparable<Pays> {
    private List<Athlete> listeAthlete;
    private String nom;
    private int nbOr = 0;
    private int nbArgent = 0;
    private int nbBronze = 0;
    protected static List<Pays> lesPays = new ArrayList<>();

    public static Pays factory(String nom) {
        for (Pays p : Pays.lesPays) {
            if (p.getNom().equals(nom)) {
                return p;
            }
        }
        Pays p = new Pays(nom);
        return p;
    }

    public Pays(String nom) {
        this.listeAthlete = new ArrayList<>();
        this.nom = nom;
        Pays.lesPays.add(this);
    }

    public String getNom() {
        return this.nom;
    }

    public void ajouterAthlete(Athlete athlete) {
        if (athlete.getPays().equals(this) && !listeAthlete.contains(athlete)) {
            this.listeAthlete.add(athlete);
        }
    }

    public int nbMedaillesTot() {
        return this.nbOr + this.nbArgent + this.nbBronze;
    }

    public void ajouterOr() {
        nbOr++;
    }

    public void ajouterArgent() {
        nbArgent++;
    }

    public void ajouterBronze() {
        nbBronze++;
    }

    public void ajouterMedaille(String medaille) {
        switch (medaille) {
            case "Or":
                nbOr++;
                break;
            case "Argent":
                nbArgent++;
                break;
            case "Bronze":
                nbBronze++;
                break;
        }
    }

    public int getNbOr() {
        return nbOr;
    }

    public int getNbArgent() {
        return nbArgent;
    }

    public int getNbBronze() {
        return nbBronze;
    }

    public void resetMedals() {
        this.nbOr = 0;
        this.nbArgent = 0;
        this.nbBronze = 0;
    }

    @Override
    public String toString() {
        return "[" + nom + " : Or = " + this.nbOr + ", Argent = " + this.nbArgent + ", Bronze = " + this.nbBronze + ", Nombre total de médailles = " + this.nbMedaillesTot() + "]\n";
    }

    @Override
    public int compareTo(Pays other) {
        return other.nbMedaillesTot() - this.nbMedaillesTot();
    }
}
