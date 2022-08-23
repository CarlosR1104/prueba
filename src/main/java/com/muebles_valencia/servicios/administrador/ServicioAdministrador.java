package com.muebles_valencia.servicios.administrador;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.muebles_valencia.entidades.administrador.Administrador;

public interface ServicioAdministrador {
	
	public Iterable<Administrador> findAll();
	
	public Page<Administrador> findAll(Pageable pageable);
	
	public Optional<Administrador> findById(int codigo);
	
	public Administrador save(Administrador usuario);
	
	public void deleteById(int codigo);
	 
	public Administrador iniciarSesion(String correo , String password);
	
}
