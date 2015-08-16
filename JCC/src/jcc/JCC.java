/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import jcc.app_services.AppServices;
import jcc.controllers.LoginController;
import jcc.controllers.LoginLoadController;

/**
 *
 * @author Ivo
 */
public class JCC extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        try {
            setStage(primaryStage);

            try {
                String credentials = AppServices.readFile();
                if (credentials != null && AppServices.isUserRemembered(credentials)) {
                    stage.setWidth(400);
                    stage.setHeight(500);
                    new LoginLoadController().openWindow();
                    stage.show();
                } else {
                    new LoginController().openWindow();
                }
            } catch (FileNotFoundException e) {
                AppServices.resetFile();
                new LoginController().openWindow();
            }

        } catch (IOException ex) {
            Logger.getLogger(JCC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setStage(Stage _stage) {
        stage = _stage;
        stage.setTitle("JCC");
        stage.setResizable(false);
    }

    public static Stage getStage() {
        return stage;
    }
}
