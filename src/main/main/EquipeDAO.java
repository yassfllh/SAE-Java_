package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO {

    public void ajouterEquipe(Equipe equipe) {
        String sql = "INSERT INTO Equipe (nomEquipe, nbOr, nbArgent, nbBronze, idPays) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, equipe.getNom());
            pstmt.setInt(2, equipe.getNbOr());
            pstmt.setInt(3, equipe.getNbArgent());
            pstmt.setInt(4, equipe.getNbBronze());
            pstmt.setString(5, equipe.getPays().getNom());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Equipe> getAllEquipes() {
        List<Equipe> equipes = new ArrayList<>();
        String sql = "SELECT * FROM Equipe";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String nom = rs.getString("nomEquipe");
                int nbOr = rs.getInt("nbOr");
                int nbArgent = rs.getInt("nbArgent");
                int nbBronze = rs.getInt("nbBronze");
                int idPays = rs.getInt("idPays");

                PaysDAO paysDAO = new PaysDAO();
                Pays pays = paysDAO.getPaysById(idPays);

                Equipe equipe = new Equipe(nom, nbOr, nbArgent, nbBronze, pays);
                equipe.setId(rs.getInt("idEquipe")); // set the ID if necessary
                equipes.add(equipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipes;
    }

    public Equipe getEquipeById(int id) {
        String sql = "SELECT * FROM Equipe WHERE idEquipe = ?";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nomEquipe");
                    int nbOr = rs.getInt("nbOr");
                    int nbArgent = rs.getInt("nbArgent");
                    int nbBronze = rs.getInt("nbBronze");
                    int idPays = rs.getInt("idPays");

                    PaysDAO paysDAO = new PaysDAO();
                    Pays pays = paysDAO.getPaysById(idPays);

                    Equipe equipe = new Equipe(nom, nbOr, nbArgent, nbBronze, pays);
                    equipe.setId(rs.getInt("idEquipe")); // set the ID if necessary
                    return equipe;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
