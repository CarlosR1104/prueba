package com.muebles_valencia.entidades.factura;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.muebles_valencia.entidades.administrador.Administrador;
import com.muebles_valencia.entidades.carritoCompra.CarritoCompra;
import com.muebles_valencia.entidades.cliente.Cliente;
import com.muebles_valencia.entidades.empleado.Empleado;
import com.muebles_valencia.entidades.producto.Producto;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_factura")
	private Integer codigo_factura;
	
	@Column(name = "cantidad_producto")
	private int cantidad_producto;
	
	@Column(name = "fecha_factura")
	private Date fecha_factura;
	
	@Column(name = "nombre_cliente")
	private String nombre_cliente;
	
	@Column(name = "telefono_cliente")
	private int telefono_cliente;
	
	@Column(name = "direccion_cliente")
	private String direccion_cliente;
	
	@Column(name = "nombre_producto")
	private String nombre_producto;
	
	@Column(name = "total_a_pagar")
	private String total_a_pagar;
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "id_empleado")
	private Empleado id_empleado;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "id_productos")
	private Producto id_productos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="id_cliente", nullable=false)
    private Cliente cliente;

	public Factura() {
	
	}

	public Factura(Integer codigo_factura, int cantidad, Date fecha_factura, String nombre_cliente,
			int telefono_cliente, String direccion_cliente, String nombre_producto, String total_a_pagar,
			Empleado id_empleado, Producto id_productos, Cliente cliente) {
		super();
		this.codigo_factura = codigo_factura;
		this.cantidad_producto = cantidad;
		this.fecha_factura = fecha_factura;
		this.nombre_cliente = nombre_cliente;
		this.telefono_cliente = telefono_cliente;
		this.direccion_cliente = direccion_cliente;
		this.nombre_producto = nombre_producto;
		this.total_a_pagar = total_a_pagar;
		this.id_empleado = id_empleado;
		this.id_productos = id_productos;
		this.cliente = cliente;
	}

	public Integer getCodigo_factura() {
		return codigo_factura;
	}

	public void setCodigo_factura(Integer codigo_factura) {
		this.codigo_factura = codigo_factura;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public Date getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(Date fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public int getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(int telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getTotal_a_pagar() {
		return total_a_pagar;
	}

	public void setTotal_a_pagar(String total_a_pagar) {
		this.total_a_pagar = total_a_pagar;
	}

	public Empleado getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Empleado id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Producto getId_productos() {
		return id_productos;
	}

	public void setId_productos(Producto id_productos) {
		this.id_productos = id_productos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
