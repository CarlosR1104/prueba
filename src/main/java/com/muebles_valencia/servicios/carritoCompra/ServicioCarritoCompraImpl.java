package com.muebles_valencia.servicios.carritoCompra;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.muebles_valencia.entidades.carritoCompra.CarritoCompra;
import com.muebles_valencia.repositorio.carritoCompra.RepositorioCarritoCompra;

@Service
public class ServicioCarritoCompraImpl implements ServicioCarritoCompra{
	
	@Autowired
	private RepositorioCarritoCompra carritoCompraRepositorio;
	
	@Override
	public List<CarritoCompra> findAll() {
		return carritoCompraRepositorio.findAll();
	}

	@Override
	public Page<CarritoCompra> findAll(Pageable pageable) {
		return carritoCompraRepositorio.findAll(pageable);
	}

	@Override
	public Optional<CarritoCompra> findById(Integer codigo) {
		return carritoCompraRepositorio.findById(codigo);
	}

	@Override
	public CarritoCompra save(CarritoCompra carritoCompra) {
		return carritoCompraRepositorio.save(carritoCompra);
	}

	@Override
	public void deleteById(Integer codigo) {
		carritoCompraRepositorio.deleteById(codigo);
		
	}
}
