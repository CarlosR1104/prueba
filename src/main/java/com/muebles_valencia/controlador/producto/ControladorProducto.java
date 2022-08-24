package com.muebles_valencia.controlador.producto;

import com.muebles_valencia.entidades.categoria.Categoria;
import com.muebles_valencia.entidades.producto.Producto;
import com.muebles_valencia.repositorio.categoria.RepositorioCategoria;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;

//import javax.persistence.criteria.Path;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.muebles_valencia.servicios.categoria.ServicioCategoria;
import com.muebles_valencia.servicios.correo.EnviadorDeCorreos;
import com.muebles_valencia.servicios.productos.ServicioProducto;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" , "null" , "**"})
@RequestMapping("/producto")
public class ControladorProducto {
	
	List<Producto> listaCategorias = new ArrayList<Producto>();
	
	@Autowired
	private ServicioProducto servicioProducto;

	@Autowired
	private ServicioCategoria servicioCategoria;

	@Autowired
	private EnviadorDeCorreos enviarCorreo;
	
	@Autowired
	private RepositorioCategoria repoCategoria;
	
	// Registrar un producto
	// http://localhost:8080/productos
	@PostMapping
	public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {

//		if(!foto.isEmpty()) {

//			String ruta="C://Temp//uploads";
		Path directorioImagenes = Paths.get("src//main//resources//static/upload");

//			//String rutaAbsoluta=directorioImagenes.toFile().getAbsolutePath();
//			System.out.println("semetio");
//		
//			try {
//				System.out.println("se metio en foto");
//				byte[] byt=foto.getBytes();
//				Path rutaCompleta= Paths.get(ruta + "//" + foto.getOriginalFilename());
//				Files.write(rutaCompleta, byt);
//				producto.setFoto(foto.getOriginalFilename());
//				
//			} catch (Exception e) {
//				System.out.println("se nose metio ");
//			}

		return ResponseEntity.status(HttpStatus.CREATED).body(servicioProducto.save(producto));
	}

	// Listar Productos
	// http://localhost:8080/producto/listaProductos
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" , "null" , "**"})
	@GetMapping("/listaProductos")
	public List<Producto> listarProductos() {
		List<Producto> productos = null;
		try {
			productos = (List<Producto>) servicioProducto.findAll();

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return productos;
	}

	// Reservar Producto
	// http://localhost:8080/producto/reservarProducto/{correo}/{nombre}
	@PostMapping("/reservarProducto/{correo}/{nombre}")
	public Producto reservarProducto(@PathVariable(value = "correo") String correo,
			@PathVariable(value = "nombre") String nombreCliente , @RequestBody Producto prodReservar) {
		try {
			System.out.println("CORREO " + correo);
			enviarCorreo.sendEmail(correo , nombreCliente , prodReservar);

		} catch (Exception e) {
			System.out.println("ERROR CONTROLADOR " + e) ;
		}

		return null;

	}

	// Buscar productos
	// http://localhost:8080/producto/buscar/<codigo_producto>
	@GetMapping("/buscar/{id}")
	public Producto consultarProductos(@PathVariable(value = "id") int codigo) {

		Optional<Producto> producto = servicioProducto.findById(codigo);
		if (!producto.isPresent()) {
			return producto.get();
		}

		return producto.get();
	}

	// EditarProductos
	// http://localhost:8080/productos/<codigo_productos>
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Producto> actualizarPoductos(@RequestBody Producto productoActualizar,
			@PathVariable(value = "id") int codigo) {
		Optional<Producto> producto = servicioProducto.findById(codigo);
		if (!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(productoActualizar, producto.get());

		return ResponseEntity.status(HttpStatus.CREATED).body(servicioProducto.save(producto.get()));

	}
	
	// Filtrar por precio
	@PostMapping("/filtrar/{minimo}/{maximo}")
	public List<Producto> filtrarPorPrecio(@PathVariable(value = "minimo") float minimo,
			@PathVariable(value = "maximo") float maximo) {
		List<Producto> productos2 = StreamSupport
				.stream(servicioProducto.filtrarPrecio(minimo, maximo).spliterator(), false)
				.collect(Collectors.toList());
		System.out.println("MINIMO: " + minimo);
		System.out.println("MAXIMO: " + maximo);
		if (productos2.isEmpty()) {
			return null;
		}

		return productos2;
	}

	// Filtrar por categoria
	@PostMapping("/filtrarCategoria/{categoria}")
	public List<Producto> filtrarCategoria(@PathVariable(value = "categoria") String categoria) {
		List<Producto> productos = null;
		System.out.println("ENTRA EN CONTROLADOR PRODUCTO " + categoria);
		List<Categoria> categorias= repoCategoria.findByNombreC(categoria);
		productos = (List<Producto>) servicioProducto.findAll();
		
		for (Categoria categoria2 : categorias) {
			
			for (Producto producto : productos) {
				System.out.println(categoria2);
				System.out.println(producto.getId_categoria());
				System.out.println(producto);
				if (producto.getId_categoria() == categoria2) {
					
					listaCategorias.add(producto);
					
					System.out.println(listaCategorias);
					
				}
			}
		}
		
		if (categorias.isEmpty()) {
			System.out.println("PRODUCTOS VACIOS");
			listaCategorias.clear();
			return listaCategorias;
		}
		System.out.println(listaCategorias);
		return listaCategorias;

	}

	// Consultar categoria de un producto
	@GetMapping("/consultarCategoria/{categoria}")
	public Categoria consultarCategoria(@PathVariable(value = "categoria") int categoria) {
		Categoria categoriaEncontrada = null;
		List<Categoria> categorias = StreamSupport.stream(servicioCategoria.findAll().spliterator(), false)
				.collect(Collectors.toList());

		for (Categoria cat : categorias) {
			if (cat.getId_categoria() == categoria) {
				categoriaEncontrada = new Categoria();
				categoriaEncontrada.setId_categoria(cat.getId_categoria());
				categoriaEncontrada.setNombre_categoria(cat.getNombre_categoria());
			}
		}
		return categoriaEncontrada;
	}

	@PostMapping("/productosNuevos/{fecha}")
	public List<Producto> productosNuevos(@PathVariable(value = "fecha") String fecha) throws ParseException {
		System.out.println(fecha);
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		Date fechaComparar = formato
				.parse(fecha.substring(0, 2) + "/" + fecha.substring(4, 5) + "/" + fecha.substring(6, 10));

		System.out.println("FECHA COMPARAR " + formato.format(fechaComparar));
		List<Producto> productos = StreamSupport.stream(
				servicioProducto.productosNuevos(fechaComparar.getMonth(), fechaComparar.getYear()).spliterator(),
				false).collect(Collectors.toList());
		if (productos.isEmpty()) {
			System.out.println("NO ENCONTRO PRODS NUEVOS");
			return productos;
		}

		return productos;
	}

	@PostMapping("/img")
	public ResponseEntity<Producto> guardarImg(@RequestParam("file") MultipartFile foto, Producto producto) {

		if (!foto.isEmpty()) {

			String ruta = "C://Temp//uploads";
			// Path directorioImagenes= Paths.get("src//main//resources//static/upload");

			// String rutaAbsoluta=directorioImagenes.toFile().getAbsolutePath();
			System.out.println("semetio");

			try {
				System.out.println("se metio en foto");
				byte[] byt = foto.getBytes();
				Path rutaCompleta = Paths.get(ruta + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, byt);
				producto.setFoto_producto(foto.getOriginalFilename());

			} catch (Exception e) {
				System.out.println("se nose metio ");
			}
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(servicioProducto.save(producto));

	}
}
