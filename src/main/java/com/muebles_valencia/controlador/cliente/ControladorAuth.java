package com.muebles_valencia.controlador.cliente;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muebles_valencia.entidades.DTO.LoginDTO;
import com.muebles_valencia.entidades.DTO.RegistroDTO;
import com.muebles_valencia.entidades.cliente.Cliente;
import com.muebles_valencia.entidades.cliente.Rol;
import com.muebles_valencia.repositorio.cliente.RepositorioCliente;
import com.muebles_valencia.repositorio.rol.RepositorioRol;
@RestController
@RequestMapping("/api/auth")
public class ControladorAuth {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private RepositorioCliente clienteRepositorio;
	
	@Autowired
	private RepositorioRol rolRepositorio;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
		
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO registroDTO){
		if(clienteRepositorio.existsByNombre(registroDTO.getUsername())) {
			return new ResponseEntity<>("Ese nombre de usuario ya existe",HttpStatus.BAD_REQUEST);
		}
		
		if(clienteRepositorio.existsByCorreo(registroDTO.getEmail())) {
			return new ResponseEntity<>("Ese email de usuario ya existe",HttpStatus.BAD_REQUEST);
		}
		
		Cliente cliente = new Cliente();
		cliente.setNombre(registroDTO.getNombre());
		cliente.setApellido_cliente(registroDTO.getUsername());
		cliente.setCorreo(registroDTO.getEmail());
		cliente.setContraseña_cliente(passwordEncoder.encode(registroDTO.getPassword()));
		
		Rol roles = rolRepositorio.findByNombre("ROLE_ADMIN").get();
		cliente.setRoles(Collections.singleton(roles));
		
		clienteRepositorio.save(cliente);
		return new ResponseEntity<>("Cliente registrado exitosamente",HttpStatus.OK);
	}
	
}
