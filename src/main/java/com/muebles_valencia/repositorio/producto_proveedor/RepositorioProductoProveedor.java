package com.muebles_valencia.repositorio.producto_proveedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles_valencia.entidades.productos_proveedor.Productos_Proveedor;

@Repository
public interface RepositorioProductoProveedor extends JpaRepository<Productos_Proveedor, Integer>{
	

}
