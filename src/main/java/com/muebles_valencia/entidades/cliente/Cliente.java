package com.muebles_valencia.entidades.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.muebles_valencia.entidades.carritoCompra.CarritoCompra;
import com.muebles_valencia.entidades.factura.Factura;
import com.muebles_valencia.entidades.proveedor.Proveedor;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_cliente")
	private Integer codigo_cliente;
	
	@Id
	@Column(name = "cedula_cliente")
	private String cedula_cliente;	
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "celular_cliente")
	private String celular_cliente;
	
	@Column(name = "apellido_cliente")	
	private String apellido_cliente;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "fecha_nacimin_cliente")
	private String fecha_nacimin_cliente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carrito")
	private CarritoCompra carrito;
	
	@OneToMany(mappedBy="cliente")
    private Set<Factura> facturas;
    
	@Column(name = "contraseña_cliente")
	private String contraseña_cliente;
	
	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinTable(
			name = "clientes_roles",
			joinColumns = @JoinColumn(name = "cedula_cliente"),
			inverseJoinColumns = @JoinColumn(name = "id")
			)
	private Set<Rol> roles = new HashSet<>();
	
	@Column(name = "estado_cliente")
	private int estado_cliente;
	
	public Cliente() {
	
	}

	public Cliente(Integer codigo_cliente, String cedula_cliente, String nombre_cliente, String celular_cliente,
			String apellido_cliente, String correo_cliente, String fecha_nacimin_cliente, CarritoCompra carrito,
			Set<Factura> facturas, String contraseña_cliente, Set<Rol> roles, int estado_cliente) {
		super();
		this.codigo_cliente = codigo_cliente;
		this.cedula_cliente = cedula_cliente;
		this.nombre = nombre_cliente;
		this.celular_cliente = celular_cliente;
		this.apellido_cliente = apellido_cliente;
		this.correo = correo_cliente;
		this.fecha_nacimin_cliente = fecha_nacimin_cliente;
		this.carrito = carrito;
		this.facturas = facturas;
		this.contraseña_cliente = contraseña_cliente;
		this.roles = roles;
		this.estado_cliente = estado_cliente;
	}



	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre_cliente) {
		this.nombre = nombre_cliente;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo_cliente) {
		this.correo = correo_cliente;
	}

	public String getFecha_nacimin_cliente() {
		return fecha_nacimin_cliente;
	}

	public void setFecha_nacimin_cliente(String fecha_nacimin_cliente) {
		this.fecha_nacimin_cliente = fecha_nacimin_cliente;
	}

	public CarritoCompra getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoCompra carrito) {
		this.carrito = carrito;
	}

	public Set<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
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

	@Override
	public String toString() {
		return "Cliente [codigo_cliente=" + codigo_cliente + ", cedula_cliente=" + cedula_cliente + ", nombre=" + nombre
				+ ", celular_cliente=" + celular_cliente + ", apellido_cliente=" + apellido_cliente + ", correo="
				+ correo + ", fecha_nacimin_cliente=" + fecha_nacimin_cliente + ", carrito=" + carrito + ", facturas="
				+ facturas + ", contraseña_cliente=" + contraseña_cliente + ", roles=" + roles + ", estado_cliente="
				+ estado_cliente + "]";
	}
	
}
