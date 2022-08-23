package com.muebles_valencia.entidades.empleado;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.muebles_valencia.entidades.administrador.Administrador;
import com.muebles_valencia.entidades.factura.Factura;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "codigo_empleado")
	private Integer codigo_empleado;
	
	@Column(name = "nombre_empleado")
	private String nombre_empleado;
	
	@Id
	@Column(name = "cedula_empleado")
	private String cedula_empleado;
	
	@Column(name = "telefono_empleado")
	private int telefono_empleado;
	
	@Column(name = "estado_empleado" )
	private int estado_empleado = 2;
	
	@OneToMany(mappedBy = "id_empleado")
	@JsonIgnore
	private Set<Factura> id_Factura;

	public Empleado() {

	}

	public Empleado(Integer codigo_empleado, String nombre_empleado, String cedula_empleado, int telefono_empleado,
			int estado_empleado, Set<Factura> id_Factura) {
		super();
		this.codigo_empleado = codigo_empleado;
		this.nombre_empleado = nombre_empleado;
		this.cedula_empleado = cedula_empleado;
		this.telefono_empleado = telefono_empleado;
		this.estado_empleado = estado_empleado;
		this.id_Factura = id_Factura;
	}

	public Integer getCodigo_empleado() {
		return codigo_empleado;
	}

	public void setCodigo_empleado(Integer codigo_empleado) {
		this.codigo_empleado = codigo_empleado;
	}

	public String getNombre_empleado() {
		return nombre_empleado;
	}

	public void setNombre_empleado(String nombre_empleado) {
		this.nombre_empleado = nombre_empleado;
	}

	public String getCedula_empleado() {
		return cedula_empleado;
	}

	public void setCedula_empleado(String cedula_empleado) {
		this.cedula_empleado = cedula_empleado;
	}

	public int getTelefono_empleado() {
		return telefono_empleado;
	}

	public void setTelefono_empleado(int telefono_empleado) {
		this.telefono_empleado = telefono_empleado;
	}

	public int getEstado_empleado() {
		return estado_empleado;
	}

	public void setEstado_empleado(int estado_empleado) {
		this.estado_empleado = estado_empleado;
	}

	public Set<Factura> getId_Factura() {
		return id_Factura;
	}

	public void setId_Factura(Set<Factura> id_Factura) {
		this.id_Factura = id_Factura;
	}

}
