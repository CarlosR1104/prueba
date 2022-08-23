package com.muebles_valencia.servicios.correo;

import java.awt.Image;
import java.awt.image.ImageProducer;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.text.Element;
import javax.swing.text.html.ImageView;

import org.springframework.stereotype.Service;

import com.muebles_valencia.entidades.producto.Producto;

@Service
public class EnviadorDeCorreos {

	/**
	 * public static void sendEmail(String to, String subject, String body) { try {
	 * sendEmail(to, subject, body, null); } catch (Exception e) {
	 * System.out.println("ERROR " + e); } }
	 **/
	public static void sendEmail(String to, String nombreCliente, Producto prodReservar) {

		try {
			CorreoDTO dto = new CorreoDTO();
			dto.getDestinatarios().add(to);
			dto.setContenido("Hola " + nombreCliente + " se ha reservado el producto exitosamente "
					+ prodReservar.getDescripcion_producto());
			dto.setTitulo("Producto reservado con exito");
			dto.setURL(prodReservar.getFoto_producto());
			File archivo = new File("C:\\Users\\SENA\\Documents\\SMV\\ImagenesDescargadas\\" + dto.getFileName());
			dto.getAdjuntos().add(archivo);
			EnviarCorreo enviarCorreo = new EnviarCorreo(dto);
			enviarCorreo.start();
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
		}
	}

}
