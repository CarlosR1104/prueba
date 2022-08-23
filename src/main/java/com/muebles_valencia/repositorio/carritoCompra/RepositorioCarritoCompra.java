package com.muebles_valencia.repositorio.carritoCompra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles_valencia.entidades.carritoCompra.CarritoCompra;

@Repository
public interface RepositorioCarritoCompra extends JpaRepository<CarritoCompra, Integer>{

}
