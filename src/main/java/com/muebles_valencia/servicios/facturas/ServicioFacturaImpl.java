package com.muebles_valencia.servicios.facturas;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muebles_valencia.entidades.cliente.Cliente;
import com.muebles_valencia.entidades.factura.Factura;
import com.muebles_valencia.repositorio.factura.RepositorioFactura;

@Service
public class ServicioFacturaImpl implements ServicioFactura{
	
	@Autowired
	private RepositorioFactura facturasRepositorio;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Factura> findAll() {
		return facturasRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Factura> findAll(Pageable pageable) {
		return facturasRepositorio.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Factura> findById(int codigo) {
		return facturasRepositorio.findById(codigo);
	}

	@Override
	@Transactional
	public Factura save(Factura factura) {
		return facturasRepositorio.save(factura);
	}

	@Override
	@Transactional
	public void deleteById(int codigo) {
		facturasRepositorio.deleteById(codigo);
	}
	
}
