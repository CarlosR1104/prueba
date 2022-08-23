package com.muebles_valencia.repositorio.producto_cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles_valencia.entidades.productos_clientes.Productos_Clientes;

@Repository
public interface RepositorioProductoCliente extends JpaRepository<Productos_Clientes, Integer>{

}
