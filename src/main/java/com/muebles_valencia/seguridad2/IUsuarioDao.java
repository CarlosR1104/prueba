package com.muebles_valencia.seguridad2;

import org.springframework.data.repository.CrudRepository;

import com.muebles_valencia.entidades.cliente.Cliente;

public interface IUsuarioDao extends CrudRepository<Cliente, String>{
	
	public Cliente findByCorreo(String correo);
	
}
