package com.muebles_valencia.controlador.producto_proveedor;

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
import com.muebles_valencia.entidades.productos_proveedor.Productos_Proveedor;
import com.muebles_valencia.servicios.producto_proveedor.ServicioProductoProveedor;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","null"})
@RequestMapping("/productos_proveedores")
public class ControladorProductoProveedor {
	
	@Autowired
	private ServicioProductoProveedor servicioProductoProveedor;
	
	// Registrar un nuevo producto_proveedor
	//http://localhost:8080/productos_proveedores
	@PostMapping
	public ResponseEntity<?> registrarProductoProveedor(@RequestBody Productos_Proveedor producto_proveedor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioProductoProveedor.save(producto_proveedor));
	}
	
	// Consultar producto_proveedor en la base de datos
	//http://localhost:8080/productos_proveedores/buscarProductoProveedor/{codigo}
	@GetMapping("/buscarProductoProveedor/{codigo}")
	public ResponseEntity<?> consultarProductoProveedor(@PathVariable(value = "codigo")String identificacion) {
		Productos_Proveedor prod_prov = null;
		List<Productos_Proveedor> productos_proveedores = StreamSupport.stream(servicioProductoProveedor.findAll().spliterator(),false).collect(Collectors.toList());
		for (Productos_Proveedor productos_Proveedor : productos_proveedores) {
			if(productos_Proveedor.getCodigo_proveedor().equalsIgnoreCase(identificacion)) {
				prod_prov = new Productos_Proveedor();
				prod_prov.setCodigo_producto(productos_Proveedor.getCodigo_producto());
				prod_prov.setCodigo_proveedor(productos_Proveedor.getCodigo_proveedor());
			}
		}
		return ResponseEntity.ok(prod_prov);
	}
	
	// Editar producto_proveedor
	//http://localhost:8080/productos_proveedores/actualizarProductoProveedor/{codigo}
	@PutMapping("/actualizarProductoProveedor/{codigo}")
	public ResponseEntity<?> actualizarProductoProveedor(@RequestBody Productos_Proveedor prod_provActualizado,@PathVariable(value = "codigo") String identificacion) {
		Productos_Proveedor prod_prov = null;
		List<Productos_Proveedor> productos_proveedores = StreamSupport.stream(servicioProductoProveedor.findAll().spliterator(),false).collect(Collectors.toList());
		for (Productos_Proveedor productos_Proveedor : productos_proveedores) {
			if(productos_Proveedor.getCodigo_proveedor().equalsIgnoreCase(identificacion)) {
				prod_prov = new Productos_Proveedor();
				prod_prov.setConteo(prod_provActualizado.getConteo());
				prod_prov.setCodigo_producto(prod_provActualizado.getCodigo_producto());
				prod_prov.setCodigo_proveedor(prod_provActualizado.getCodigo_proveedor());
			}
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioProductoProveedor.save(prod_prov));
	}
	
	//Eliminar producto_proveedor
	//http://localhost:8080/productos_proveedores/eliminarProductoProveedor/{codigo}
	@DeleteMapping("/eliminarProductoProveedor/{codigo}")
	public ResponseEntity<?> eliminarProductoProveedor(@PathVariable(value = "id")Integer identificacion){
		
		if(!servicioProductoProveedor.findById(identificacion).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		servicioProductoProveedor.deleteById(identificacion);
		return ResponseEntity.ok().build();
	}
}
