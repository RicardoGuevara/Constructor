/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

/**
 *
 * @author rpayan
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


public class Upload {
    
    private String  serverName,
                    user,
                    pass;

    public Upload(String serverName, String user, String pass) {
        this.serverName = serverName;
        this.user = user;
        this.pass = pass;
    }
    
    
    
    public void inUpload(String ruta)
    {
        FTPClient client = new FTPClient();
        try
        {
            client.connect(serverName);
            boolean login = client.login(user, pass);
            
            if (login)
            {
                System.out.println("Iniciando sesión Satisfactoriamente");
                int replay = client.getReplyCode();
                if (FTPReply.isPositiveCompletion(replay))
                {
                    File file = new File(ruta);
                    FileInputStream input = new FileInputStream(file);
                    client.setFileType(FTP.BINARY_FILE_TYPE);

                    client.enterLocalPassiveMode();
                    System.out.println("Subió satisfactoriamente el archivo");

                    if (!client.storeFile(file.getName(),input))
                    {
                        System.out.println("Subida fallida!");
                    }
                    input.close();
                }
            // retorna true al cerrar sesiòn
                boolean logout = client.logout();
                
                if (logout)
                {
                    System.out.println("Salir del servidor FTP");
                }
            }
            else
            {
                System.out.println("Falló inciar sesión");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                // Cierra la conexión al servidor FTP
                client.disconnect();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
}
