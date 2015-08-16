package jcc.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jcc.JCC;
import jcc.app_services.AppServices;

/**
 *
 * @author Ivo
 */
public class LoginController {
    @FXML
    private TextField login_userName;
    @FXML
    private PasswordField login_password;
    @FXML
    private CheckBox login_checkBox;
    @FXML
    private Button login_signIn;
    @FXML
    private Button login_register;
    @FXML
    private Label login_label;
    
    public void openWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/jcc/resources/Login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/jcc/resources/application.css").toExternalForm());
        JCC.getStage().setScene(scene);
        JCC.getStage().setWidth(400);
        JCC.getStage().setHeight(500);
        JCC.getStage().show();
    }

    @FXML
    private void signIn(ActionEvent event) throws IOException, FileNotFoundException {
        if (!AppServices.verifyLogin(login_userName.getText(), login_password.getText())) {
            login_label.setText("Incorrect username or password.");
        } else {
            login_label.setText("");
            if (login_checkBox.selectedProperty().getValue()) {
                AppServices.writeCredentials(login_userName.getText(), login_password.getText());
            } else {
                AppServices.resetFile();
            }
            new LoginLoadController().openWindow();
        }
    }
}
