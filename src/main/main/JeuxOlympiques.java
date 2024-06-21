package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JeuxOlympiques {
    private List<Pays> listePaysParticipants;
    private List<Epreuve> listeEpreuves;
    private List<Athlete> listeAthletes;

    public JeuxOlympiques() {
        this.listePaysParticipants = new ArrayList<>();
        this.listeEpreuves = new ArrayList<>();
        this.listeAthletes = new ArrayList<>();
    }

    public void ajouterPays(Pays pays) {
        if (!listePaysParticipants.contains(pays)) {
            listePaysParticipants.add(pays);
        }
    }

    public void ajouterEpreuve(Epreuve epreuve) {
        if (!listeEpreuves.contains(epreuve)) {
            listeEpreuves.add(epreuve);
        }
    }

    public void ajouterAthlete(Athlete athlete) {
        if (!listeAthletes.contains(athlete)) {
            listeAthletes.add(athlete);
        }
    }

    public List<Pays> classementPays() { // classement par ordre décroissant (du meilleur au pire)
        List<Pays> lp = new ArrayList<>(listePaysParticipants);
        Collections.sort(lp);
        return lp;
    }

    public List<Pays> getListePaysParticipants() {
        return listePaysParticipants;
    }

    public List<Epreuve> getListeEpreuves() {
        return listeEpreuves;
    }

    public List<Athlete> getListeAthletes() {
        return listeAthletes;
    }
    
}
