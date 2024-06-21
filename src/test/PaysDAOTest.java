package test;

import main.PaysDAO;
import main.Pays;
import main.JDBC;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.*;

public class PaysDAOTest {
    @Test
    public void testAjouterPays() {
        // Création d'un objet Pays
        Pays chine = new Pays("Chine");

        // Ajout du pays à la base de données
        PaysDAO paysDAO = new PaysDAO();
        paysDAO.ajouterPays(chine);

        // Vérification de l'insertion
        Pays paysFromDb = getPaysFromDatabase(chine.getNom());
        assertNotNull(paysFromDb);
        assertEquals(chine.getNom(), paysFromDb.getNom());
    }

    private Pays getPaysFromDatabase(String nom) {
        String sql = "SELECT nomPays FROM Pays WHERE nomPays = ?";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Pays(rs.getString("nomPays"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retourne null en cas de non-trouvaille
    }
}