/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlconstructor;

/**
 *
 * @author Bloque G
 */
import gui.*;
import htmlConstruction.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import nodos.NodoM;
import nodos.SubNodo;
import visuals.*;

public class HtmlConstructor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        fxMain.main(args);
        //ingresar.setVisible(true);
    }

//ARCHIVOS .HG__________________________________________________________________
    public static void saveHg()
            throws IOException {
        HtmlConstructor hc = new HtmlConstructor();
        NodoM resumenDeProyecto = hc.buildMultilist(),
                p = resumenDeProyecto;

        HtmlComponent control1;
        JsEvent control2;

        SubNodo q /* ,r */;

        BufferedWriter escribir = new BufferedWriter(new FileWriter(ProjectScreen.title + ".hg"));

        escribir.write(ProjectScreen.userName);
        escribir.newLine();

        while (p != null) {
            try {
                control1 = (HtmlComponent) p.getInfor();

                escribir.write(control1.getLabelNum() + ";"
                        + control1.getType() + ";"
                        + control1.getInitialValue() + ";"
                        + control1.getWidth() + ";"
                        + control1.getHeigth());
                escribir.newLine();

                q = p.getJsSublist();
                //r=p.getCssSublis();  agreagr seccion de código para imprimir el css

                while (q != null) {

                    System.out.println("punto de control 1");
                    try {
                        control2 = (JsEvent) q.getInfor();

                        escribir.write("    ");
                        escribir.write(control2.getEventType() + ";"
                                + control2.getFunctionName() + ";"
                                + control2.getIdOut());
                        escribir.newLine();

                        System.out.println("punto de control 1");
                    } catch (Exception e) {
                    }

                    q = q.getRlink();
                }

            } catch (Exception error) {
            }
            p = p.getRlink();
        }

        escribir.close();

        JOptionPane.showMessageDialog(null, "proyecto guardado correctamente");
    }

    public static void loadHg() {

    }

    private NodoM buildMultilist() {
        NodoM retorno = HtmlConstruction.components,
                js = JsConstruction.events,
                html = retorno;

        HtmlComponent actual;
        JsEvent actualjs;

        while (html != null) {
            try {
                actual = (HtmlComponent) html.getInfor();
                js = JsConstruction.events;
                while (js != null) {
                    try {
                        actualjs = (JsEvent) js.getInfor();

                        if (actualjs.getIdIn().equals(actual.getElementId())) {
                            System.out.println(actualjs.getIdIn() + actual.getElementId());
                            html.getJsSublist().add(js.getInfor());
                        }
                    } catch (Exception e) {
                    }

                    js = js.getRlink();
                }

                //___________________________________
                //ciclo para añadir el diseño css
                //___________________________________
            } catch (Exception e) {
            }
            html = html.getRlink();
        }

        return retorno;
    }

//-----------------Visuales Antiguas------------------
    public static boolean vtnOpen = false;

    public static UserLog ingresar = new UserLog();
    public static User menu = new User();
    public static ProjectScreen proyecto = new ProjectScreen();
    public static CssMenu css = new CssMenu();

//-----------------Visuales Actuales-------------------
    public static FXMain fxMain = new FXMain();
}
