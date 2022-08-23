package com.muebles_valencia.servicios.producto_proveedor;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.muebles_valencia.entidades.productos_proveedor.Productos_Proveedor;

public interface ServicioProductoProveedor {
	
	public Iterable<Productos_Proveedor> findAll();
	
	public Page<Productos_Proveedor> findAll(Pageable pageable);
	
	public Optional<Productos_Proveedor> findById(Integer codigo);
	
	public Productos_Proveedor save(Productos_Proveedor producto_proveedor);
	
	public void deleteById(Integer codigo);
	
}
