package com.muebles_valencia.repositorio.proveedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles_valencia.entidades.proveedor.Proveedor;

@Repository
public interface RepositorioProveedor extends JpaRepository<Proveedor, String>{
	
	
}
