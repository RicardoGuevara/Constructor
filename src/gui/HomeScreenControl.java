/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author AlguienMoreInAsus
 */
public class HomeScreenControl {
    
    GUILoader iLoader;
    
    @FXML
    private Button user_button;
    
    @FXML
    protected void letsGo(ActionEvent event) throws Exception{
    
        iLoader = new GUILoader("CoreProgram", "Core Program");
    }

}
