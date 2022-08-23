package com.muebles_valencia.servicios.proveedor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muebles_valencia.entidades.proveedor.Proveedor;
import com.muebles_valencia.repositorio.proveedor.RepositorioProveedor;

@Service
public class ServicioProveedorImpl implements ServicioProveedor{

	@Autowired
	private RepositorioProveedor proveedorRepositorio;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Proveedor> findAll() {
		return proveedorRepositorio.findAll();
	}

	@Override
	public Proveedor save(Proveedor proveedor) {
		return proveedorRepositorio.save(proveedor);
	}

	@Override
	public Optional<Proveedor> findById(String cedula) {
		return proveedorRepositorio.findById(cedula);
	}

	@Override
	public void deleteById(String cedula) {
		proveedorRepositorio.deleteById(cedula);
	}

}
