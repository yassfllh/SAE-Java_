package main;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalControleur {
    @FXML
    private StackPane zoneDeContenu;

    @FXML
    private void gererQuitter() {
        System.exit(0);
    }

    @FXML
    private void afficherTableauDeBord() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/main/TableauDeBord.fxml"));
            zoneDeContenu.getChildren().setAll(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void afficherCompetitions() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/main/Competitions.fxml"));
            zoneDeContenu.getChildren().setAll(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}