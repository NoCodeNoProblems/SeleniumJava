package br.com.tortiago.util.evidencias;
import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMail{

//	public static void main(String[] args) {
	
	
	public void enviaEmail(String[] evidencias) {

		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication("tortiago.eu@gmail.com", "@google4891");
			}
		});

		/** Ativa Debug para sessão */
//		session.setDebug(true);

		try {
			
			// Lista de destinatários
			Address[] toUser = InternetAddress //Destinatário(s)
					.parse("tortiago.eu@hotmail.com");
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("tortiago.eu@gmail.com")); //Remetente
			message.setRecipients(Message.RecipientType.TO, toUser);// Destinatarios
			message.setSubject("Enviando email com JavaMail");//Assunto
			
//			message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");// Corpo da mensagem
//			message.setHeader("header ", "teste de Header");
			
			Multipart mp = new MimeMultipart();
			
			// Criando Anexo
			for (int i = 0; i < evidencias.length; i++) {
				
				File print = new File(evidencias[i]); 
				
				MimeBodyPart mbp2 = new MimeBodyPart();
				
				FileDataSource fds = new FileDataSource(print);          
				mbp2.setDataHandler(new DataHandler(fds));
				mbp2.setFileName(fds.getName());   
				
				// Adicionando anexo no e-mail
			
				mp.addBodyPart(mbp2);
				
			}

			message.setContent(mp);
			
			
			/**Método para enviar a mensagem criada*/
			Transport.send(message);
			
			System.out.println("E-mail enviado com sucesso!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}