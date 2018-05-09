/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author AlguienMoreInAsus
 */
public class Controlador {

    @FXML
    private TextField usuario_field;
    //private PasswordField passwd_field;
    private Button login_button;
    //private Button register_button;
    @FXML
    private Circle circleImage;
    private Pane rootPane;

    GUILoader iLoader;

    @FXML
    public void initialize() {
        Image im = new Image("http://via.placeholder.com/200x200", false);
        circleImage.setFill(new ImagePattern(im));
        //rootPane.setEffect(new DropShadow(+25d, 0d, +2d, Color.CORAL));

    }

    @FXML
    protected void helloWorldTest(ActionEvent event) throws IOException, Throwable {
        System.out.println("HOELELEL");
        usuario_field.setText("HOLI");

        iLoader = new GUILoader("homescreen", "Home Screen");

//        iLoader.main(new String[100],"homescreen", "SAVEMEPLS");
    }
}
