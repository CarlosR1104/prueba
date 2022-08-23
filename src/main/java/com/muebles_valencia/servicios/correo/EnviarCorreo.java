package com.muebles_valencia.servicios.correo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
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

public class EnviarCorreo extends Thread implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username = "jjchala84@misena.edu.co";
	private String password = "3148202269Jj";
	private CorreoDTO dto;

	public EnviarCorreo(CorreoDTO arg0) {
		dto = new CorreoDTO();
		dto = arg0;
	}

	public void run() {
		System.out.println("RUN " + dto);
		try {
			sendEmail(dto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}

	private Session connectServer() {
		// propiedades de conexion
		System.out.println("CONECTADO AL SERVER");
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		return Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}

	private String getDirecciones(CorreoDTO dto) {
		StringBuilder direcciones = new StringBuilder();
		boolean primero = true;
		for (String correo : dto.getDestinatarios()) {
			if (primero) {
				direcciones.append(correo);
				primero = !primero;
			} else {
				direcciones.append(",");
				direcciones.append(correo);
			}
		}
		return direcciones.toString();
	}

	public void saveImage(String imageUrl) throws IOException {
		try {
			URL url = new URL(imageUrl);
			String fileName = url.getFile();
			String destName = "C:\\Users\\" + fileName.substring(fileName.lastIndexOf("/"));
			String nameFile = fileName.substring(fileName.lastIndexOf("/"));
			String nameFileCorrected = nameFile.substring(1 , nameFile.length());
			dto.setFileName(nameFileCorrected);
			
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(destName);
		 
			byte[] b = new byte[2048];
			int length;
		 
			while ((length = is.read(b)) != -1) {
				os.write(b,  0, length);
			}
		 
			is.close();
			os.close();
		
		} catch (Exception e) {
			System.out.println("ERROR AL GUARDAR LA IMAGEN " + e);
		}
	}
	
	private void sendEmail(CorreoDTO dto) throws IOException {
		// Obtenemos las direcciones/destinatarios
		String direcciones = getDirecciones(dto);
		saveImage(dto.getURL());
		// Obtenemos la conexion al servidor de correos
		Session session = connectServer();
		try {
			MimeMessage msg = new MimeMessage(session);
			// Agregamos los headers necesarios
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			// Asignamos el asunto del correo
			msg.setSubject(dto.getTitulo(), "UTF-8");
			// Asignamos la hora de creacion del correo
			msg.setSentDate(new Date());

			Multipart multiparte = new MimeMultipart();

			// Creamos el cuerpo del mensaje
			BodyPart cuerpoMensaje = new MimeBodyPart();
			cuerpoMensaje.setContent(dto.getContenido(), "text/html");
			multiparte.addBodyPart(cuerpoMensaje);
			
			
			// Validamos si tenemos adjuntos
			if (dto.getAdjuntos() == null ? false : !dto.getAdjuntos().isEmpty()) {
				// Si tenemos adjuntos los agregamos al mensaje
				for (File file : dto.getAdjuntos()) {
					cuerpoMensaje = new MimeBodyPart();
					cuerpoMensaje.setDataHandler(new DataHandler(
							new FileDataSource("C:\\Users\\" + dto.getFileName())));
					cuerpoMensaje.setFileName("Imagen producto reservado");
					multiparte.addBodyPart(cuerpoMensaje);
				}
			}
	
			msg.setContent(multiparte);
			msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(direcciones));

			// Agregamos el origen del mensaje (nuestro email)
			msg.setFrom(new InternetAddress(username));

			// Enviamos el mensaje
			Transport.send(msg);
		} catch (MessagingException e) {
			System.out.println("SEND EMAIL EN ENVIAR CORREO " + e);
		}
	}

}
