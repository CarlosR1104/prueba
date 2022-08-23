package com.muebles_valencia.servicios.producto_proveedor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.muebles_valencia.entidades.productos_proveedor.Productos_Proveedor;
import com.muebles_valencia.repositorio.producto_proveedor.RepositorioProductoProveedor;

@Service
public class ServicioProductoProveedorImpl implements ServicioProductoProveedor{
	
	@Autowired
	private RepositorioProductoProveedor repositorioProductoProveedor;

	@Override
	public Iterable<Productos_Proveedor> findAll() {
		return repositorioProductoProveedor.findAll();
	}

	@Override
	public Page<Productos_Proveedor> findAll(Pageable pageable) {
		return repositorioProductoProveedor.findAll(pageable);
	}

	@Override
	public Optional<Productos_Proveedor> findById(Integer codigo) {
		return repositorioProductoProveedor.findById(codigo);
	}

	@Override
	public Productos_Proveedor save(Productos_Proveedor producto_proveedor) {
		return repositorioProductoProveedor.save(producto_proveedor);
	}

	@Override
	public void deleteById(Integer codigo) {
		repositorioProductoProveedor.deleteById(codigo);
	}
	
	
}
