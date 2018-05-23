/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import mail.Upload;

import static gui.OptionsController.primaryStage;
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
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mail.MailModel;
import mail.MailService;
import static visuals.ProjectScreen.title;

/**
 *
 * @author AlguienMoreInAsus
 */
public class CoreProgramController {

    public static File f = new File("pagina.html");
    boolean destinyPaneActive = false;
    private double xOffset = 0;
    private double yOffset = 0;

    Upload upper;

    public static HtmlConstruction builder = new HtmlConstruction();
    ComponentSubType type = ComponentSubType.PARAGRAPH;

    GUILoader iLoader;

    @FXML
    private WebView wb;
    private WebEngine we;
    @FXML
    private Label testLabel,titulo;
    public static Label selectedLabel;
    private Pane destinyPane;
    @FXML
    private VBox j;
    @FXML
    private TextField initial_val,style,rut;
    @FXML
    private Spinner ancho,
                    alto;
    
    @FXML
    private TextArea ht,js;
    
    
    
    @FXML
    public void initialize() {

        we = wb.getEngine();
        we.load(f.toURI().toString());

        ancho.setDisable(true);
        alto.setDisable(true);
        /*
        j.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent event) {
        try
        {
        
        System.out.println(event.getSource().getClass());
        }
        catch (Exception e)
        {
        System.out.println("not a button");
        }
        
        
        }
        });
        */
    }

    @FXML
    protected void test(ActionEvent event) {

        we = wb.getEngine();
        we.load(f.toURI().toString());
        System.out.println("LOADED?");

    }

    @FXML
    protected void configureLB() {
        titulo.setText("Texto inicial:");
        initial_val.setDisable(true);        
        type = ComponentSubType.LINEBREAK;
        ancho.setDisable(true);
        alto.setDisable(true);
    }

    @FXML
    protected void configureTB() {
        titulo.setText("Texto inicial:");
        initial_val.setDisable(false);
        type = ComponentSubType.TEXTBOX;
        ancho.setDisable(false);
        alto.setDisable(false);
    }

    @FXML
    protected void configureParagraph() {
        titulo.setText("Texto inicial:");
        initial_val.setDisable(false);
        type = ComponentSubType.PARAGRAPH;
        ancho.setDisable(true);
        alto.setDisable(true);
    }

    @FXML
    protected void configureButton() {
        titulo.setText("Texto inicial:");
        initial_val.setDisable(false);
        type = ComponentSubType.BUTTON;
        ancho.setDisable(false);
        alto.setDisable(false);
    }

    
    @FXML
    protected void configureImg() {
        titulo.setText("Ruta de la imagenn:");
        initial_val.setDisable(false);
        type = ComponentSubType.IMG;
        ancho.setDisable(false);
        alto.setDisable(false);
    }
    
    
    @FXML
    protected void configureCanvas() {
        titulo.setText("Texto inicial:");
        initial_val.setDisable(true);
        type = ComponentSubType.CANVAS;
        ancho.setDisable(false);
        alto.setDisable(false);
    }
    
    
    @FXML
    protected void addComp(ActionEvent event) {
        switch (type) {
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
            case IMG:
                addButton2Document();
                break;
            case CANVAS:
                addButton2Document();
                break;
        }
        
        try 
        {
            reloadInspectHtml();
            reloadInspectJs();
        }
        catch (Exception e) 
        {
            System.out.println("no fue posible recargar los ducumentos");
        }
    }
    @FXML
    protected void addParagraph2Document() {
        HtmlComponent temporal = new HtmlComponent(ComponenType.OUTPUT, type, initial_val.getText(),style.getText());
        HtmlConstruction.components.add(temporal);
        builder.DocumentConstruction("Testorona");
        //System.out.println(builder.getLink());
        addCompInDocView(temporal);
        f = new File(builder.getLink());
        we.load(f.toURI().toString());
    }

