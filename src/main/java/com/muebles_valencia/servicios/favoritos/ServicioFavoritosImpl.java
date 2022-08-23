package com.muebles_valencia.servicios.favoritos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.muebles_valencia.entidades.favoritos.Favoritos;
import com.muebles_valencia.repositorio.carritoCompra.RepositorioCarritoCompra;
import com.muebles_valencia.repositorio.favoritos.RepositorioFavoritos;


@Service
public class ServicioFavoritosImpl implements ServiciosFavoritos {
	
	@Autowired
	private RepositorioFavoritos favoritosR;

	@Override
	public Iterable<Favoritos> findAll() {
		
		return favoritosR.findAll();
	}

	@Override
	public Page<Favoritos> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return favoritosR.findAll(pageable);
	}

	@Override
	public Optional<Favoritos> findById(Integer codigo) {
		// TODO Auto-generated method stub
		return favoritosR.findById(codigo);
	}

	@Override
	public Favoritos save(Favoritos favoritos) {
		// TODO Auto-generated method stub
		return favoritosR.save(favoritos);
	}

	@Override
	public void deleteById(Integer codigo) {
		favoritosR.deleteById(codigo);
		
	}
	


}
