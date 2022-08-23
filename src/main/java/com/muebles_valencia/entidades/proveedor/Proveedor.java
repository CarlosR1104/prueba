package com.muebles_valencia.entidades.proveedor;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.muebles_valencia.entidades.administrador.Administrador;
import com.muebles_valencia.entidades.producto.Producto;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cedula_proveedor")
	private String cedula_proveedor;
	
	@Column(name = "telefono_proveedor")
	private String telefono_proveedor;
	
	@Column(name = "nombre_proveedor")
	private String nombre_proveedor;

	public Proveedor() {
	
	}

	public Proveedor(String cedula_proveedor, String telefono_proveedor, String nombre_proveedor) {
		super();
		this.cedula_proveedor = cedula_proveedor;
		this.telefono_proveedor = telefono_proveedor;
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getCedula_proveedor() {
		return cedula_proveedor;
	}

	public void setCedula_proveedor(String cedula_proveedor) {
		this.cedula_proveedor = cedula_proveedor;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}
}
