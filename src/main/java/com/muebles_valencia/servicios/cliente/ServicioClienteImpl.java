package com.muebles_valencia.servicios.cliente;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muebles_valencia.entidades.cliente.Cliente;
import com.muebles_valencia.entidades.cliente.ClienteDTO;
import com.muebles_valencia.repositorio.cliente.RepositorioCliente;

@Service
public class ServicioClienteImpl implements ServicioCliente {

	@Autowired
	private RepositorioCliente clienteRepositorio;

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findById(String identificacion) {
		return clienteRepositorio.findById(identificacion);
	}

	@Override
	@Transactional
	public Cliente save(Cliente usuario) {
		return clienteRepositorio.save(usuario);
	}

	@Override
	@Transactional
	public void deleteById(String identificacion) {
		clienteRepositorio.deleteById(identificacion);
	}

	@SuppressWarnings("null")
	@Override
	@Transactional
	public Cliente iniciarSesion(String correo , String password) {

		List<Cliente> clientes = clienteRepositorio.findAll();
		Optional<Cliente> cli = null;
		Cliente cliFinal = null;

		
	
		System.out.println("ENTRA");
		for (Cliente p : clientes) {
			if(p.getCorreo().equalsIgnoreCase(correo)) {
				if(p.getContraseña_cliente().equalsIgnoreCase(password)) {
					System.out.println("INGRESA" + p.getCedula_cliente());

					cli =  clienteRepositorio.findById(p.getCedula_cliente());
					if(cli.isPresent()) {
						cliFinal = new Cliente();
						cliFinal.setNombre(cli.get().getNombre());

						cliFinal = new Cliente();
						cliFinal.setNombre(cli.get().getNombre());
						cliFinal.setApellido_cliente(cli.get().getApellido_cliente());
						cliFinal.setCorreo(correo);
						cliFinal.setCedula_cliente(cli.get().getCedula_cliente());
						cliFinal.setCelular_cliente(cli.get().getCelular_cliente());
						cli = clienteRepositorio.findById(p.getCedula_cliente());


					}else {
						cliFinal = new Cliente();
						cliFinal.setNombre("");
						cliFinal.setApellido_cliente("");
						cliFinal.setCorreo("");
						cliFinal.setCedula_cliente("");
						cliFinal.setCelular_cliente("");
					}
				
				}else {
					cliFinal = new Cliente();
					cliFinal.setNombre("");
					cliFinal.setApellido_cliente("");
					cliFinal.setCorreo("");
					cliFinal.setCedula_cliente("");
					cliFinal.setCelular_cliente("");
				}
			}else {
				cliFinal = new Cliente();
				cliFinal.setNombre("");
				cliFinal.setApellido_cliente("");
				cliFinal.setCorreo("");
				cliFinal.setCedula_cliente("");
				cliFinal.setCelular_cliente("");
				}
		}
		return cliFinal;
	}

	@Override
	public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
		//Convertimos DTO a entidad
		Cliente cliente = mapearEntidad(clienteDTO);
		
		Cliente nuevoCliente = clienteRepositorio.save(cliente);
		
		//Convertimos de entidad a DTO
		
		ClienteDTO clienteRespuesta = mapearDTO(nuevoCliente);
		
		return clienteRespuesta;
	}

	@Override
	public List<ClienteDTO> obtenerTodosLosClientes() {
		List<Cliente> clientes = clienteRepositorio.findAll();
		return clientes.stream().map(cliente -> mapearDTO(cliente)).collect(Collectors.toList());
	}
	
	private ClienteDTO mapearDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		
		clienteDTO.setNombre_cliente(cliente.getNombre());
		clienteDTO.setApellido_cliente(cliente.getApellido_cliente());
		clienteDTO.setCedula_cliente(cliente.getCedula_cliente());
		clienteDTO.setCelular_cliente(cliente.getCelular_cliente());
		clienteDTO.setCorreo_cliente(cliente.getCorreo());
		clienteDTO.setContraseña_cliente(cliente.getContraseña_cliente());
		clienteDTO.setFecha_nacimin_cliente(cliente.getFecha_nacimin_cliente());
		clienteDTO.setCodigo_cliente(cliente.getCodigo_cliente());
		
		return clienteDTO;
	}
	
	private Cliente mapearEntidad(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setNombre(clienteDTO.getNombre_cliente());
		cliente.setApellido_cliente(clienteDTO.getApellido_cliente());
		cliente.setCedula_cliente(clienteDTO.getCedula_cliente());
		cliente.setCelular_cliente(clienteDTO.getCelular_cliente());
		cliente.setCorreo(clienteDTO.getCorreo_cliente());
		cliente.setContraseña_cliente(clienteDTO.getContraseña_cliente());
		cliente.setFecha_nacimin_cliente(clienteDTO.getFecha_nacimin_cliente());
		cliente.setCodigo_cliente(clienteDTO.getCodigo_cliente());
		
		return cliente;
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
