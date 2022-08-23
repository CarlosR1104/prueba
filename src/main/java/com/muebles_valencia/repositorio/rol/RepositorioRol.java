package com.muebles_valencia.repositorio.rol;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles_valencia.entidades.cliente.Rol;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Long>{
	
	public Optional<Rol> findByNombre(String nombre);
	
}
