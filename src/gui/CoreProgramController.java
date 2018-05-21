/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import htmlConstruction.ComponenType;
import htmlConstruction.ComponentSubType;
import htmlConstruction.HtmlComponent;
import htmlConstruction.HtmlConstruction;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author AlguienMoreInAsus
 */
public class CoreProgramController {

    File f = new File("pagina.html");
    boolean destinyPaneActive = false;

    HtmlConstruction builder = new HtmlConstruction();

    @FXML
    private WebView wb;
    private WebEngine we;
    @FXML
    private Label testLabel;
    private Pane destinyPane;
    @FXML
    private VBox j;
    

    @FXML
    public void initialize() {

        we = wb.getEngine();
        we.load(f.toURI().toString());
    }

    @FXML
    protected void test(ActionEvent event) {

        we = wb.getEngine();
        we.load(f.toURI().toString());
        System.out.println("LOADED?");

    }

    @FXML
    protected void addParagraph2Document() {
        HtmlComponent temporal = new HtmlComponent(ComponenType.OUTPUT, ComponentSubType.PARAGRAPH, "Hello World!");
        HtmlConstruction.components.add(temporal);
        builder.DocumentConstruction("Testorona");
        //System.out.println(builder.getLink());
        addCompInDocView(temporal);
        f = new File (builder.getLink());
        we.load(f.toURI().toString());
    }
    
    @FXML
    protected void addButton2Document(){
        HtmlComponent temporal = new HtmlComponent(
                            ComponenType.INPUT, 
                            ComponentSubType.BUTTON, 
                            "Boton de prueba", 
                            300, 
                            200 );
        HtmlConstruction.components.add(temporal);
        builder.DocumentConstruction("Testorona");
        //System.out.println(builder.getLink());
        addCompInDocView(temporal);
        f = new File (builder.getLink());
        we.load(f.toURI().toString());
    }

    //@FXML
    protected void addCompInDocView(HtmlComponent base) {
        System.out.println("Doc List: "+" "+base.getLabelNum()+" "+base.getType());
        Label labelnew = new Label(" "+base.getLabelNum()+" "+base.getType());
        j.getChildren().add(labelnew);
    }

    @FXML
    protected void openDPane(ActionEvent event) {

        //destinyPane.set;
        destinyPane.setVisible(true);
    }

}
