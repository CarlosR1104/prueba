package com.muebles_valencia.repositorio.administrador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles_valencia.entidades.administrador.Administrador;


@Repository
public interface RepositorioAdministrador extends JpaRepository<Administrador,Integer>{
	
	
	
}
