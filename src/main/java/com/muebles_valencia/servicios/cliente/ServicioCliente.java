package com.muebles_valencia.servicios.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.muebles_valencia.entidades.cliente.Cliente;
import com.muebles_valencia.entidades.cliente.ClienteDTO;

public interface ServicioCliente {
	
	public List<ClienteDTO> obtenerTodosLosClientes();
	
	public Optional<Cliente> findById(String identificacion);
	
	public Cliente save(Cliente usuario);
	
	public void deleteById(String identificacion);
	 
	public Cliente iniciarSesion(String correo , String password);
	
	public ClienteDTO crearCliente(ClienteDTO clienteDTO);

	public List<Cliente> findAll();
}
