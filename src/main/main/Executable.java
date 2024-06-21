package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Executable {
    public static <CSVReader> void main(String[] args) throws IOException {

        // JO
        JeuxOlympiques joParis2024 = new JeuxOlympiques();

        // Charger données csv
        String fileName = "donnees.csv";
        String line = " ";


        List<Equipe> listEq = new ArrayList<>();
        List<CompetitionIndividuelle> listecompind = new ArrayList<>();
        List<CompetitionCollective> listecompcoll = new ArrayList<>();

        // lecture du fichier csv
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // ignore 1ere ligne
            br.readLine();

            // charge les données
            while((line = br.readLine()) != null) {
                String[] splitedString = line.split(",");
                Pays p = Pays.factory(splitedString[3]);
                Sport sp = Sport.factory(splitedString[4].split(" ")[0]);
                String epreuve = splitedString[4];

                // création des athlètes
                Athlete athlete = new Athlete(splitedString[0], splitedString[1], splitedString[2], p, sp, Integer.parseInt(splitedString[5]), Integer.parseInt(splitedString[6]), Integer.parseInt(splitedString[7]));
                joParis2024.ajouterAthlete(athlete);
                joParis2024.ajouterPays(p);

                // création des équipes
                Equipe ekip = new Equipe("equipe" + p.getNom(), p, sp);
                if (!listEq.contains(ekip)) {
                    ekip.ajouterAthlete(athlete);
                    listEq.add(ekip);
                }
                else {
                    listEq.get(listEq.indexOf(ekip)).ajouterAthlete(athlete);
                }
                

                // création des compétitions
                if (epreuve.contains("relais") || epreuve.toUpperCase().contains("ball".toUpperCase())) {
                    CompetitionCollective competitionCollective = new CompetitionCollective(splitedString[4], sp, splitedString[2]);
                    if (!listecompcoll.contains(competitionCollective)) {listecompcoll.add(competitionCollective);}
                } else {
                    CompetitionIndividuelle competitionIndividuelle = new CompetitionIndividuelle(splitedString[4], sp, splitedString[2]);
                    if (!listecompind.contains(competitionIndividuelle)) {listecompind.add(competitionIndividuelle);}
                }
            }

            // ajout des équipes dans des épreuves collectives
            for (Equipe ekip : listEq) {
                for (CompetitionCollective compcoll : listecompcoll) {
                    if (ekip.getSport().equals(compcoll.getSport())) {
                        compcoll.ajouterEquipe(ekip);
                    }
                }
            }

            // ajout des équipes dans des épreuves individuelles
            for (Athlete athlete : joParis2024.getListeAthletes()) {
                for (CompetitionIndividuelle compind : listecompind) {
                    if (athlete.getSport().equals(compind.getSport())) {
                        compind.ajouterAthlete(athlete);
                    }
                }
            }

            // ajout des épreuves collectives aux JO
            for (CompetitionCollective compcoll : listecompcoll) {
                joParis2024.ajouterEpreuve(compcoll);
            }

            // ajout des épreuves individuelles aux JO
            for (CompetitionIndividuelle compind : listecompind) {
                joParis2024.ajouterEpreuve(compind);
            }

            // lancement compétition et attribution des médailles
            for (int i = 0 ; i < joParis2024.getListeEpreuves().size() ; i++) {
                try {
                    CompetitionCollective actu = (CompetitionCollective) joParis2024.getListeEpreuves().get(i);
                    actu.start(actu.getEquipesParticipantes(), actu.getSport());
                } catch (Exception e) {
                    CompetitionIndividuelle actu = (CompetitionIndividuelle) joParis2024.getListeEpreuves().get(i);
                    actu.start(actu.getListeAthleteParticipants(), actu.getSport());
                }
            }

            // affiche le classement des pays par nombre de médailles obtenues
            System.out.println("\n============================ Classement des pays par nombre de médailles obtenues ============================\n");
            System.out.println(joParis2024.classementPays());
            System.out.println("\n==============================================================================================================\n");



        } catch(FileNotFoundException e) {
            new FileNotFoundException("Fichier non trouvé");
        }









        // Sports
        // Natation natation = new Natation();
        // // Sport escrime = new Sport("Escrime") {};
        // // Sport volleyBall = new Sport("Volley-Ball") {};
        // // Sport handball = new Sport("Handball") {};
        // // Sport athletisme = new Sport("Athlétisme") {};

        // // Pays
        // Pays france = new Pays("France");
        // Pays usa = new Pays("USA");


        // // Athletes
        // Athlete saito = new Athlete(natation, france, "Saito", "Haruto", "F", 13, 13, 7);
        // Athlete roux = new Athlete(natation, france, "Roux", "Raphaël", "F", 17, 15, 20);
        // Athlete huang = new Athlete(natation, france, "Huang", "Yan", "M", 19, 16, 11);
        // Athlete huang2 = new Athlete(natation, france, "Huang", "Yann", "M", 19, 16, 11);

        // Athlete huang3 = new Athlete(natation, usa, "Huang", "Yan", "M", 19, 16, 90);
        // Athlete huang4 = new Athlete(natation, usa, "Huang", "Yan", "M", 19, 16, 18);
        // Athlete huang5 = new Athlete(natation, usa, "Huang", "Yan", "M", 19, 16, 17);
        // Athlete huang6 = new Athlete(natation, usa, "Huang", "Yan", "M", 19, 16, 22);

        // // Natation
        // Natation n = new Natation();
        // CompetitionIndividuelle competnatationind = new CompetitionIndividuelle("Natation 100 brasse", n, "M");
        // competnatationind.ajouterAthlete(saito);
        // competnatationind.ajouterAthlete(roux);
        // competnatationind.ajouterAthlete(huang);
        // competnatationind.ajouterAthlete(huang2);
        // System.out.println(competnatationind);
        // System.out.println("Classement des Athlètes:");
        // competnatationind.start(competnatationind.getListeAthleteParticipants(), n);
        // System.out.println(competnatationind);


        // CompetitionCollective competnatationcoll = new CompetitionCollective("Natation relais libre", n, "M");
        // Equipe equipe1 = new Equipe("equipe1", france);
        // equipe1.ajouterAthlete(saito);
        // equipe1.ajouterAthlete(roux);
        // equipe1.ajouterAthlete(huang);
        // equipe1.ajouterAthlete(huang2);

        // Equipe equipe2 = new Equipe("equipe2", usa);
        // equipe2.ajouterAthlete(huang3);
        // equipe2.ajouterAthlete(huang4);
        // equipe2.ajouterAthlete(huang5);
        // equipe2.ajouterAthlete(huang6);
        // competnatationcoll.ajouterEquipe(equipe1);
        // competnatationcoll.ajouterEquipe(equipe2);

        // System.out.println(competnatationcoll);
        // System.out.println("Classement des équipes :");
        // competnatationcoll.start(competnatationcoll.getEquipesParticipantes(), n);
        // System.out.println(competnatationcoll);

        // // JO
        // JeuxOlympiques joTokyo = new JeuxOlympiques();
        // joTokyo.ajouterPays(france);
        // joTokyo.ajouterPays(usa);
        // joTokyo.ajouterEpreuve(competnatationcoll);
        // joTokyo.ajouterEpreuve(competnatationind);

        // System.out.println((joTokyo.classementPays()));
    }
}