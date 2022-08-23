package com.muebles_valencia.repositorio.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles_valencia.entidades.producto.Producto;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Integer>{

}
