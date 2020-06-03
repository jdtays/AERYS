/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Notificacion;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author josed
 */
public class NotificacionDAO {

    private Notificacion notificacion = new Notificacion();

    public void enviarNotificacion(Notificacion notificacion) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(notificacion.getCorreoIA(), notificacion.getContrasena());
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(notificacion.getCorreoIA()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(notificacion.getCorreoDestino()));
            message.setSubject(notificacion.getAsunto());
            message.setText(notificacion.getMensaje());

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
