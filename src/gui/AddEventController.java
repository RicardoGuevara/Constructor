/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.fxml.FXML;

/**
 *
 * @author RICARDO
 */
public class AddEventController {
    
    @FXML
    public void initialize() 
    {
        
    }
    
    @FXML
    protected void close()
    {
        OptionsController.primaryStage.close();
    }
    
    @FXML
    protected void addEvent()
    {
    
        close();
    }
    
}