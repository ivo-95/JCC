package jcc.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import jcc.JCC;
import jcc.app_services.AppServices;

/**
 *
 * @author Ivo
 */
public class LoginLoadController {

    public void openWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/jcc/resources/Login_load.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/jcc/resources/application.css").toExternalForm());
        JCC.getStage().setScene(scene);
    }
    
    @FXML
    private void cancelSignIn(ActionEvent event) throws IOException {
        AppServices.resetFile();
        new LoginController().openWindow();
    }
}
