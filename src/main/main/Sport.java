package main;

import java.util.ArrayList;
import java.util.List;

public abstract class Sport {
    private String nom;
    private int nbAthletes;
    protected static List<Sport> listeSports = new ArrayList<>();

    public enum SportName {
        ATHLETISME("Athlétisme"),
        NATATION("Natation"),
        VOLLEYBALL("Volley-Ball"),
        ESCRIME("Escrime"),
        HANDBALL("Handball");

        private String displayName;

        SportName(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return this.displayName;
        }
    }

    protected Sport(String nom, int nbJoueursMax) {
        this.nom = nom;
        this.nbAthletes = nbJoueursMax;
        Sport.listeSports.add(this);
    }

    public static Sport factory(String nom) {
        for (Sport s : Sport.listeSports) {
            if (s.getNom().equals(nom)) {
                return s;
            }
        }

        SportName sportName = null;
        for (SportName sn : SportName.values()) {
            if (sn.getDisplayName().equals(nom)) {
                sportName = sn;
                break;
            }
        }

        switch (sportName) {
            case ESCRIME:
                return new Escrime(1);
            case NATATION:
                return new Natation(4);
            case ATHLETISME:
                return new Athletisme(4);
            case VOLLEYBALL:
                return new Volleyball(6);
            case HANDBALL:
                return new Handball(7);
            default:
                System.err.println("Sport incorrect");
                return null;
        }
    }

    public String getNom() {
        return this.nom;
    }

    public int getNbAthletes() {
        return this.nbAthletes;
    }

}