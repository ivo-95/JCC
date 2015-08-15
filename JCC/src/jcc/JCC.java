/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcc;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import jcc.controllers.LoginController;

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
            new LoginController().openWindow();
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
