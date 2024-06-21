package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnexionControleur {

    @FXML
    private TextField champNomUtilisateur;

    @FXML
    private PasswordField champMotDePasse;

    @FXML
    private void gererConnexion(ActionEvent event) {
        String nomUtilisateur = champNomUtilisateur.getText();
        String motDePasse = champMotDePasse.getText();

        if (nomUtilisateur.isEmpty() || motDePasse.isEmpty()) {
            afficherMessage("Erreur", "Veuillez remplir tous les champs.");
            return;
        }

        try (Connection conn = JDBC.getConnection()) {
            String sql = "SELECT role FROM Utilisateurs WHERE nomUtilisateur = ? AND motDePasse = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nomUtilisateur);
                pstmt.setString(2, motDePasse);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        String role = rs.getString("role");
                        chargerTableauDeBord(role);
                    } else {
                        afficherMessage("Erreur", "Nom d'utilisateur ou mot de passe incorrect.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            afficherMessage("Erreur", "Erreur de connexion à la base de données.");
        }
    }

    private void chargerTableauDeBord(String role) {
        String fichierFXML = "";
        switch (role) {
            case "administrateur":
                fichierFXML = "/main/TableauDeBordAdmin.fxml";
                break;
            case "journaliste":
                fichierFXML = "/main/TableauDeBordJournaliste.fxml";
                break;
            case "organisateur":
                fichierFXML = "/main/TableauDeBordOrganisateur.fxml";
                break;
            default:
                afficherMessage("Erreur", "Rôle inconnu.");
                return;
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource(fichierFXML));
            Stage stage = (Stage) champNomUtilisateur.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            afficherMessage("Erreur", "Impossible de charger le tableau de bord.");
        }
    }

    private void afficherMessage(String titre, String contenu) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(contenu);
        alert.showAndWait();
    }
}