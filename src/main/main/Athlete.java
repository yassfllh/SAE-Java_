package main;

public class Athlete implements Participant, Comparable<Athlete> {
    private Sport sport;
    private Pays pays;
    private String nom;
    private String prenom;
    private String sexe;
    private int endurance;
    private int agilite;
    private int force;

    public Athlete(String nom, String prenom, String sexe, Pays pays, Sport sport, int force, int endurance, int agilite) {
        this.sport = sport;
        this.pays = pays;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.endurance = endurance;
        this.agilite = agilite;
        this.force = force;
    }

    public Athlete(String string, String string2, String string3, int i, int j, int k, Pays bresil) {
        //TODO Auto-generated constructor stub
    }

    public Sport getSport() {
        return this.sport;
    }

    public Pays getPays() {
        return this.pays;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getSexe() {
        return this.sexe;
    }

    public int getEndurance() {
        return this.endurance;
    }

    public int getAgilite() {
        return this.agilite;
    }

    public int getForce() {
        return this.force;
    }

    public int statsAthlete() {
        // return (this.getAgilite() + this.getEndurance() + this.getForce())/3;
        return force + endurance + agilite;
    }

    @Override
    public void partitiper() {
        System.out.println("L'athlète" + prenom + " " + nom + " participe à une competition");
    }

    public String obtenirNom() {
        return nom + " " + prenom;
    }

    @Override
    public String toString() {
        return this.prenom + " " + this.nom + " " +this.getPays().getNom() + " " + this.statsAthlete() + " " + this.getSport().getNom();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sport == null) ? 0 : sport.hashCode());
        result = prime * result + ((pays == null) ? 0 : pays.hashCode());
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
        Athlete other = (Athlete) obj;
        if (sport == null) {
            if (other.sport != null)
                return false;
        } else if (!sport.equals(other.sport))
            return false;
        if (pays == null) {
            if (other.pays != null)
                return false;
        } else if (!pays.equals(other.pays))
            return false;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (prenom == null) {
            if (other.prenom != null)
                return false;
        } else if (!prenom.equals(other.prenom))
            return false;
        if (sexe == null) {
            if (other.sexe != null)
                return false;
        } else if (!sexe.equals(other.sexe))
            return false;
        return true;
    }

    @Override
    public int compareTo(Athlete other) {
        return other.statsAthlete() - this.statsAthlete();
    }
}
