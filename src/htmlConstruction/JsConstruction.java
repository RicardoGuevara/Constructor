/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlConstruction;

import static htmlConstruction.HtmlConstruction.components;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import nodos.NodoM;
import visuals.ProjectScreen;

/**
 *
 * @author Estudiante
 */
public class JsConstruction implements Runnable{

    @Override
    public void run() 
    {
        defaultDocumentConstruction();
    }
    
    public void documentConstruction(String doc)
    {
        docName=doc+".js";
        run();
    }
    
    private void defaultDocumentConstruction()
    {
        try
        {
            startDocument();
            middle();
            writeFunctions();
            
        }catch(IOException e){}
        
    }
    
    private void startDocument() 
            throws IOException
    {
        File doc = new File(this.docName);
        FileWriter documento = new FileWriter(doc);
        BufferedWriter escribir = new BufferedWriter(documento);
            
            NodoM p=HtmlConstruction.components;
            
            while (p!=null)
            {
                try
                {
                    String varName=((HtmlComponent)p.getInfor()).getElementId();
                    
                    escribir.write
                    (
                            "var "+varName+
                            " = document.getElementById('"+
                            varName+"');"
                    );
                    escribir.newLine();
                    
                }catch(Exception e){}
                p=p.getRlink();
            }
        
            
        escribir.close();
        documento.close();
    }
    
    
    private void middle()
            throws IOException
    {
        File doc = new File(this.docName);
        FileWriter documento = new FileWriter(doc,true);
        BufferedWriter escribir = new BufferedWriter(documento);
            
            NodoM p=events;
            
            while (p!=null)
            {
                try
                {
                    String varName=((JsEvent)p.getInfor()).getIdIn();
                    
                    escribir.write(((JsEvent)p.getInfor()).getAction());
                    escribir.newLine();
                    
                }catch(Exception e){}
                p=p.getRlink();
            }
        
            
        escribir.close();
        documento.close();
    }
    
    private void writeFunctions() 
            throws IOException 
    {
        BufferedReader leer = new BufferedReader(new FileReader("functions.txt"));
        BufferedWriter escribir = new BufferedWriter(new FileWriter(this.docName,true));
        
            String linea = leer.readLine();
            
            while(linea!=null)
            {
                escribir.write(linea);
                escribir.newLine();
                linea = leer.readLine();
            }
        
        leer.close();
        escribir.close();
    }
    
    
    public String docName;
    
    public static NodoM events = new NodoM();

    
    
}
