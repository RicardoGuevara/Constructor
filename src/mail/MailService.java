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

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class MailService implements Runnable{
    
    private MailModel actualMail;
    private ArrayList<String> mass =new ArrayList<>(); 
    
    public boolean sendMail(MailModel mail)
    {
        try
        {
            this.actualMail = mail;
            mail();
            return true;
        }
        catch(NullPointerException ne)
        {
            System.out.println("error en el parametro recibido (correo) : atributo incompleto en:");
            ne.printStackTrace();
            return false;
        }
        catch(MessagingException me)
        {
            System.out.println("error interno del envio de mensaje : ");
            me.printStackTrace();
            return false;
        }
    }
    
    public boolean massiveSendMail(MailModel mail, String... mass)
    {
        try
        {
            for (String mas : mass) 
            {
                this.mass.add(mas);
            }
            this.actualMail = mail;
            run();
            return true;
        }
        catch(NullPointerException ne)
        {
            System.out.println("error en el parametro recibido (correo) : atributo incompleto en:");
            ne.printStackTrace();
            return false;
        }
    }        
    
    private void massiveMail() 
            throws MessagingException
    {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance
            (props,
                new javax.mail.Authenticator() 
                {
                    protected PasswordAuthentication getPasswordAuthentication() 
                    {
                        return new PasswordAuthentication(actualMail.getUserName(), actualMail.getPassword());
                    }
                }
            );

        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(actualMail.getUserName()));
        message.setRecipients(  Message.RecipientType.TO,
                                InternetAddress.parse(actualMail.getDestiny()));
        message.setSubject(actualMail.getSubject());
        message.setText(actualMail.getMsj());

        try
        {
        message.setFileName(actualMail.getFileUrl());
        }
        catch(Exception e){System.out.println("sin archivo adjunto");}
        finally
        {    
            for (String mas : this.mass) 
            {
                Transport.send(message,InternetAddress.parse(mas));
                //JOptionPane.showMessageDialog(null, "Su mensaje ha sido enviado");
            }
        }

    }
    
    private void mail() 
            throws MessagingException
    {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance
            (props,
                new javax.mail.Authenticator() 
                {
                    protected PasswordAuthentication getPasswordAuthentication() 
                    {
                        return new PasswordAuthentication(actualMail.getUserName(), actualMail.getPassword());
                    }
                }
            );

        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(actualMail.getUserName()));
        message.setRecipients(  Message.RecipientType.TO,
                                InternetAddress.parse(actualMail.getDestiny()));
        message.setSubject(actualMail.getSubject());
        message.setText(actualMail.getMsj());
        
        try
        {
        message.setFileName(actualMail.getFileUrl());
        }
        catch(Exception e){System.out.println("sin archivo adjunto");}
        finally
        {
            Transport.send(message,InternetAddress.parse(actualMail.getDestiny()));
            //JOptionPane.showMessageDialog(null, "Su mensaje ha sido enviado");
        }
    }
    
    @Override
    public void run() 
    {
        try
        {
            massiveMail();   
        }
        catch(NullPointerException ne)
        {
            System.out.println("parametros faltantes durante el envio del mensaje (hilo de envio): ");
            ne.printStackTrace();
        }
        catch(MessagingException me)
        {
            System.out.println("error interno del envio de mensaje (hilo de envio) : ");
            me.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("error por descarte. linea:");
            e.printStackTrace();
        }
        
        
    }
}
