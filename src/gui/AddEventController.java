/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import htmlConstruction.EventType;
import htmlConstruction.FunctionType;
import htmlConstruction.EventType.*;
import htmlConstruction.FunctionType.*;
import htmlConstruction.HtmlComponent;
import htmlConstruction.HtmlConstruction;
import htmlConstruction.JsConstruction;
import htmlConstruction.JsEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import visuals.ProjectScreen;

/**
 *
 * @author RICARDO
 */
public class AddEventController {
    
    @FXML
    private Label titulo;
    
    @FXML
    private ComboBox    events,
                        functions;
    
    private HtmlComponent hc;
    
    @FXML
    public void initialize() 
    {
        titulo.setText(CoreProgramController.selectedLabel.getText());
        int id = HtmlConstruction.subsId(titulo.getText());
        hc= HtmlConstruction.searchId(id);
        
        events.getItems().addAll(EventType.values());
        functions.getItems().addAll(FunctionType.values());
    }
    
    @FXML
    protected void close()
    {
        OptionsController.primaryStage.close();
    }
    
    @FXML
    protected void addEvent()
    {
        
        JsEvent p= new JsEvent(determinarFuncion(), determinarEvento(),hc, null);
        JsConstruction.events.add(p);
        
        js.documentConstruction("Testorona");
        
        //añadir un reload del nuevo inspect
        
        //System.out.println(CoreProgramController.f.toURI().toString());
        
        close();
    }
    
    private JsConstruction js= new JsConstruction();
    
    private FunctionType determinarFuncion()
    {
        return (FunctionType) functions.getValue();
    }
    
    private EventType determinarEvento()
    {
        return (EventType) events.getValue();
    }
    
}
