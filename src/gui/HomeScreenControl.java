/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import htmlconstructor.HtmlConstructor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 *
 * @author AlguienMoreInAsus
 */
public class HomeScreenControl{
    
    GUILoader iLoader;
    
    @FXML
    private Button user_button;
    
    @FXML
    private Label new_project;
    
    
    @FXML
    protected void closeSec(ActionEvent event) throws Exception
    {
        iLoader = new GUILoader("Login", "log in");
        HtmlConstructor.user = new String();
        //System.out.println("cierre de seción");
    }
    
    @FXML
    protected void newProject() throws Exception
    {
        iLoader = new GUILoader("CoreProgram", "Core Program");   
    }
    
    
}
