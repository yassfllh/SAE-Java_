package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.*;

public class JeuxOlympiquesTest {

    @Test
    public void testAjouterPays() {
        JeuxOlympiques jo = new JeuxOlympiques();
        Pays france = Pays.factory("France");

        jo.ajouterPays(france);
        assertTrue(jo.getListePaysParticipants().contains(france));
    }

    @Test
    public void testAjouterEpreuve() {
        JeuxOlympiques jo = new JeuxOlympiques();
        Sport athletisme = new Athletisme(4);
        CompetitionIndividuelle epreuve = new CompetitionIndividuelle("100m", athletisme, "M");

        jo.ajouterEpreuve(epreuve);
        assertTrue(jo.getListeEpreuves().contains(epreuve));
    }

    @Test
    public void testAjouterAthlete() {
        JeuxOlympiques jo = new JeuxOlympiques();
        Sport athletisme = new Athletisme(4);
        Pays france = Pays.factory("France");
        Athlete athlete = new Athlete("Doe", "John", "M", france, athletisme, 10, 10, 10);

        jo.ajouterAthlete(athlete);
        assertTrue(jo.getListeAthletes().contains(athlete));
    }
}
