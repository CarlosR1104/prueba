package com.muebles_valencia.repositorio.categoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles_valencia.entidades.categoria.Categoria;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Integer>{
	
	List<Categoria> findByNombreC(String nombre_categoria);
}
