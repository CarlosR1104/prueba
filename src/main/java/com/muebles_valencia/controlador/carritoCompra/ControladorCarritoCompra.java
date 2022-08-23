package com.muebles_valencia.controlador.carritoCompra;

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

import com.muebles_valencia.entidades.carritoCompra.CarritoCompra;
import com.muebles_valencia.entidades.producto.Producto;
import com.muebles_valencia.servicios.carritoCompra.ServicioCarritoCompra;
import com.muebles_valencia.servicios.carritoCompra.ServicioCarritoCompraImpl;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","null"})
@RequestMapping("/carritoCompras")
public class ControladorCarritoCompra {
	
	@Autowired
	private ServicioCarritoCompra carritoCompraServicio;
	
	// Registrar un nuevo carrito
	//http://localhost:8080/carritoCompras
	@PostMapping
	public ResponseEntity<?> registrarCarritoCompras(@RequestBody CarritoCompra carritoCompra) {
		return ResponseEntity.status(HttpStatus.CREATED).body(carritoCompraServicio.save(carritoCompra));
	}
	
	// Editar carrito
	//http://localhost:8080/carritoCompras/actualizarCarrito/{codigo}
	@PutMapping("/actualizarCarrito/{codigo}")
	public ResponseEntity<?> actualizarCarritoCompra(@RequestBody CarritoCompra carritoCompraActualizado,@PathVariable(value = "codigo") Integer codigo) {
		
		Optional<CarritoCompra> oCarritoCompra = carritoCompraServicio.findById(codigo);
		if (!oCarritoCompra.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(carritoCompraActualizado, oCarritoCompra.get());
		
				
		return ResponseEntity.status(HttpStatus.CREATED).body(carritoCompraServicio.save(oCarritoCompra.get()));
	}
	
	
	//http://localhost:8080/carritoCompras/listarcarrito
	@GetMapping("/listarcarrito")
	public List<CarritoCompra> listarProductos(){
		List<CarritoCompra> carrito = null;
		try {
			carrito=(List<CarritoCompra>) carritoCompraServicio.findAll();
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return carrito;
	}	
	
	//Eliminar carrito
	//http://localhost:8080/carritoCompras/eliminarCarrito/{codigo}
	@DeleteMapping("/eliminarCarrito/{codigo}")
	public ResponseEntity<?> eliminarCarritoCompra(@PathVariable(value = "codigo")Integer codigo){
		
		if(!carritoCompraServicio.findById(codigo).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		carritoCompraServicio.deleteById(codigo);
		return ResponseEntity.ok().build();
	}
	
	// Consultar usuario en la base de datos
	@GetMapping("/buscarCarritoCompra/{codigo}")
	public ResponseEntity<?> consultarCarritoCompra(@PathVariable(value = "codigo") Integer codigo) {
		CarritoCompra carritoComp = null;
		List<CarritoCompra> carritosCompra = StreamSupport.stream(carritoCompraServicio.findAll().spliterator(),false).collect(Collectors.toList());
		for (CarritoCompra carritos : carritosCompra) {
			if(carritos.getCodigo_Carrito() == codigo) {
				carritoComp = new CarritoCompra();
				carritoComp.setNombre__producto(carritos.getNombre__producto());
				carritoComp.setDescripcion_producto(carritos.getDescripcion_producto());
				carritoComp.setCodigo_Carrito(carritos.getCodigo_Carrito());
				carritoComp.setPrecio_total(carritos.getPrecio_total());
			}
		}
		return ResponseEntity.ok(carritoComp);
	}

}
