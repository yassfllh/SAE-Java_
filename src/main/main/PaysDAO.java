package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaysDAO {

    public void ajouterPays(Pays pays) {
        String sql = "INSERT INTO Pays (nomPays) VALUES (?)";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pays.getNom());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pays getPaysByName(String nom) {
        String sql = "SELECT * FROM Pays WHERE nomPays = ?";
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
        return null;
    }

    public Pays getPaysById(int id) {
        String sql = "SELECT * FROM Pays WHERE idPays = ?";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Pays(rs.getString("nomPays"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}