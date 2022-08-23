package com.muebles_valencia.controlador.proveedor;

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

import com.muebles_valencia.entidades.cliente.Cliente;
import com.muebles_valencia.entidades.proveedor.Proveedor;
import com.muebles_valencia.servicios.proveedor.ServicioProveedor;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","null"})
@RequestMapping("/proveedores")
public class ControladorProveedor {
	
	@Autowired
	private ServicioProveedor servicioProveedores;
	
	//Consultar todos los usuarios
	@GetMapping("/listaProveedores")
	public List<Proveedor> consultarProveedores(){
		List<Proveedor> proveedores = StreamSupport.stream(servicioProveedores.findAll().spliterator(),false).collect(Collectors.toList());
		return proveedores;
	
	}
	
	//Registrar un nuevo proveedor
	//http://localhost:8080/proveedores/registrarProveedor
	@PostMapping("/registrarProveedor")
	public ResponseEntity<Proveedor> registrarProveedor(@RequestBody Proveedor proveedor){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioProveedores.save(proveedor));
	}
	
	//Actualizar un proveedor
	//http://localhost:8080/proveedores/actualizarProveedor/{cedula}
	@PutMapping("/actualizarProveedor/{cedula}")
	public ResponseEntity<Proveedor> actualizarProveedor(@RequestBody Proveedor proveedorActualizado, @PathVariable ( value = "cedula") String cedula){	
		Optional<Proveedor> oProveedor = servicioProveedores.findById(cedula);
		if (!oProveedor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//Este metodo sirve para modificar el objeto que queramos completo sin necesidad de ir propiedad por propiedad
		//BeanUtils.copyProperties(usuarioActualizado, oUsuario.get());
		
		oProveedor.get().setNombre_proveedor(proveedorActualizado.getNombre_proveedor());
		oProveedor.get().setTelefono_proveedor(proveedorActualizado.getTelefono_proveedor());
		oProveedor.get().setCedula_proveedor(proveedorActualizado.getCedula_proveedor());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioProveedores.save(oProveedor.get()));
	}
	
	//Buscar un proveedor por cedula
	//http://localhost:8080/proveedores/buscarProveedor/{cedula}
	@GetMapping("/buscarProveedor/{cedula}")
	public ResponseEntity<Proveedor> buscarProveedor(@PathVariable (value = "cedula")String cedula){
		
		Optional<Proveedor> oProveedor = servicioProveedores.findById(cedula);
		if (!oProveedor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		
		oProveedor.get().setNombre_proveedor(oProveedor.get().getNombre_proveedor());
		oProveedor.get().setTelefono_proveedor(oProveedor.get().getTelefono_proveedor());
		oProveedor.get().setCedula_proveedor(oProveedor.get().getCedula_proveedor());
		
		return ResponseEntity.status(HttpStatus.FOUND).body(servicioProveedores.save(oProveedor.get()));
	
	}
	
	//Eliminar un proveedor
	//http://localhost:8080/proveedores/eliminarProveedor/{cedula}
	@DeleteMapping("/eliminarProveedor/{cedula}")
	public ResponseEntity<Proveedor> eliminarProveedor(@PathVariable(value = "cedula")String cedula){
		
		if(!servicioProveedores.findById(cedula).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		servicioProveedores.deleteById(cedula);
		return ResponseEntity.ok().build();
	
	}
}
