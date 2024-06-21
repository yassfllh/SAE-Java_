package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AthleteDAO {
    public void ajouterAthlete(Athlete athlete) {
        String sql = "INSERT INTO Athlete (nomA, prenomA, sexeA, forceA, enduranceA, agiliteA, idPays) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, athlete.getNom());
            pstmt.setString(2, athlete.getPrenom());
            pstmt.setString(3, athlete.getSexe());
            pstmt.setInt(4, athlete.getForce());
            pstmt.setInt(5, athlete.getEndurance());
            pstmt.setInt(6, athlete.getAgilite());
            pstmt.setString(7, athlete.getPays().getNom());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
