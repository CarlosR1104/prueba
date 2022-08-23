package com.muebles_valencia.entidades.carritoCompra;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carritocompras")
public class CarritoCompra implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "codigo_Carrito")
	private Integer codigo_Carrito;
	
	@Column(name = "nombre_producto")
	private String nombre__producto;
	
	@Column(name = "descripcion_producto")
	private String descripcion_producto;
	
	@Column(name = "imagen_producto")
	private String imagen_producto;
	
	@Column(name = "precio_producto")
	private float precio_producto;
	
	@Column(name = "cantidad_cart")
	private int cantidad_cart ;
	
	@Column(name = "precio_total")
	private float precio_total;

	public CarritoCompra() {
	
	}

	public CarritoCompra(Integer codigo_Carrito, String nombre__producto, String descripcion_producto,String imagen_producto,
			float precio_total,float precio_producto,int cantidad) {
		super();
		this.codigo_Carrito = codigo_Carrito;
		this.nombre__producto = nombre__producto;
		this.descripcion_producto = descripcion_producto;
		this.imagen_producto=imagen_producto;
		this.precio_total = precio_total;
		this.precio_producto = precio_producto;
		this.cantidad_cart=cantidad;
	}

	public Integer getCodigo_Carrito() {
		return codigo_Carrito;
	}

	public void setCodigo_Carrito(Integer codigo_Carrito) {
		this.codigo_Carrito = codigo_Carrito;
	}

	public String getNombre__producto() {
		return nombre__producto;
	}

	public void setNombre__producto(String nombre__producto) {
		this.nombre__producto = nombre__producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}
	
	
	
	public String getImagen_producto() {
		return imagen_producto;
	}

	public void setImagen_producto(String imagen_producto) {
		this.imagen_producto = imagen_producto;
	}

	public float getPrecio_total() {
		return precio_total;
	}
	
	

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}

	public float getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(float precio_producto) {
		this.precio_producto = precio_producto;
	}

	public int getCantidad_cart() {
		return cantidad_cart;
	}

	public void setCantidad_cart(int cantidad_cart) {
		this.cantidad_cart = cantidad_cart;
	}
	
	
		
}
