package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.*;

public class EpreuveTest {

    @Test
    public void testEpreuveCreation() {
        Sport athletisme = new Athletisme(4);
        Epreuve epreuve = new CompetitionIndividuelle("100m", athletisme, "M");

        assertEquals("100m", epreuve.getNom());
        assertEquals(athletisme, epreuve.getSport());
        assertEquals("M", epreuve.getSexe());
    }
}
