package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompetitionIndividuelle extends Epreuve {
    private List<Athlete> listeAthleteParticipants;

    public CompetitionIndividuelle(String nom, Sport sport, String sexe) {
        super(nom, sport, sexe);
        this.listeAthleteParticipants = new ArrayList<>();
    }

    public void ajouterAthlete(Athlete athlete) {
        listeAthleteParticipants.add(athlete);
    }

    public void start(List<Athlete> listeAthleteParticipants, Sport sport) {
        Collections.sort(listeAthleteParticipants);
        for (int i = 0 ; i < listeAthleteParticipants.size() ; i++) {
            if (i == 0) {
                listeAthleteParticipants.get(i).getPays().ajouterOr();
                System.out.println("L'athlète " + listeAthleteParticipants.get(i).getPrenom() + " " + listeAthleteParticipants.get(i).getNom() + " a gagné la compétition individuelle de " + this.getNom());
            }

            if (i == 1) {
                listeAthleteParticipants.get(i).getPays().ajouterArgent();
            }

            if (i == 2) {
                listeAthleteParticipants.get(i).getPays().ajouterBronze();
            }
        }
    }

    @Override
    public String toString() {
        return this.getNom() + " : [listeParticipants = " + listeAthleteParticipants + "]";
    }

    public List<Athlete> getListeAthleteParticipants() {
        return listeAthleteParticipants;
    }

    public void setListeAthleteParticipants(List<Athlete> listeAthleteParticipants) {
        this.listeAthleteParticipants = listeAthleteParticipants;
    }
}