package com.muebles_valencia.servicios.productos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.muebles_valencia.entidades.producto.Producto;

public interface ServicioProducto {
	
	public Producto save(Producto producto);
	
	public Iterable<Producto> findAll();
	
	public Optional<Producto> findById(int codigo);
	
	public void deleteById(int codigo);
	
	public List<Producto> filtrarPrecio(float minimo , float maximo);
	
	public List<Producto> filtrarCategoria(String categoria);
	
	public List<Producto> productosNuevos(int mes , int anio);
}
