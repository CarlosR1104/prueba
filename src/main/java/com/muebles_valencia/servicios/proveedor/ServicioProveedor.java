package com.muebles_valencia.servicios.proveedor;

import java.util.Optional;

import com.muebles_valencia.entidades.proveedor.Proveedor;

public interface ServicioProveedor{
	
	public Iterable<Proveedor> findAll();
	
	public Proveedor save(Proveedor proveedor);
	
	public Optional<Proveedor> findById(String cedula);
	
	public void deleteById(String cedula);
}
