package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.*;

public class PaysTest {

    @Test
    public void testPaysFactory() {
        Pays france = Pays.factory("France");
        assertNotNull(france);
        assertEquals("France", france.getNom());
    }

    @Test
    public void testMedaille() {
        //
        Pays france = new Pays("France");
        france.resetMedals();
        france.ajouterOr();
        france.ajouterArgent();
        france.ajouterBronze();

        assertEquals(1, france.getNbOr());
        assertEquals(1, france.getNbArgent());
        assertEquals(1, france.getNbBronze());
    }
}