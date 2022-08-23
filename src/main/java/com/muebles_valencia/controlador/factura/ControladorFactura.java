package com.muebles_valencia.controlador.factura;

import java.util.Optional;

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

import com.muebles_valencia.entidades.factura.Factura;
import com.muebles_valencia.servicios.facturas.ServicioFacturaImpl;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","null"})
@RequestMapping("/facturas")
public class ControladorFactura {
		
	@Autowired
	private ServicioFacturaImpl servicioFacturas;

	// Crear una factura
	//http://localhost:8080/facturas
	@PostMapping
	public ResponseEntity<?> registrarFactura(@RequestBody Factura factura) {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioFacturas.save(factura));
	}

	// Consultar factura en la base de datos
	//http://localhost:8080/facturas/consultarFactura/{id}
	@GetMapping("/consultarFactura/{id}")
	public ResponseEntity<?> consultarFacturas(@PathVariable(value = "id") int codigo) {
		Optional<Factura> oFactura = servicioFacturas.findById(codigo);
		if (!oFactura.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oFactura);
	}

	// Editar factura
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarFactura(@RequestBody Factura facturaActualizada,@PathVariable(value = "id")int codigo) {
		
		Optional<Factura> oFactura = servicioFacturas.findById(codigo);
		if (!oFactura.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//Este metodo sirve para modificar el objeto que queramos completo sin necesidad de ir propiedad por propiedad
		//BeanUtils.copyProperties(facturaActualizada, oFactura.get());
		
		oFactura.get().setNombre_cliente(facturaActualizada.getNombre_cliente());
		oFactura.get().setNombre_producto(facturaActualizada.getNombre_producto());
		oFactura.get().setDireccion_cliente(facturaActualizada.getDireccion_cliente());
		oFactura.get().setCantidad_producto(facturaActualizada.getCantidad_producto());
		oFactura.get().setTelefono_cliente(facturaActualizada.getTelefono_cliente());
		oFactura.get().setFecha_factura(facturaActualizada.getFecha_factura());
		oFactura.get().setTotal_a_pagar(facturaActualizada.getTotal_a_pagar());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioFacturas.save(oFactura.get()));
		}
		
		//Eliminar factura
		@DeleteMapping("/{id}")
		public ResponseEntity<?> eliminarFactura(@PathVariable(value = "id")int codigo){
			
			if(!servicioFacturas.findById(codigo).isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			servicioFacturas.deleteById(codigo);
			return ResponseEntity.ok().build();
		}

}
