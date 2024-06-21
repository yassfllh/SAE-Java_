package test;

import org.junit.Test;
import static org.junit.Assert.*;

import main.*;

public class CompetitionCollectiveTest {

    @Test
    public void testAjouterEquipe() {
        Sport athletisme = new Athletisme(4);
        CompetitionCollective competition = new CompetitionCollective("4x100m Relay", athletisme, "M");

        Pays france = Pays.factory("France");
        Equipe equipe = new Equipe("Equipe A", france, athletisme);
        competition.ajouterEquipe(equipe);

        assertTrue(competition.getEquipesParticipantes().contains(equipe));
    }
}
