package main;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class TableauDeBordControleur {

    @FXML
    private void afficherCompetitions() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/main/Competitions.fxml"));
            // Charger la vue des compétitions
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}