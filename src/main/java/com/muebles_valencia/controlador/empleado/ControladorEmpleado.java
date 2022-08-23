package com.muebles_valencia.controlador.empleado;

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
import com.muebles_valencia.entidades.empleado.*;
import com.muebles_valencia.servicios.empleado.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","null"})
@RequestMapping("/empleados")
public class ControladorEmpleado {
	
	@Autowired
	private ServicioEmpleado servicioEmpleados;
	
	// Registrar un nuevo empleado
	//http://localhost:8080/empleados
	@PostMapping
	public ResponseEntity<?> registrarEmpleado(@RequestBody Empleado empleado) {
		empleado.setEstado_empleado(2);
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioEmpleados.save(empleado));
	}
	
	// Consultar empleado en la base de datos
	@GetMapping("/buscarEmpleado/{cedula}")
	public ResponseEntity<?> consultarEmpleado(@PathVariable(value = "cedula") String cedula) {
		Empleado empleado = null;
		List<Empleado> empleados = StreamSupport.stream(servicioEmpleados.findAll().spliterator(),false).collect(Collectors.toList());
		for (Empleado empl : empleados) {
			if(empl.getCedula_empleado().equalsIgnoreCase(cedula)) {
				empleado = new Empleado();
				empleado.setNombre_empleado(empl.getNombre_empleado());
				empleado.setCedula_empleado(empl.getCedula_empleado());
				empleado.setEstado_empleado(empl.getEstado_empleado());
				empleado.setCodigo_empleado(empl.getCodigo_empleado());
				empleado.setTelefono_empleado(empl.getTelefono_empleado());
				empleado.setId_Factura(empl.getId_Factura());
			}
		}
		return ResponseEntity.ok(empleado);
	}
	
	// Editar empleado
	@PutMapping("/actualizarEmpleado/{cedula}")
	public ResponseEntity<?> actualizarEmpleado(@RequestBody Empleado empleadoActualizado,@PathVariable(value = "cedula") String cedula) {
		
		Optional<Empleado> oEmpleado = servicioEmpleados.findById(cedula);
		if (!oEmpleado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(empleadoActualizado, oEmpleado.get());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioEmpleados.save(oEmpleado.get()));
	}
	
	//Eliminar empleado
	@DeleteMapping("/{cedula}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable(value = "cedula")String cedula){
		
		if(!servicioEmpleados.findById(cedula).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		servicioEmpleados.deleteById(cedula);
		return ResponseEntity.ok().build();
	}
		
}
