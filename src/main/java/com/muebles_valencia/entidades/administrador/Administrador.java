package com.muebles_valencia.entidades.administrador;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.muebles_valencia.entidades.empleado.Empleado;
import com.muebles_valencia.entidades.proveedor.Proveedor;

@Entity
@Table(name = "administradores")
public class Administrador implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_administrador")
	private Integer codigo_administrador;
	
	@Column(name = "nombre_administrador")
	private String nombre_administrador;
	
	@Column(name = "correo_administrador")
	private String correo_administrador;
	
	@Column(name = "contraseña_administrador")
	private String contraseña_administrador;
	
	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinTable(
			name = "administradores_empleados",
			joinColumns = @JoinColumn(name = "codigo_Administrador"),
			inverseJoinColumns = @JoinColumn(name = "codigo_Empleado")
			)
	private List<Empleado> empleados = new ArrayList<>();

	public Administrador() {
	
	}

	public Administrador(Integer codigo_administrador, String nombre_administrador, String correo_administrador,
			String contraseña_administrador, List<Empleado> empleados) {
		super();
		this.codigo_administrador = codigo_administrador;
		this.nombre_administrador = nombre_administrador;
		this.correo_administrador = correo_administrador;
		this.contraseña_administrador = contraseña_administrador;
		this.empleados = empleados;
	}

	public Integer getCodigo_administrador() {
		return codigo_administrador;
	}

	public void setCodigo_administrador(Integer codigo_administrador) {
		this.codigo_administrador = codigo_administrador;
	}

	public String getNombre_administrador() {
		return nombre_administrador;
	}

	public void setNombre_administrador(String nombre_administrador) {
		this.nombre_administrador = nombre_administrador;
	}

	public String getCorreo_administrador() {
		return correo_administrador;
	}

	public void setCorreo_administrador(String correo_administrador) {
		this.correo_administrador = correo_administrador;
	}

	public String getContraseña_administrador() {
		return contraseña_administrador;
	}

	public void setContraseña_administrador(String contraseña_administrador) {
		this.contraseña_administrador = contraseña_administrador;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
}
