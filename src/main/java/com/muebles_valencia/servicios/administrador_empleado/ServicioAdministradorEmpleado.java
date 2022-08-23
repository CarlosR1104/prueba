package com.muebles_valencia.servicios.administrador_empleado;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.muebles_valencia.entidades.administrador_empleado.*;

public interface ServicioAdministradorEmpleado {
	
	public Iterable<Administrador_Empleado> findAll();
	
	public Page<Administrador_Empleado> findAll(Pageable pageable);
	
	public Optional<Administrador_Empleado> findById(Integer codigo);
	
	public Administrador_Empleado save(Administrador_Empleado administrador_empleado);
	
	public void deleteById(Integer codigo);
	
	public Administrador_Empleado buscarAdministradorEmpleado(String cedula_empleado);

}
