package com.muebles_valencia.servicios.empleado;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.muebles_valencia.entidades.empleado.Empleado;
import com.muebles_valencia.repositorio.empleado.RepositorioEmpleado;

@Service
public class ServicioEmpleadoImpl implements ServicioEmpleado{

	@Autowired
	private RepositorioEmpleado empleadoRepositorio;
	
	@Override
	public Iterable<Empleado> findAll() {
		return empleadoRepositorio.findAll();
	}

	@Override
	public Page<Empleado> findAll(Pageable pageable) {
		return empleadoRepositorio.findAll(pageable);
	}

	@Override
	public Optional<Empleado> findById(String cedula) {
		return empleadoRepositorio.findById(cedula);
	}

	@Override
	public Empleado save(Empleado empleado) {
		return empleadoRepositorio.save(empleado);
	}

	@Override
	public void deleteById(String cedula) {
		empleadoRepositorio.deleteById(cedula);
	}
	
}
