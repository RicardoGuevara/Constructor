/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author AlguienMoreInAsus
 */
public class CoreProgramController {

    File f = new File("C:\\Users\\josem\\Documents\\Proyectos\\Testin' grounds\\HTML\\Untitled-1.html");
    @FXML
    private WebView wb;
    private WebEngine we;
    private Label testLabel;
    
    @FXML
    protected void test(ActionEvent event){
        
         we = wb.getEngine();
        we.load(f.toURI().toString());
        System.out.println("LOADED?");
        
    }
    
    @FXML
    protected void testLabel(){
        
        
        
    }
    
    
    
}
