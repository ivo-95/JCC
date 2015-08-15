package jcc.controllers;

import java.io.IOException;
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
        JCC.getStage().show();
    }

    @FXML
    private void signIn(ActionEvent event) throws IOException {
        if (!AppServices.verifyLogin(login_userName.getText(), login_password.getText())) {
            login_label.setText("Incorrect username or password.");
        } else {
            login_label.setText("");
            new LoginLoadController().openWindow();
        }
    }
}
