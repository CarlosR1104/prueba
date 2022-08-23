package com.muebles_valencia.servicios.empleado;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.muebles_valencia.entidades.empleado.*;

public interface ServicioEmpleado {
	
	public Iterable<Empleado> findAll();
	
	public Page<Empleado> findAll(Pageable pageable);
	
	public Optional<Empleado> findById(String identificacion);
	
	public Empleado save(Empleado empleado);
	
	public void deleteById(String cedula);

}
