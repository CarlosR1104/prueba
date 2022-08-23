package com.muebles_valencia.servicios.facturas;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.muebles_valencia.entidades.factura.Factura;

public interface ServicioFactura {
	
	public Iterable<Factura> findAll();
	
	public Page<Factura> findAll(Pageable pageable);
	
	public Optional<Factura> findById(int codigo);
	
	public Factura save(Factura factura);
	
	public void deleteById(int codigo);
	
	
}
