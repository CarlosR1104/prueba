package com.muebles_valencia.entidades.cliente;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.muebles_valencia.entidades.carritoCompra.CarritoCompra;
import com.muebles_valencia.entidades.factura.Factura;

public class ClienteDTO {
	
private Integer codigo_cliente;
	
	private String cedula_cliente;	
	
	private String nombre_cliente;
	
	private String celular_cliente;
	
	private String apellido_cliente;
	
	private String correo_cliente;
	
	private String fecha_nacimin_cliente;
	
	private String contraseña_cliente;
	
	private int estado_cliente = 1;

	public Integer getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(Integer codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public String getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(String cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getCelular_cliente() {
		return celular_cliente;
	}

	public void setCelular_cliente(String celular_cliente) {
		this.celular_cliente = celular_cliente;
	}

	public String getApellido_cliente() {
		return apellido_cliente;
	}

	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}

	public String getCorreo_cliente() {
		return correo_cliente;
	}

	public void setCorreo_cliente(String correo_cliente) {
		this.correo_cliente = correo_cliente;
	}

	public String getFecha_nacimin_cliente() {
		return fecha_nacimin_cliente;
	}

	public void setFecha_nacimin_cliente(String fecha_nacimin_cliente) {
		this.fecha_nacimin_cliente = fecha_nacimin_cliente;
	}

	public String getContraseña_cliente() {
		return contraseña_cliente;
	}

	public void setContraseña_cliente(String contraseña_cliente) {
		this.contraseña_cliente = contraseña_cliente;
	}

	public int getEstado_cliente() {
		return estado_cliente;
	}

	public void setEstado_cliente(int estado_cliente) {
		this.estado_cliente = estado_cliente;
	}

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Integer codigo_cliente, String cedula_cliente, String nombre_cliente, String celular_cliente,
			String apellido_cliente, String correo_cliente, String fecha_nacimin_cliente, String contraseña_cliente,
			int estado_cliente) {
		super();
		this.codigo_cliente = codigo_cliente;
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.celular_cliente = celular_cliente;
		this.apellido_cliente = apellido_cliente;
		this.correo_cliente = correo_cliente;
		this.fecha_nacimin_cliente = fecha_nacimin_cliente;
		this.contraseña_cliente = contraseña_cliente;
		this.estado_cliente = estado_cliente;
	}
	
	
}
