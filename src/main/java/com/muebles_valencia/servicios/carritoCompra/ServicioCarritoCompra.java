package com.muebles_valencia.servicios.carritoCompra;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.muebles_valencia.entidades.carritoCompra.*;
import com.muebles_valencia.entidades.categoria.Categoria;
import com.muebles_valencia.entidades.producto.Producto;

public interface ServicioCarritoCompra {
	
//	public List<CarritoCompra> findAll();
	
	public Iterable<CarritoCompra> findAll();
	
	public Page<CarritoCompra> findAll(Pageable pageable);
	
	public Optional<CarritoCompra> findById(Integer codigo);
	
	public CarritoCompra save(CarritoCompra carritoCompra);
	
	public void deleteById(Integer codigo);
	 
}
