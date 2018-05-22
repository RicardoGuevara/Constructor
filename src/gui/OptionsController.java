/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author RICARDO
 */
public class OptionsController {
    
    static double x,y;
    
    @FXML
    Pane pane;
    
    
    @FXML
    public void initialize() 
    {
        
    }
    
    double xOffset,yOffset;
            
    public static Stage primaryStage;
    
    @FXML
    protected void close()
    {
        CoreProgramController.primaryStage.close();
    }
    
    @FXML
    private void newEvent() throws IOException
    {
        primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("/gui/AddEvent.fxml"));

        root.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        primaryStage.setTitle("Agregar evento");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        close();
        
    }
    
    @FXML
    private void showInformation() throws IOException
    {
        primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Informacion.fxml"));

        root.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        primaryStage.setTitle("Información");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        close();
    }
    
    
    
}
