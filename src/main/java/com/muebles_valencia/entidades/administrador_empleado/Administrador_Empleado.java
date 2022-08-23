package com.muebles_valencia.entidades.administrador_empleado;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administradores_empleados")
public class Administrador_Empleado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "puente")
	private Integer puente;
	
	@Column(name = "codigo_Administrador")
	private Integer codigo_Administrador;
	
	@Column(name = "codigo_Empleado")
	private String codigo_Empleado;

	public Administrador_Empleado() {
	
	}

	public Administrador_Empleado(Integer puente, Integer codigo_Administrador, String codigo_Empleado) {
		super();
		this.puente = puente;
		this.codigo_Administrador = codigo_Administrador;
		this.codigo_Empleado = codigo_Empleado;
	}

	public Integer getPuente() {
		return puente;
	}

	public void setPuente(Integer puente) {
		this.puente = puente;
	}

	public Integer getCodigo_Administrador() {
		return codigo_Administrador;
	}

	public void setCodigo_Administrador(Integer codigo_Administrador) {
		this.codigo_Administrador = codigo_Administrador;
	}

	public String getCodigo_Empleado() {
		return codigo_Empleado;
	}

	public void setCodigo_Empleado(String codigo_Empleado) {
		this.codigo_Empleado = codigo_Empleado;
	}
	
}
