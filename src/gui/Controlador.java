/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import htmlconstructor.HtmlConstructor;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author AlguienMoreInAsus
 */
public class Controlador {

    @FXML
    private TextField usuario_field;
    @FXML
    private PasswordField passwd_field;
    @FXML
    private Button  login_button,
                    register_button;
    @FXML
    private Rectangle circleImage;
    private Pane rootPane;

    GUILoader iLoader;

    @FXML
    public void initialize() {
        Image im = new Image("/gui/assets/Logorick.png", false);
        circleImage.setFill(new ImagePattern(im));
        //rootPane.setEffect(new DropShadow(+25d, 0d, +2d, Color.CORAL));

    }

    @FXML
    protected void helloWorldTest(ActionEvent event) throws IOException, Throwable {
        
        /*
        System.out.println("HOELELEL");
        usuario_field.setText("HOLI");
        
        iLoader = new GUILoader("homescreen", "Home Screen");
        
        //        iLoader.main(new String[100],"homescreen", "SAVEMEPLS");
        */
    
    // pruebas de rick v:    
        
        //System.out.println(((Button)event.getSource()).getText());
        
        System.out.println("anything");
    }

    @FXML
    protected void ingreso(ActionEvent event)
            throws Exception
    {
        if(HtmlConstructor.log(usuario_field.getText(), passwd_field.getText()))
        {
            iLoader = new GUILoader("homescreen", "Home Screen");
            HtmlConstructor.user = usuario_field.getText();
            System.out.println("ingreso de usuario: "+usuario_field.getText());
        }
        else
        {
        Alert exito = new Alert(Alert.AlertType.ERROR,"error de inicio de secion");
        exito.showAndWait();
        }
    }

    @FXML
    protected void registro(ActionEvent event)
    {
        HtmlConstructor.registrar(usuario_field.getText(), passwd_field.getText());
    }
    
    @FXML
    protected void cerrar(ActionEvent event)
    {
        System.exit(0);
    }
    
    
}
