/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlConstruction;

/**
 *
 * @author Bloque G
 */

import htmlconstructor.HtmlConstructor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import nodos.NodoM;
import visuals.ProjectScreen;

public class HtmlConstruction implements Runnable {

    @Override
    public void run() {
        defaultDocumentConstruction();
    }

    //______________________________________________________________________________ 
    /**
     * construct a standar document
     */
    public void defaultDocumentConstruction() {
        try {
            startDocument();
            startHead();
            closeHead();
            //
            startBody();
            closeBody();
            closeDocument();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "ocurrio un error en la construccion");
        }

    }

    /**
     * construct a document whit a personalizated title
     *
     * @param doctitle 
     */
    public void DocumentConstruction(String doctitle) {

        this.docName = "index.html";//doctitle + ".html";
        this.title = doctitle;
        run();
    }

//______________________________________________________________________________    
    /**
     * starts the document structure
     *
     * @throws IOException
     */
    private void startDocument()
            throws IOException {
        File doc = new File(this.docName);
        FileWriter documento = new FileWriter(doc);
        BufferedWriter escribir = new BufferedWriter(documento);

        escribir.write("<DOCTYPE! html>");
        escribir.newLine();

        escribir.write("<!--" + ProjectScreen.userName + "-->");
        escribir.newLine();

        escribir.write("<html>");
        escribir.newLine();

        this.setLink(doc.getAbsolutePath());

        escribir.close();
        documento.close();
    }

    /**
     * close a document structure
     *
     * @throws IOException
     */
    private void closeDocument()
            throws IOException {
        FileWriter documento = new FileWriter(this.docName, true);
        BufferedWriter escribir = new BufferedWriter(documento);

        escribir.write("</html>");
        escribir.newLine();

        escribir.close();
        documento.close();
    }

    /**
     * starts the head structure whit the default title
     *
     * @throws IOException
     */
    private void startHead()
            throws IOException {
        FileWriter documento = new FileWriter(this.docName, true);
        BufferedWriter escribir = new BufferedWriter(documento);

        BufferedReader leer = new BufferedReader(new FileReader("complementoBt.txt"));
        
        escribir.write("<head>");
        escribir.newLine();

        escribir.write("<meta charset =\"UTF-8\" / >");
        escribir.newLine();

        escribir.write("    <title>" + HtmlConstructor.user + "</title>");
        escribir.newLine();
        
        String t= leer.readLine();
        
        while(t!=null)
        {
        System.out.println(t);
        escribir.write(t);
        escribir.newLine();
        t=leer.readLine();
        }
        
        leer.close();
        escribir.close();
        documento.close();
    }

    /**
     * close the document head sttructure
     *
     * @throws IOException
     */
    private void closeHead()
            throws IOException {
        FileWriter documento = new FileWriter(this.docName, true);
        BufferedWriter escribir = new BufferedWriter(documento);

        escribir.write("    </head>");
        escribir.newLine();

        escribir.close();
        documento.close();
    }

    /**
     * starts the body document structure
     *
     * @throws IOException
     */
    private void startBody()
            throws IOException {
        FileWriter documento = new FileWriter(this.docName, true);
        BufferedWriter escribir = new BufferedWriter(documento);

        escribir.write("    <body>");
        escribir.newLine();

        NodoM p = components;

        while (p != null) {
            try {
                escribir.write(((HtmlComponent) p.getInfor()).getElementComand());
                escribir.newLine();

            } catch (Exception e) {
            }
            p = p.getRlink();
        }

        escribir.close();
        documento.close();
    }

    /**
     * close the body structure on a document
     *
     * @throws IOException
     */
    private void closeBody()
            throws IOException {
        FileWriter documento = new FileWriter(this.docName, true);
        BufferedWriter escribir = new BufferedWriter(documento);

        escribir.write("<script src=" + ((char) 34) + this.title + ".js" + ((char) 34) + "></script>");
        escribir.newLine();

        escribir.write("    </body>");
        escribir.newLine();

        escribir.close();
        documento.close();
    }
    
    public static int subsId(String name)
    {
        String retorno="";
        int i=0;
        
        while(name.startsWith(" "))
        {
            name=name.substring(1);
        }
        
        while(!name.substring(i,i+1).equals(" "))
        {
            retorno=retorno+name.substring(i,i+1);
            i++;
        }
        
        System.out.println(retorno+"|");
        
        return Integer.parseInt(retorno);
    }
    
    public static HtmlComponent searchId(int idComplement)
    {
        NodoM p = components;

        while (p != null) {
            try {
                if (((HtmlComponent) p.getInfor()).getLabelNum() == idComplement) {
                    System.out.println("relacionado");
                    return ((HtmlComponent) p.getInfor());
                }
            } catch (Exception e) {
            }

            p = p.getRlink();
        }
        return null;
    }

    //______________________________________________________________________________
    public static NodoM components = new NodoM();

    private String docName,
            title = "defaultTitle",
            link;

    public NodoM getComponents() {
        return components;
    }

    public void setComponents(NodoM components) {
        this.components = components;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
