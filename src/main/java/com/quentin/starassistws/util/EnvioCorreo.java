package com.quentin.starassistws.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnvioCorreo {
	
	public void sendEmail( String asunto, 
						   String username, 
						   String password, 
						   String destinatario,
						   String correosCopiasNormales, 
						   String correosCopiasOcultas,
						   String saludoInicio, 
						   String presentacion, 
						   String cuerpoMensaje, 
						   String saludoDespedida, 
						   String firma, 
						   String correContacto) {

        

        // Configura las propiedades para la conexión SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Crea una instancia de Authenticator para la autenticación
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // Crea una sesión de correo
        Session session = Session.getInstance(props, authenticator);

        try {
            // Crea un objeto de mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            
            
            
            BodyPart texto = new MimeBodyPart();
            texto.setContent(crearTexto(saludoInicio, presentacion, cuerpoMensaje, saludoDespedida, firma, correContacto), "text/html");
            
            MimeMultipart multiParte = new MimeMultipart();    
			multiParte.addBodyPart(texto);
            
			InternetAddress[] parse = InternetAddress.parse(destinatario);
			for( InternetAddress in:parse){
				message.addRecipient(Message.RecipientType.TO,in );   //Se podrían añadir varios de la misma manera
			}
			
			
			InternetAddress[] parsecopia = InternetAddress.parse(correosCopiasNormales);
			for( InternetAddress in:parsecopia){
				message.addRecipient(Message.RecipientType.CC,in );   //Se podrían añadir varios de la misma manera
			}
			
			
			InternetAddress[] parsecopiaOculta = InternetAddress.parse(correosCopiasOcultas);
			for( InternetAddress in:parsecopiaOculta){
				message.addRecipient(Message.RecipientType.BCC,in );   //Se podrían añadir varios de la misma manera
			}
			
			message.setSubject(asunto);
			message.setContent(multiParte);
           

            // Envía el mensaje
            Transport.send(message);

            //System.out.println("Correo enviado con éxito.");

        } catch (MessagingException e) {
        	e.printStackTrace();
        	System.out.println("error: "+e.getMessage());
            throw new RuntimeException("Error al enviar el correo: " + e);
        }
    }
	
	public String crearTexto(String saludoInicio, String presentacion, String cuerpoMensaje, String saludoDespedida, String firma, String correContacto){
        String texto="";
        
        texto="<!DOCTYPE html>\n" +
                    "<html lang=\"es-ES\">\n" +
                    "  <head>\n" +
                    "    <meta charset=\"utf-8\">\n" +
//                    "    <title>"+cuerpo+"</title>\n" +
                    "<link rel=\"stylesheet\" href=\"css/style.css\">\n"+
                    "    <style>\n" +
                    "      p {\n" +
                    "        color:black;\n" +
                    "        text-align:left;\n" +
                    "      }\n" +
                    "      b {\n" +
                    "        color:blue;\n" +
                    "      }\n" +
                    "    </style>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "<p>"+saludoInicio+"</p>\n" +
                    "<p>"+presentacion+" </p>"+
                    "<p>"+cuerpoMensaje+"<b>"+correContacto+" </b>"+" </p>"+                   
                    "<p>"+saludoDespedida+" </p>"+
                    "<p>"+firma+"</p>"+
                    "  </body>\n" +
                    "</html>";
        return texto;
    }

}
