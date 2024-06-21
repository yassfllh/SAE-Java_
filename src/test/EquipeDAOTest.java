package test;

import main.EquipeDAO;
import main.Equipe;
import main.Pays;
import main.JDBC;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class EquipeDAOTest {
    @Test
    public void testAjouterEquipe() {
        // Création d'un objet Pays
        Pays france = new Pays("France");

        // Création d'un objet Equipe
        Equipe equipe = new Equipe("Equipe A", 2, 1, 0, france);

        // Ajout de l'équipe à la base de données
        EquipeDAO equipeDAO = new EquipeDAO();
        equipeDAO.ajouterEquipe(equipe);

        // Vérification de l'insertion
        Equipe equipeFromDb = getEquipeFromDatabase(equipe.getNom());
        assertNotNull(equipeFromDb);
        assertEquals(equipe.getNom(), equipeFromDb.getNom());
        assertEquals(equipe.getNbOr(), equipeFromDb.getNbOr());
        assertEquals(equipe.getNbArgent(), equipeFromDb.getNbArgent());
        assertEquals(equipe.getNbBronze(), equipeFromDb.getNbBronze());
        assertEquals(equipe.getPays().getNom(), equipeFromDb.getPays().getNom());
    }

    private Equipe getEquipeFromDatabase(String nom) {
        String sql = "SELECT E.nomEquipe, E.nbOr, E.nbArgent, E.nbBronze, P.nomPays " +
                     "FROM Equipe E JOIN Pays P ON E.idPays = P.idPays " +
                     "WHERE E.nomEquipe = ?";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nomEquipe = rs.getString("nomEquipe");
                    int nbOr = rs.getInt("nbOr");
                    int nbArgent = rs.getInt("nbArgent");
                    int nbBronze = rs.getInt("nbBronze");
                    String nomPays = rs.getString("nomPays");

                    Pays pays = new Pays(nomPays);
                    return new Equipe(nomEquipe, nbOr, nbArgent, nbBronze, pays);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retourne null en cas de non-trouvaille
    }

    @Test
    public void testGetAllEquipes() {
        EquipeDAO equipeDAO = new EquipeDAO();
        List<Equipe> equipes = equipeDAO.getAllEquipes();
        assertNotNull(equipes);
        assertTrue(equipes.size() > 0); // Assurez-vous qu'il y a au moins une équipe dans la base de données
    }
}
