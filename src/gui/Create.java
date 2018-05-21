/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.CoreProgramController.addCompInDocView;
import static gui.CoreProgramController.f;
import htmlConstruction.ComponenType;
import htmlConstruction.ComponentSubType;
import htmlConstruction.HtmlComponent;
import htmlConstruction.HtmlConstruction;
import java.awt.event.ActionEvent;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author RICARDO
 */
public class Create {
    
    public static htmlConstruction.ComponentSubType type;
    private HtmlConstruction builder;
    
    @FXML
    private TextField initial_value;
    
    @FXML
    public void initialize() {
        
    }
    
    @FXML
    public void createComponent(ActionEvent event)
    {
        
    
    }
    
    @FXML
    protected void paragraph() {
        HtmlComponent temporal = new HtmlComponent(ComponenType.OUTPUT, ComponentSubType.PARAGRAPH, "Hello World!");
        HtmlConstruction.components.add(temporal);
        builder.DocumentConstruction("Testorona");
        //System.out.println(builder.getLink());
        CoreProgramController.addCompInDocView(temporal);
        CoreProgramController.f = new File (builder.getLink());
        CoreProgramController.we.load(f.toURI().toString());
        
        GUILoader.ps.close();
        
    }
    
    
}
