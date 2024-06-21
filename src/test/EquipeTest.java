package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.*;

public class EquipeTest {

    @Test
    public void testEquipeCreation() {
        Pays france = Pays.factory("France");
        Sport athletisme = new Athletisme(4);
        Equipe equipe = new Equipe("Equipe A", france, athletisme);

        assertEquals("Equipe A", equipe.getNom());
        assertEquals(france, equipe.getPays());
        assertTrue(equipe.getEquipe().isEmpty());
    }

    @Test
    public void testAjouterAthlete() {
        Pays france = Pays.factory("France");
        Sport athletisme = new Athletisme(4);
        Equipe equipe = new Equipe("Equipe A", france, athletisme);
        Athlete athlete = new Athlete("Doe", "John", "M", france, athletisme, 10, 10, 10);
        
        equipe.ajouterAthlete(athlete);

        assertTrue(equipe.getEquipe().contains(athlete));
    }

    @Test
    public void testParticiper() {
        Pays france = Pays.factory("France");
        Sport athletisme = new Athletisme(4);
        Equipe equipe = new Equipe("Equipe A", france, athletisme);
        Athlete athlete = new Athlete("Doe", "John", "M", france, athletisme, 10, 10, 10);
        
        equipe.ajouterAthlete(athlete);
        equipe.partitiper();
    }
}