    protected void addButton2Document() {
        HtmlComponent temporal = new HtmlComponent(
                ComponenType.INPUT,
                type,
                initial_val.getText(),
                Integer.parseInt(ancho.getEditor().getText()),
                Integer.parseInt(alto.getEditor().getText()),style.getText());
        HtmlConstruction.components.add(temporal);
        builder.DocumentConstruction("Testorona");
        //System.out.println(builder.getLink());
        addCompInDocView(temporal);
        f = new File(builder.getLink());
        we.load(f.toURI().toString());
        System.out.println(f.toURI().toString());
        rut.setText(f.toURI().toString());
    }

    //@FXML
    protected void addCompInDocView(HtmlComponent base) {
        System.out.println("Doc List: "+" "+base.getLabelNum()+" "+base.getType());
        Label labelnew = new Label(" "+base.getLabelNum()+" "+base.getType());
        
        labelnew.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                try
                {
                    selectedLabel = labelnew;
                }
                catch (Exception e)
                {
                    System.out.println("not a label");
                }
            }
        });
        
        j.getChildren().add(labelnew);
    }

    static Stage primaryStage;
    
    @FXML
    public void options() throws IOException
    {
        Point locacion = MouseInfo.getPointerInfo().getLocation();
        //System.out.println(selectedLabel.getText());
        
        OptionsController.x = locacion.x;
        OptionsController.y = locacion.y;
        
        
        
        primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Options.fxml"));

        root.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        primaryStage.setTitle("Opciones");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void detect() {

    }

    @FXML
    protected void uploadTest(ActionEvent event) {

        try {
            upper = new Upload("ftp.alguienmore.com", "alguienmore.com", "2be548dd514c");
            upper.inUpload("index.html");
            upper = new Upload("ftp.alguienmore.com", "alguienmore.com", "2be548dd514c");
            upper.inUpload("Testorona.js");
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Proyecto subido con éxito");
            a.showAndWait();
        } catch (Exception e) 
        {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"No fué posible subir el proyecto");
            a.showAndWait();
        }

    }
    @FXML
    protected void  checkNames(ActionEvent event){
        System.out.println("Link: "+builder.getLink());
        System.out.println("Title: " +builder.getTitle());
        System.out.println("DocName: "+builder.getDocName());
           
    }

    @FXML //Prueba de panel al darle click derecho, nunca lo terminé
    protected void openDPane(ActionEvent event) {

        //destinyPane.set;
        destinyPane.setVisible(true);
    }

    @FXML
    protected void sendme(ActionEvent event) throws Exception {
        
        MailService ms = new MailService();
        TextInputDialog ti = new TextInputDialog("Dirección de envío");
        ti.showAndWait();
        
        String destiny = ti.getResult();
        ms.sendMail(new MailModel("tu página","index.html","Esta es tu página, gracias por usar nuestro software",destiny));
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Mensaje enviado");
        a.showAndWait();
    }
    
    @FXML
    protected void close(ActionEvent event) throws Exception {
        
        BufferedWriter b=new BufferedWriter(new FileWriter(f.getAbsolutePath()));
        b.write("");
        b.close();
        iLoader = new GUILoader("homescreen", "Home Screen");
    }
    
    public HtmlConstruction getBuilder(){
        return builder;
    }
    
    private void reloadInspectHtml()
            throws IOException
    {
        ht.setText("");
        
        BufferedReader inspect = new BufferedReader(new FileReader(f.getAbsolutePath()));
        
            String linea = inspect.readLine();
            
            while(linea!=null)
            {
                try 
                {
                    ht.appendText(linea+"\n");
                    linea = inspect.readLine();    
                } catch (Exception e) {
                }
                
            }
        
        inspect.close();
    }
    
    private void reloadInspectJs()
            throws IOException
    {
        js.setText("");
        
        BufferedReader inspect = new BufferedReader(new FileReader("/Testorona.js"));
        
            String linea = inspect.readLine();
            
            while(linea!=null)
            {
                try 
                {
                    js.appendText(linea+"\n");
                    linea = inspect.readLine();
                } catch (Exception e) {
                }
                
            }
        
        inspect.close();
    }
    

}
