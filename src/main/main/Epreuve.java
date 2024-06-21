package main;

public abstract class Epreuve {
    private String nom;
    private Sport sport;
    private String sexe;

    public Epreuve(String nom, Sport sport, String sexe) {
        this.nom = nom;
        this.sport = sport;
        this.sexe = sexe;
    }

    public String getNom() {
        return this.nom;
    }

    public Sport getSport() {
        return this.sport;
    }

    public String getSexe() {
        return this.sexe;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((sport == null) ? 0 : sport.hashCode());
        result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Epreuve other = (Epreuve) obj;
        if (nom == null) {
            if (other.nom != null)
                return false;}
        if (sport == null) {
            if (other.sport != null)
                return false;
        } else if (!sport.equals(other.sport))
            return false;
        if (sexe == null) {
            if (other.sexe != null)
                return false;
        } else if (!sexe.equals(other.sexe))
            return false;
        return true;
    }

    
}
