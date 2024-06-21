package test;

import main.AthleteDAO;
import main.Athlete;
import main.Pays;
import main.JDBC;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class AthleteDAOTest {
    @Test
    public void testAjouterAthlete() {
        // Création d'un objet Pays
        Pays bresil = new Pays("Brésil");

        // Création d'un objet Athlete
        Athlete athlete = new Athlete("Liu", "Jun", "F", 7, 13, 9, bresil);

        // Ajout de l'athlète à la base de données
        AthleteDAO athleteDAO = new AthleteDAO();
        athleteDAO.ajouterAthlete(athlete);

        // Vérification de l'insertion
        Athlete athleteFromDb = getAthleteFromDatabase(athlete.getNom(), athlete.getPrenom());
        assertNotNull(athleteFromDb);
        assertEquals(athlete.getNom(), athleteFromDb.getNom());
        assertEquals(athlete.getPrenom(), athleteFromDb.getPrenom());
        assertEquals(athlete.getSexe(), athleteFromDb.getSexe());
        assertEquals(athlete.getForce(), athleteFromDb.getForce());
        assertEquals(athlete.getEndurance(), athleteFromDb.getEndurance());
        assertEquals(athlete.getAgilite(), athleteFromDb.getAgilite());
        assertEquals(athlete.getPays().getNom(), athleteFromDb.getPays().getNom());
    }

    private Athlete getAthleteFromDatabase(String nom, String prenom) {
        String sql = "SELECT A.nomA, A.prenomA, A.sexeA, A.forceA, A.enduranceA, A.agiliteA, P.nomPays " +
                     "FROM Athlete A JOIN Pays P ON A.idPays = P.idPays " +
                     "WHERE A.nomA = ? AND A.prenomA = ?";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nomA = rs.getString("nomA");
                    String prenomA = rs.getString("prenomA");
                    String sexeA = rs.getString("sexeA");
                    int forceA = rs.getInt("forceA");
                    int enduranceA = rs.getInt("enduranceA");
                    int agiliteA = rs.getInt("agiliteA");
                    String nomPays = rs.getString("nomPays");

                    Pays pays = new Pays(nomPays);
                    return new Athlete(nomA, prenomA, sexeA, forceA, enduranceA, agiliteA, pays);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retourne null en cas de non-trouvaille
    }
}
