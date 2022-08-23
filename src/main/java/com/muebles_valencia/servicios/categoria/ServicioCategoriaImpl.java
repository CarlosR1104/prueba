package com.muebles_valencia.servicios.categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.muebles_valencia.entidades.categoria.Categoria;
import com.muebles_valencia.repositorio.categoria.RepositorioCategoria;

@Service
public class ServicioCategoriaImpl implements ServicioCategoria{

	@Autowired
	private RepositorioCategoria categoriaRepositorio;
	
	@Override
	public Iterable<Categoria> findAll() {
		return categoriaRepositorio.findAll();
	}

	@Override
	public Page<Categoria> findAll(Pageable pageable) {
		return categoriaRepositorio.findAll(pageable);
	}

	@Override
	public Optional<Categoria> findById(Integer codigo_categoria) {
		return categoriaRepositorio.findById(codigo_categoria);
	}

	@Override
	public Categoria save(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}

	@Override
	public void deleteById(Integer codigo_categoria) {
		categoriaRepositorio.deleteById(codigo_categoria);
	}

}
