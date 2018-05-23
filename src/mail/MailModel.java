/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

/**
 *
 * @author RICARDO
 */
public class MailModel {
    
    private String  userName,
                    password,
                    subject,
                    fileUrl,
                    msj,
                    destiny;

    public MailModel(String userName, String password, String subject, String fileUrl, String msj, String destiny) {
        this.userName = userName;
        this.password = password;
        this.subject = subject;
        this.fileUrl = fileUrl;
        this.msj = msj;
        this.destiny = destiny;
    }

    public MailModel(String subject, String fileUrl, String msj, String destiny) {
        this.userName= "htmlconstruc@gmail.com";
        this.password= "CONTRASENIADEMIERDA";
        this.subject = subject;
        this.fileUrl = fileUrl;
        this.msj = msj;
        this.destiny = destiny;
    }

    public MailModel(String subject, String msj, String destiny) {
        this.userName= "htmlconstruc@gmail.com";
        this.password= "CONTRASENIADEMIERDA";
        this.subject = subject;
        this.fileUrl = "";
        this.msj = msj;
        this.destiny = destiny;
    }
    
    public MailModel(String destiny) 
    {
        this.userName= "htmlconstruc@gmail.com";
        this.password= "CONTRASENIADEMIERDA";
        this.subject = "CORREO DE PRUEVA";
        this.fileUrl = "adp.txt";
        this.msj = "ESTE ES UN CORREO DE PRUEVA ENVIADO DESDE JAVA";
        this.destiny = destiny;
    }

    
    

//GS____________________________________________________________________________    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }
    
    
    
    
    
    
}
