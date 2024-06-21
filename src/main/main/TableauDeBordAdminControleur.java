package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TableauDeBordAdminControleur {
    @FXML
    private BorderPane borderPane;

    @FXML
    public void gererUtilisateurs(ActionEvent event) {
        afficherMessage("Gérer Utilisateurs", "Gestion des utilisateurs en cours...");
    }

    @FXML
    public void voirStatistiques(ActionEvent event) {
        afficherMessage("Voir Statistiques", "Affichage des statistiques en cours...");
    }

    @FXML
    public void deconnexion(ActionEvent event) {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/main/Connexion.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
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
