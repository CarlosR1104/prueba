package com.muebles_valencia.controlador.favoritos;

import java.util.List;
import java.util.Optional;

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
import com.muebles_valencia.entidades.favoritos.Favoritos;
import com.muebles_valencia.servicios.favoritos.ServiciosFavoritos;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","null"})
@RequestMapping("/favoritos")
public class ControladorFavoritos {
	@Autowired
	private ServiciosFavoritos servicFavoritos;
	
	//registrar favoritos
	//http://localhost:8080/favoritos
	@PostMapping
	public ResponseEntity<?> registrarFavoritos(@RequestBody Favoritos favoritos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicFavoritos.save(favoritos));
	}
	//http://localhost:8080/favoritos/listfavoritos
	@GetMapping("/listfavoritos")
	public List<Favoritos> listarProductos(){
		List<Favoritos> favoritos = null;
		try {
			favoritos=(List<Favoritos>) servicFavoritos.findAll();
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return favoritos;
	}	
	
	//http://localhost:8080/favoritos/eliminarFavoritos/{codigo}
	@DeleteMapping("/eliminarFavoritos/{codigo}")
	public ResponseEntity<?> eliminarCarritoCompra(@PathVariable(value = "codigo")Integer codigo){
		
		if(!servicFavoritos.findById(codigo).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		servicFavoritos.deleteById(codigo);
		return ResponseEntity.ok().build();
	}
	
	//http://localhost:8080/favoritos/actualizarFavoritos/{codigo}
	@PutMapping("/actualizarFavoritos/{codigo}")
	public ResponseEntity<?> actualizarCarritoCompra(@RequestBody Favoritos favoritosUpdate,@PathVariable(value = "codigo") Integer codigo) {
		
		Optional<Favoritos> oFavoritos = servicFavoritos.findById(codigo);
		if (!oFavoritos.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(favoritosUpdate, oFavoritos.get());
		
				
		return ResponseEntity.status(HttpStatus.CREATED).body(servicFavoritos.save(oFavoritos.get()));
	}
}
