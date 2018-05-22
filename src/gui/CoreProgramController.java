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
import htmlconstructor.HtmlConstructor;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import htmlConstruction.ComponentSubType.*;
import htmlConstruction.ComponenType.*;
import java.awt.Event;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

/**
 *
 * @author AlguienMoreInAsus
 */
public class CoreProgramController {

    File f = new File("pagina.html");
    boolean destinyPaneActive = false;
    private double xOffset = 0;
    private double yOffset = 0;
    
    
    HtmlConstruction builder = new HtmlConstruction();
    ComponentSubType type = ComponentSubType.PARAGRAPH;
    
    @FXML
    private WebView wb;
    private WebEngine we;
    @FXML
    private Label testLabel;
    private Pane destinyPane;
    @FXML
    private VBox j;
    @FXML
    private TextField initial_val;
    @FXML
    private Spinner ancho,
                    alto;
    

    GUILoader iLoader;
    
    @FXML
    public void initialize() {

        we = wb.getEngine();
        we.load(f.toURI().toString());
        
        ancho.setDisable(true);
        alto.setDisable(true);
        
        
    }

    @FXML
    protected void test(ActionEvent event) {

        we = wb.getEngine();
        we.load(f.toURI().toString());
        System.out.println("LOADED?");

    }

    @FXML 
    protected void configureLB()
    {
        type = ComponentSubType.LINEBREAK;
        ancho.setDisable(true);
        alto.setDisable(true);
    }
    
    @FXML 
    protected void configureTB()
    {
        type = ComponentSubType.TEXTBOX;
        ancho.setDisable(false);
        alto.setDisable(false);
    }
    
    @FXML 
    protected void configureParagraph()
    {
        type = ComponentSubType.PARAGRAPH;
        ancho.setDisable(true);
        alto.setDisable(true);
    }
    
    @FXML 
    protected void configureButton()
    {
        type = ComponentSubType.BUTTON;
        ancho.setDisable(false);
        alto.setDisable(false);
    }
    
    @FXML 
    protected void addComp(ActionEvent event)
    {
        switch(type)
        {
            case PARAGRAPH:
                addParagraph2Document();
                break;
            case BUTTON:
                addButton2Document();
                break;
            case LINEBREAK:
                initial_val.setText("   ");
                addParagraph2Document();
                break;
            case TEXTBOX:
                addButton2Document();
                break;
        }
    }
    
    protected void addParagraph2Document() {
        HtmlComponent temporal = new HtmlComponent(ComponenType.OUTPUT, ComponentSubType.PARAGRAPH, initial_val.getText());
        HtmlConstruction.components.add(temporal);
        builder.DocumentConstruction("Testorona");
        //System.out.println(builder.getLink());
        addCompInDocView(temporal);
        f = new File (builder.getLink());
        we.load(f.toURI().toString());
    }
    
    protected void addButton2Document(){
        HtmlComponent temporal = new HtmlComponent(
                            ComponenType.INPUT, 
                            type, 
                            initial_val.getText(), 
                            200, 
                            500 );
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

    int x,y;
    
    @FXML
    protected void options()
    {
        System.out.println("SI FUNCIONA MK");
    }
    
    private void detect()
    {
        
    }
    
    @FXML
    protected void openDPane(ActionEvent event) {

        //destinyPane.set;
        destinyPane.setVisible(true);
    }

    @FXML
    protected void close(ActionEvent event) throws Exception
    {
        iLoader = new GUILoader("homescreen", "Home Screen");    
    }
    
}
