/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import htmlconstructor.HtmlConstructor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Clase encargada de cargar Fxmls encontrados en el paquete GUI
 *
 *
 * @author AlguienMoreInAsus
 */
public class GUILoader extends Application {

    private String fxml;
    private String titulo;
    GUILoader lel;

    private double xOffset = 0;
    private double yOffset = 0;

    public static Stage ps=HtmlConstructor.actlog;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("/gui/" + fxml + ".fxml"));

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        primaryStage.setTitle(titulo);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        ps= primaryStage;

    }

    public GUILoader(String fxml, String titulo, boolean change) throws Exception {
        this.fxml = fxml;
        this.titulo = titulo;

        start(new Stage());
        
        if(change)
        {
            HtmlConstructor.antlog = HtmlConstructor.actlog;
            HtmlConstructor.actlog = ps;
            HtmlConstructor.antlog.close();
        }
        
    }
    
    public GUILoader(String fxml, String titulo) throws Exception {
        this.fxml = fxml;
        this.titulo = titulo;

        start(new Stage());
        
            HtmlConstructor.antlog = HtmlConstructor.actlog;
            HtmlConstructor.actlog = ps;
            HtmlConstructor.antlog.close();
        
        
    }
    
}
