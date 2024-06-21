package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationPrincipale extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/Connexion.fxml"));
            Parent root = loader.load();
    
            primaryStage.setTitle("Application JO");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erreur de chargement" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}