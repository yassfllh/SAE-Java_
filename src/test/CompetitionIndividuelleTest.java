package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.*;

public class CompetitionIndividuelleTest {

    @Test
    public void testAjouterAthlete() {
        Sport athletisme = new Athletisme(4);
        CompetitionIndividuelle competition = new CompetitionIndividuelle("100m", athletisme, "M");

        Pays france = Pays.factory("France");
        Athlete athlete = new Athlete("Doe", "John", "M", france, athletisme, 10, 10, 10);
        competition.ajouterAthlete(athlete);

        assertTrue(competition.getListeAthleteParticipants().contains(athlete));
    }

    @Test
    public void testStart() {
        Sport athletisme = new Athletisme(4);
        CompetitionIndividuelle competition = new CompetitionIndividuelle("100m", athletisme, "M");

        Pays france = Pays.factory("France");
        Athlete athlete1 = new Athlete("Doe", "John", "M", france, athletisme, 20, 20, 20);
        Athlete athlete2 = new Athlete("Smith", "Jane", "F", france, athletisme, 15, 15, 15);
        competition.ajouterAthlete(athlete1);
        competition.ajouterAthlete(athlete2);

        competition.start(competition.getListeAthleteParticipants(), athletisme);

        assertEquals(1, france.getNbOr());
        assertEquals(1, france.getNbArgent());
        assertEquals(0, france.getNbBronze());
    }
}