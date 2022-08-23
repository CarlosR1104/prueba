package com.muebles_valencia.servicios.categoria;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.muebles_valencia.entidades.categoria.*;

public interface ServicioCategoria {
	
	public Iterable<Categoria> findAll();
	
	public Page<Categoria> findAll(Pageable pageable);
	
	public Optional<Categoria> findById(Integer codigo_categoria);
	
	public Categoria save(Categoria usuario);
	
	public void deleteById(Integer codigo_categoria);
	 
}
