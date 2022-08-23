package com.muebles_valencia.servicios.producto_cliente;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.muebles_valencia.entidades.productos_clientes.Productos_Clientes;


public interface ServicioProductoCliente {
	
	public Iterable<Productos_Clientes> findAll();
	
	public Page<Productos_Clientes> findAll(Pageable pageable);
	
	public Optional<Productos_Clientes> findById(Integer codigo);
	
	public Productos_Clientes save(Productos_Clientes producto_cliente);
	
	public void deleteById(Integer codigo);
	
	public Productos_Clientes buscarProductoCliente(String cedula_cliente);

}
