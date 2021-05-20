/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.entity;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Cristian Duarte
 */
@Stateless
@LocalBean
public class CorreoBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void enviarCorreo(String fromEmail,String username, String password, String toEmail, String clave) {

       
        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.sokcetFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session session = Session.getInstance(props, null);
            session.setDebug(true);

            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setContent("Su clave de recuperación es: "+clave,"text/html");
            message.setSubject("Recuperación de contraseña");

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com",username,password);
            
            transport.sendMessage(message, message.getAllRecipients());
            
        } catch (MessagingException ex) {
            Logger.getLogger(CorreoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    public void reportarSintomas(String fromEmail,String username, String password, String toEmail,String asunto) {

       
        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.sokcetFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session session = Session.getInstance(props, null);
            session.setDebug(true);

            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setContent(asunto,"text/html");
            message.setSubject("Reporte de sintomas");

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com",username,password);
            
            transport.sendMessage(message, message.getAllRecipients());
            
        } catch (MessagingException ex) {
            Logger.getLogger(CorreoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

 public void generarReporte(String fromEmail,String username, String password, String toEmail, String reporte) {

       
        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.sokcetFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session session = Session.getInstance(props, null);
            session.setDebug(true);

            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setContent(reporte,"text/html");
            message.setSubject("Reporte de vacunación");

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com",username,password);
            
            transport.sendMessage(message, message.getAllRecipients());
            
        } catch (MessagingException ex) {
            Logger.getLogger(CorreoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
