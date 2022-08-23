package com.muebles_valencia.entidades.productos_clientes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos_clientes")
public class Productos_Clientes implements Serializable{

	private static final long serialVersionUID = -6844377848096971714L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "puente")
	private Integer puente;
	
	@Column(name = "codigo_Producto")
	private Integer codigo_Producto;
	
	@Column(name = "codigo_Cliente")
	private String codigo_Cliente;
		
	public Productos_Clientes() {
	
	}
	
	public Productos_Clientes(Integer puente, Integer codigo_Producto, String codigo_Cliente) {
		super();
		this.puente = puente;
		this.codigo_Producto = codigo_Producto;
		this.codigo_Cliente = codigo_Cliente;
	}

	public Integer getConteo() {
		return puente;
	}

	public void setConteo(Integer conteo) {
		this.puente = conteo;
	}

	public Integer getCodigo_Producto() {
		return codigo_Producto;
	}

	public void setCodigo_Producto(Integer codigo_Producto) {
		this.codigo_Producto = codigo_Producto;
	}

	public String getCodigo_Cliente() {
		return codigo_Cliente;
	}

	public void setCodigo_Cliente(String codigo_Cliente) {
		this.codigo_Cliente = codigo_Cliente;
	}
	
}
