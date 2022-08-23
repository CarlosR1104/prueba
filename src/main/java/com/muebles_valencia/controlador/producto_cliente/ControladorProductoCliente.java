package com.muebles_valencia.controlador.producto_cliente;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
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
import com.muebles_valencia.entidades.productos_clientes.Productos_Clientes;
import com.muebles_valencia.servicios.producto_cliente.ServicioProductoCliente;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","null"})
@RequestMapping("/producto_cliente")
public class ControladorProductoCliente {
	
	@Autowired
	private ServicioProductoCliente servicioProductoCliente;
	
	// Registrar un nuevo producto relacionado con el cliente
	//http://localhost:8080/producto_cliente
	@PostMapping
	public ResponseEntity<?> registrarProductoCliente(@RequestBody Productos_Clientes producto_cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioProductoCliente.save(producto_cliente));
	}
	
	// Consultar producto_cliente
	//http://localhost:8080/producto_cliente/buscarProductoCliente/{codigo}
	@GetMapping("/buscarProductoCliente/{codigo}")
	public ResponseEntity<?> consultarProductoCliente(@PathVariable(value = "codigo")String cedula_cliente) {
		Productos_Clientes pro_cli = servicioProductoCliente.buscarProductoCliente(cedula_cliente);
		if(pro_cli.getCodigo_Cliente().equalsIgnoreCase(cedula_cliente)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(pro_cli);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pro_cli);
	}
	
	// Editar producto_cliente
	//http://localhost:8080/producto_cliente/actualizarProductoCliente/{codigo}
	@PutMapping("/actualizarProductoCliente/{codigo}")
	public ResponseEntity<?> actualizarProductoCliente(@RequestBody Productos_Clientes prod_cliActualizado,@PathVariable(value = "codigo") String identificacion) {
		
		Productos_Clientes oProdCli= servicioProductoCliente.buscarProductoCliente(identificacion);
		if (oProdCli == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(prod_cliActualizado, oProdCli);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioProductoCliente.save(oProdCli));
	}
	
	//Eliminar producto_cliente
	//http://localhost:8080/producto_cliente/eliminarProductoCliente/{codigo}
	@DeleteMapping("/eliminarProductoCliente/{codigo}")
	public ResponseEntity<?> eliminarProductoCliente(@PathVariable(value = "codigo")String cedula){
	
		Productos_Clientes prod_cli = servicioProductoCliente.buscarProductoCliente(cedula);
		if(prod_cli == null) {
			return ResponseEntity.notFound().build();
		}
		
		servicioProductoCliente.deleteById(prod_cli.getConteo());
		return ResponseEntity.ok().build();
	}
		
}
