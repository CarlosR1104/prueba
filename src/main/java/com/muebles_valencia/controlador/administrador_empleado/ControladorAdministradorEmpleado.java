package com.muebles_valencia.controlador.administrador_empleado;

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

import com.muebles_valencia.entidades.administrador_empleado.*;
import com.muebles_valencia.servicios.administrador_empleado.ServicioAdministradorEmpleado;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","null"})
@RequestMapping("/administradores_empleados")
public class ControladorAdministradorEmpleado {
	
	@Autowired
	private ServicioAdministradorEmpleado servicioAdministradorEmpleado;
	
	// Registrar un nuevo empleado relacionado con el administrador
	//http://localhost:8080/administradores_empleados
	@PostMapping
	public ResponseEntity<?> registrarAdministradorEmpleado(@RequestBody Administrador_Empleado administrador_empleado) {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioAdministradorEmpleado.save(administrador_empleado));
	}
	
	// Consultar administrador_empleado
	//http://localhost:8080/administradores_empleados/buscarAdministradorEmpleado/{codigo}
	@GetMapping("/buscarAdministradorEmpleado/{codigo}")
	public ResponseEntity<?> consultarAdministradorEmpleado(@PathVariable(value = "codigo")String cedula_empleado) {
		Administrador_Empleado adm_emp = servicioAdministradorEmpleado.buscarAdministradorEmpleado(cedula_empleado);
		if(adm_emp.getCodigo_Empleado().equalsIgnoreCase(cedula_empleado)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(adm_emp);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(adm_emp);
	}
	
	// Editar producto_cliente
	//http://localhost:8080/administradores_empleados/actualizarAdministradorEmpleado/{codigo}
	@PutMapping("/actualizarAdministradorEmpleado/{codigo}")
	public ResponseEntity<?> actualizarAdministradorEmpleado(@RequestBody Administrador_Empleado adm_empActualizado,@PathVariable(value = "codigo") String identificacion) {
		
		Administrador_Empleado oAdmEmp= servicioAdministradorEmpleado.buscarAdministradorEmpleado(identificacion);
		if (oAdmEmp == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(adm_empActualizado, oAdmEmp);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioAdministradorEmpleado.save(oAdmEmp));
	}
	
	//Eliminar producto_cliente
	//http://localhost:8080/administradores_empleados/eliminarAdministradorEmpleado/{codigo}
	@DeleteMapping("/eliminarAdministradorEmpleado/{codigo}")
	public ResponseEntity<?> eliminarAdministradorEmpleado(@PathVariable(value = "codigo")String cedula){
	
		Administrador_Empleado adm_emp = servicioAdministradorEmpleado.buscarAdministradorEmpleado(cedula);
		if(adm_emp == null) {
			return ResponseEntity.notFound().build();
		}
		
		servicioAdministradorEmpleado.deleteById(adm_emp.getPuente());
		return ResponseEntity.ok().build();
	}

}
