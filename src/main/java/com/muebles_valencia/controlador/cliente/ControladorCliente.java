package com.muebles_valencia.controlador.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
**/
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muebles_valencia.entidades.cliente.Cliente;
import com.muebles_valencia.entidades.cliente.ClienteDTO;
import com.muebles_valencia.servicios.cliente.ServicioCliente;
import com.muebles_valencia.servicios.correo.EnviadorDeCorreos;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "null" })
@RequestMapping("/clientes")
public class ControladorCliente {

	@Autowired
	private ServicioCliente servicioClientes;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// Registrar un nuevo usuario
	// http://localhost:8080/clientes
	@PostMapping
	public ResponseEntity<?> registrarUsuario(@RequestBody Cliente cliente) {
		cliente.setEstado_cliente(1);
		cliente.setContraseña_cliente(passwordEncoder.encode(cliente.getContraseña_cliente()));
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioClientes.save(cliente));
	}
	
	@PostMapping("/registrarCliente")
	public ResponseEntity<ClienteDTO> registrarClienteDTO(@RequestBody ClienteDTO clientedto) {
		clientedto.setEstado_cliente(1);
		return new ResponseEntity<>(servicioClientes.crearCliente(clientedto),HttpStatus.CREATED);
	}
	
	// http://localhost:8080/clientes/iniciarSesion/j@gmail.com/123
	// Iniciar sesion
	@PostMapping("/iniciarSesion/{correo}/{password}")
	public ResponseEntity<?> inicioSesion(@PathVariable(value = "correo") String correo,
			@PathVariable(value = "password") String password) {
		Optional<Cliente> oCliente = Optional.ofNullable(servicioClientes.iniciarSesion(correo, password));
		if (!oCliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicioClientes.iniciarSesion(correo, password));
	}

	// Consultar usuario en la base de datos
	@GetMapping("/buscarCliente/{id}")
	public ResponseEntity<?> consultarUsuarios(@PathVariable(value = "id") String identificacion) {
		Cliente cli = null;
		List<Cliente> clientes = StreamSupport.stream(servicioClientes.findAll().spliterator(), false)
				.collect(Collectors.toList());
		for (Cliente cliente : clientes) {
			if (cliente.getCedula_cliente().equalsIgnoreCase(identificacion)) {
				cli = new Cliente();
				cli.setNombre(cliente.getNombre());
				cli.setApellido_cliente(cliente.getApellido_cliente());
				cli.setCedula_cliente(cliente.getCedula_cliente());
				cli.setCelular_cliente(cliente.getCelular_cliente());
				cli.setCorreo(cliente.getCorreo());
				cli.setFecha_nacimin_cliente(cliente.getFecha_nacimin_cliente());
				cli.setCodigo_cliente(cliente.getCodigo_cliente());
			}
		}
		return ResponseEntity.ok(cli);
	}

	// Editar usuario
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarUsuario(@RequestBody Cliente usuarioActualizado,
			@PathVariable(value = "id") String identificacion) {

		Optional<Cliente> oUsuario = servicioClientes.findById(identificacion);
		if (!oUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		// Este metodo sirve para modificar el objeto que queramos completo sin
		// necesidad de ir propiedad por propiedad
		// BeanUtils.copyProperties(usuarioActualizado, oUsuario.get());

		oUsuario.get().setNombre(usuarioActualizado.getNombre());
		oUsuario.get().setCedula_cliente(usuarioActualizado.getCedula_cliente());
		oUsuario.get().setApellido_cliente(usuarioActualizado.getApellido_cliente());
		oUsuario.get().setCorreo(usuarioActualizado.getCorreo());
		oUsuario.get().setCelular_cliente(usuarioActualizado.getCelular_cliente());
		oUsuario.get().setContraseña_cliente(usuarioActualizado.getContraseña_cliente());
		oUsuario.get().setCodigo_cliente(usuarioActualizado.getCodigo_cliente());
		oUsuario.get().setFecha_nacimin_cliente(usuarioActualizado.getFecha_nacimin_cliente());
		oUsuario.get().setCarrito(usuarioActualizado.getCarrito());

		return ResponseEntity.status(HttpStatus.CREATED).body(servicioClientes.save(oUsuario.get()));
	}

	// Eliminar usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable(value = "id") String identificacion) {

		if (!servicioClientes.findById(identificacion).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		servicioClientes.deleteById(identificacion);
		return ResponseEntity.ok().build();
	}

	// Consultar todos los usuarios
	@GetMapping("/listaClientes")
	public List<ClienteDTO> consultarTodosClientes() {
		return servicioClientes.obtenerTodosLosClientes();

	}
/**
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Cliente> clientes = StreamSupport.stream(servicioClientes.findAll().spliterator(), false)
				.collect(Collectors.toList());
		Cliente cliente = null;
		System.out.println("LISTA CLIENTES " +clientes);
		for (Cliente cli : clientes) {
			if (cli.getCorreo().equalsIgnoreCase(username)) {
				cliente = new Cliente();
				cliente.setCorreo(cli.getCorreo());
				cliente.setContraseña_cliente(cli.getContraseña_cliente());
			}
		}
		return new User(cliente.getCorreo(), cliente.getContraseña_cliente(),buildgrante(cliente.getEstado_cliente()));
	}
	
	public List<GrantedAuthority> buildgrante(int estado){
		
		String[] roles = {"CLIENTE" , "EMPLEADO" , "ADMIN" };
		List<GrantedAuthority> auths = new ArrayList<>();
		
		for(int i = 0 ; i < estado ; i++) {
			auths.add(new SimpleGrantedAuthority(roles[i]));
		}
		
		return auths;
	}
	**/
}
