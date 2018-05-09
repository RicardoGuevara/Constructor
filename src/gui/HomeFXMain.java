/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Clase creada para mostrar la pantalla de inicio.
 * 
 * Menospreciada, use ahora la GUILoader
 *
 * @deprecated 
 * @author josem
 */
public class HomeFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       Parent scene = FXMLLoader.load(getClass().getResource("/gui/homescreen.fxml"));
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(scene));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    
}
