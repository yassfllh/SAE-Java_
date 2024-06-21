package main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class ConnexionControleur {
    @FXML
    private TextField champNomUtilisateur;
    @FXML
    private PasswordField champMotDePasse;
    @FXML
    private Label erreurLabel;

    @FXML
    private void gererConnexion(ActionEvent event) {
        String nomUtilisateur = champNomUtilisateur.getText();
        String motDePasse = champMotDePasse.getText();
        
        // Logique de connexion simplifiée
        if (nomUtilisateur.equals("admin") && motDePasse.equals("admin")) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/main/Principal.fxml"));
                Stage stage = (Stage) champNomUtilisateur.getScene().getWindow();
                stage.setScene(new Scene(root, 800, 600));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            erreurLabel.setText("Nom d'utilisateur ou mot de passe incorrect.");
        }
    }
}