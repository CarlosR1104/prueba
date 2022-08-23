package com.muebles_valencia.servicios.administrador_empleado;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.muebles_valencia.entidades.administrador_empleado.Administrador_Empleado;
import com.muebles_valencia.repositorio.administrador_empleado.RepositorioAdministradorEmpleado;

@Service
public class ServicioAdministradorEmpleadoImpl implements ServicioAdministradorEmpleado{
	
	
	@Autowired
	private RepositorioAdministradorEmpleado administradorEmpleadoRepositorio;
	
	@Override
	public Iterable<Administrador_Empleado> findAll() {
		return administradorEmpleadoRepositorio.findAll();
	}

	@Override
	public Page<Administrador_Empleado> findAll(Pageable pageable) {
		return administradorEmpleadoRepositorio.findAll(pageable);
	}

	@Override
	public Optional<Administrador_Empleado> findById(Integer codigo) {
		return administradorEmpleadoRepositorio.findById(codigo);
	}

	@Override
	public Administrador_Empleado save(Administrador_Empleado administrador_empleado) {
		return administradorEmpleadoRepositorio.save(administrador_empleado);
	}

	@Override
	public void deleteById(Integer codigo) {
		administradorEmpleadoRepositorio.deleteById(codigo);
		
	}

	@Override
	public Administrador_Empleado buscarAdministradorEmpleado(String cedula_empleado) {
		return null;
	}
	
}
