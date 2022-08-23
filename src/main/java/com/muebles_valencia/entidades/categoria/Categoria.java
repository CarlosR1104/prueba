package com.muebles_valencia.entidades.categoria;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.muebles_valencia.entidades.producto.Producto;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer id_categoria;
	
	@Column(name = "nombreC")
	private String nombreC;

	public Categoria() {
	
	}

	public Categoria(Integer id_categoria, String nombre_categoria) {
		super();
		this.id_categoria = id_categoria;
		this.nombreC= nombre_categoria;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombre_categoria() {
		return nombreC;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombreC= nombre_categoria;
	}
		
}
