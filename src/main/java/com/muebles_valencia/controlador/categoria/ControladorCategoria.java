package com.muebles_valencia.controlador.categoria;

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

import com.muebles_valencia.entidades.categoria.Categoria;
import com.muebles_valencia.entidades.cliente.Cliente;
import com.muebles_valencia.servicios.categoria.ServicioCategoria;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","null"})
@RequestMapping("/categorias")
public class ControladorCategoria {
	
	@Autowired
	private ServicioCategoria servicioCategorias;
	
	// Registrar una nueva categoria
	//http://localhost:8080/categorias
	@PostMapping
	public ResponseEntity<?> registrarUsuario(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioCategorias.save(categoria));
	}
	
	// Consultar categoria
	//http://localhost:8080/categorias/buscarCategoria/{codigo}
	@GetMapping("/buscarCategoria/{codigo}")
	public ResponseEntity<?> consultarCategoria(@PathVariable(value = "codigo") Integer codigo) {
		Categoria categ = null;
		List<Categoria> categorias = StreamSupport.stream(servicioCategorias.findAll().spliterator(),false).collect(Collectors.toList());
		for (Categoria categoria : categorias) {
			if(categoria.getId_categoria() == codigo) {
				categ = new Categoria();
				categ.setId_categoria(categoria.getId_categoria());
				categ.setNombre_categoria(categoria.getNombre_categoria());
			}
		}
		return ResponseEntity.ok(categ);
	}
	
	// Editar categoria
	//localhost:8080/categorias/actualizarCategoria/{codigo}
	@PutMapping("/actualizarCategoria/{codigo}")
	public ResponseEntity<?> actualizarCategoria(@RequestBody Categoria categoriaActualizado,@PathVariable(value = "codigo") Integer codigo) {
		
		Optional<Categoria> oCategoria = servicioCategorias.findById(codigo);
		if (!oCategoria.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(categoriaActualizado, oCategoria.get());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioCategorias.save(oCategoria.get()));
	}
	
	//Eliminar categoria
	//http://localhost:8080/categorias/eliminarCategoria/{codigo}
	@DeleteMapping("/eliminarCategoria/{codigo}")
	public ResponseEntity<?> eliminarCategoria(@PathVariable(value = "codigo")Integer codigo){
		
		if(!servicioCategorias.findById(codigo).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		servicioCategorias.deleteById(codigo);
		return ResponseEntity.ok().build();
	}
	
	//Listar categorias totales
	@GetMapping("/listarCategorias")
	public List<Categoria> listarCategorias(){
		List<Categoria> categorias = StreamSupport.stream(servicioCategorias.findAll().spliterator(),false).collect(Collectors.toList());
		return categorias;
	}
}
