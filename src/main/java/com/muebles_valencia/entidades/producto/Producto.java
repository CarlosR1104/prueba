package com.muebles_valencia.entidades.producto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;

import com.muebles_valencia.entidades.administrador.Administrador;
import com.muebles_valencia.entidades.categoria.Categoria;
import com.muebles_valencia.entidades.cliente.Cliente;
import com.muebles_valencia.entidades.proveedor.Proveedor;

@Entity
@Table(name = "productos")
public class Producto implements Serializable{

	private static final long serialVersionUID = -65731584343872370L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "codigo_producto")
	private Integer codigo_producto;
	
	@Column(name = "nombre_producto")
	private String nombre_producto;
	
	@Column(name = "cantidad_producto")
	private int cantidad_producto;
	
	@Column(name = "descripcion_producto")
	private String descripcion_producto;
	
	@Column(name = "precio_producto")
	private float precio_producto;
	
	@Column(name = "nombre_proveedor_producto")
	private String nombre_proveedor_producto;
	
	@ManyToOne(cascade = CascadeType.ALL )
	@JoinColumn(name = "id_categoria")
	private Categoria id_categoria;
	
	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinTable(
			name = "productos_proveedor",
			joinColumns = @JoinColumn(name = "codigo_Producto"),
			inverseJoinColumns = @JoinColumn(name = "codigo_Proveedor")
			)
	private List<Proveedor> proveedores = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinTable(
			name = "productos_clientes",
			joinColumns = @JoinColumn(name = "codigo_Producto"),
			inverseJoinColumns = @JoinColumn(name = "codigo_Cliente")
			)
	private List<Cliente> clientes = new ArrayList<>();
	
	@Column(name = "fecha_ingreso_producto")
	private Date fecha_ingreso_producto;
	
	@Column(name = "hora_ingreso")
	private String hora_ingreso;
	
	@Column(name = "foto_producto")
	private String foto_producto;
	
	public Producto() {
	
	}

	
	public Producto(Integer codigo_producto, String nombre_producto, int cantidad_producto, String descripcion_producto,
			float precio_producto, String nombre_proveedor_producto, Categoria id_categoria, List<Proveedor> proveedores,
			List<Cliente> clientes, Date fecha_ingreso_producto, String hora_ingreso, String foto_producto) {
		super();
		this.codigo_producto = codigo_producto;
		this.nombre_producto = nombre_producto;
		this.cantidad_producto = cantidad_producto;
		this.descripcion_producto = descripcion_producto;
		this.precio_producto = precio_producto;
		this.nombre_proveedor_producto = nombre_proveedor_producto;
		this.id_categoria = id_categoria;
		this.proveedores = proveedores;
		this.clientes = clientes;
		this.fecha_ingreso_producto = fecha_ingreso_producto;
		this.hora_ingreso = hora_ingreso;
		this.foto_producto = foto_producto;
	}

	public String getNombre_proveedor_producto() {
		return nombre_proveedor_producto;
	}

	public void setNombre_proveedor_producto(String nombre_proveedor_producto) {
		this.nombre_proveedor_producto = nombre_proveedor_producto;
	}


	public Integer getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Integer codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public float getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(float precio_producto) {
		this.precio_producto = precio_producto;
	}

	public Categoria getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Date getFecha_ingreso_producto() {
		return fecha_ingreso_producto;
	}

	public void setFecha_ingreso_producto(Date fecha_ingreso_producto) {
		this.fecha_ingreso_producto = fecha_ingreso_producto;
	}

	public String getHora_ingreso() {
		return hora_ingreso;
	}

	public void setHora_ingreso(String hora_ingreso) {
		this.hora_ingreso = hora_ingreso;
	}

	public String getFoto_producto() {
		return foto_producto;
	}

	public void setFoto_producto(String foto_producto) {
		this.foto_producto = foto_producto;
	}


	@Override
	public String toString() {
		return "Producto [codigo_producto=" + codigo_producto + ", nombre_producto=" + nombre_producto
				+ ", cantidad_producto=" + cantidad_producto + ", descripcion_producto=" + descripcion_producto
				+ ", precio_producto=" + precio_producto + ", nombre_proveedor_producto=" + nombre_proveedor_producto
				+ ", id_categoria=" + id_categoria + ", proveedores=" + proveedores + ", clientes=" + clientes
				+ ", fecha_ingreso_producto=" + fecha_ingreso_producto + ", hora_ingreso=" + hora_ingreso
				+ ", foto_producto=" + foto_producto + "]";
	}
	
	
}
