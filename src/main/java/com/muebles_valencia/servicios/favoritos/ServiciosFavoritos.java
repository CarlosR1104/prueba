package com.muebles_valencia.servicios.favoritos;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.muebles_valencia.entidades.favoritos.Favoritos;

public interface ServiciosFavoritos {
	
	public Iterable<Favoritos> findAll();
	
	public Page<Favoritos> findAll(Pageable pageable);
	
	public Optional<Favoritos> findById(Integer codigo);
	
	public Favoritos save(Favoritos favoritos);
	
	public void deleteById(Integer codigo);
}


