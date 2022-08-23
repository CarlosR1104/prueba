package com.muebles_valencia.repositorio.cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles_valencia.entidades.cliente.Cliente;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, String>{
	
	public Optional<Cliente> findByNombreOrCorreo(String nombre, String correo);
	
	public Cliente findByNombre(String nombre);
	
	public Optional<Cliente> findByCorreo(String correo);
	
	public Boolean existsByNombre(String nombre);
	
	public Boolean existsByCorreo(String correo);
	
}
