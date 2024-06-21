package main;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class CompetitionsControleur {

    @FXML
    private void afficherTableauDeBord() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/main/TableauDeBord.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}