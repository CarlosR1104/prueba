package com.muebles_valencia.entidades.productos_proveedor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos_proveedor")
public class Productos_Proveedor implements Serializable{

	private static final long serialVersionUID = -7213690646622402064L;
	
	@Id
	@Column(name = "puente")
	private Integer puente;
	
	@Column(name = "codigo_proveedor2")
	private String codigo_proveedor;
	
	@Column(name = "codigo_producto2")
	private Integer codigo_producto;

	public Productos_Proveedor() {
	
	}

	public Productos_Proveedor(Integer puente, String codigo_proveedor, Integer codigo_producto) {
		super();
		this.puente = puente;
		this.codigo_proveedor = codigo_proveedor;
		this.codigo_producto = codigo_producto;
	}

	public Integer getConteo() {
		return puente;
	}

	public void setConteo(Integer puente) {
		this.puente = puente;
	}

	public String getCodigo_proveedor() {
		return codigo_proveedor;
	}

	public void setCodigo_proveedor(String codigo_proveedor) {
		this.codigo_proveedor = codigo_proveedor;
	}

	public Integer getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Integer codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	
}
