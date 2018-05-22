/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import htmlConstruction.HtmlComponent;
import htmlConstruction.HtmlConstruction;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author RICARDO
 */
public class InfrmationController {
    
    
    @FXML
    private Label titulo;
    @FXML
    private TextField   texto,
                        ct,
                        estilo; 
    
    private HtmlComponent hc;
    
    @FXML
    public void initialize() 
    {
        titulo.setText(CoreProgramController.selectedLabel.getText());
        int id = HtmlConstruction.subsId(titulo.getText());
        hc= HtmlConstruction.searchId(id);
        
        texto.setText(hc.getInitialValue());
        ct.setText(hc.getType().name());
        
    }
    
    @FXML
    protected void close()
    {
        OptionsController.primaryStage.close();
    }
    
    
}
