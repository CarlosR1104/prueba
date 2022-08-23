package com.muebles_valencia.controlador.administrador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muebles_valencia.entidades.administrador.Administrador;
import com.muebles_valencia.servicios.administrador.ServicioAdministrador;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","null"})
@RequestMapping("/administradores")
public class ControladorAdministrador {
		
	@Autowired
	private ServicioAdministrador servicioAdministradores;
	
	// Crear un nuevo usuario
	@PostMapping("/registrarAdministrador")
	public ResponseEntity<?> registrarAdministrador(@RequestBody Administrador admin) {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioAdministradores.save(admin));
	}
	
	//http://localhost:8080/usuarios/iniciarSesion/j@gmail.com/123
	//Iniciar sesion
	@PostMapping("/iniciarSesion/{correo}/{password}")
	public ResponseEntity<?> inicioSesion(@PathVariable(value = "correo")String correo, @PathVariable(value = "password")String password){
		Optional<Administrador> oAdmin = Optional.ofNullable(servicioAdministradores.iniciarSesion(correo, password));
		if(!oAdmin.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oAdmin);
	}
	
	// Consultar usuario en la base de datos
	@GetMapping("/consultarAdministrador/{id}")
	public ResponseEntity<?> consultarAdministrador(@PathVariable(value = "id") int codigo) {
		Optional<Administrador> oAdmin = servicioAdministradores.findById(codigo);
		if (!oAdmin.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oAdmin);
	}

	
	// Editar usuario
	@PutMapping("/actualizarAdministrador/{id}")
	public ResponseEntity<?> actualizarAdministrador(@RequestBody Administrador adminActualizado,@PathVariable(value = "id") int codigo) {
		
		Optional<Administrador> oAdmin = servicioAdministradores.findById(codigo);
		if (!oAdmin.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//Este metodo sirve para modificar el objeto que queramos completo sin necesidad de ir propiedad por propiedad
		//BeanUtils.copyProperties(usuarioActualizado, oUsuario.get());
		
		oAdmin.get().setNombre_administrador(adminActualizado.getNombre_administrador());
		oAdmin.get().setCorreo_administrador(adminActualizado.getCorreo_administrador());
		oAdmin.get().setCodigo_administrador(null);
		oAdmin.get().setContraseña_administrador(adminActualizado.getContraseña_administrador());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioAdministradores.save(oAdmin.get()));
	}
	
	//Eliminar usuario
	@DeleteMapping("/elimininarAdministrador/{id}")
	public ResponseEntity<?> eliminarAdministrador(@PathVariable(value = "id")int codigo){
		
		if(!servicioAdministradores.findById(codigo).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		servicioAdministradores.deleteById(codigo);
		return ResponseEntity.ok().build();
	}
	
	//Consultar todos los administradores
	@GetMapping("/consultarTodosLosAdministradores")
	public List<Administrador> consultarTodosAdministradores(){
		List<Administrador> administradores = StreamSupport.stream(servicioAdministradores.findAll().spliterator(),false).collect(Collectors.toList());
		return administradores;
	
	}
}
