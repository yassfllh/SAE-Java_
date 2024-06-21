package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.*;

public class AthleteTest {

    @Test
    public void testAthleteCreation() {
        Pays france = Pays.factory("France");
        Sport athletisme = new Athletisme(4);
        Athlete athlete = new Athlete("Doe", "John", "M", france, athletisme, 10, 10, 10);

        assertEquals("Doe", athlete.getNom());
        assertEquals("John", athlete.getPrenom());
        assertEquals("M", athlete.getSexe());
        assertEquals(france, athlete.getPays());
        assertEquals(athletisme, athlete.getSport());
        assertEquals(10, athlete.getForce());
        assertEquals(10, athlete.getEndurance());
        assertEquals(10, athlete.getAgilite());
        assertEquals(30, athlete.statsAthlete());
    }

    @Test
    public void testEqualsAndHashCode() {
        Pays france = Pays.factory("France");
        Sport athletisme = new Athletisme(4);
        Athlete athlete1 = new Athlete("Doe", "John", "M", france, athletisme, 10, 10, 10);
        Athlete athlete2 = new Athlete("Doe", "John", "M", france, athletisme, 10, 10, 10);

        assertEquals(athlete1, athlete2);
        assertEquals(athlete1.hashCode(), athlete2.hashCode());
    }

    @Test
    public void testParticiper() {
        Pays france = Pays.factory("France");
        Sport athletisme = new Athletisme(4);
        Athlete athlete = new Athlete("Doe", "John", "M", france, athletisme, 10, 10, 10);

        athlete.partitiper();
        //
    }
}