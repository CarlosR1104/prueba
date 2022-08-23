package com.muebles_valencia.servicios.producto_cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.muebles_valencia.entidades.productos_clientes.Productos_Clientes;
import com.muebles_valencia.repositorio.producto_cliente.RepositorioProductoCliente;

@Service
public class ServicioProductoClienteImpl implements ServicioProductoCliente{

	@Autowired
	private RepositorioProductoCliente productoClienteRepositorio;

	@Override
	public Iterable<Productos_Clientes> findAll() {
		return productoClienteRepositorio.findAll();
	}

	@Override
	public Page<Productos_Clientes> findAll(Pageable pageable) {
		return productoClienteRepositorio.findAll(pageable);
	}

	@Override
	public Optional<Productos_Clientes> findById(Integer codigo) {
		return productoClienteRepositorio.findById(codigo);
	}

	@Override
	public Productos_Clientes save(Productos_Clientes producto_cliente) {
		return productoClienteRepositorio.save(producto_cliente);
	}

	@Override
	public void deleteById(Integer codigo) {
		productoClienteRepositorio.deleteById(codigo);
	}

	@Override
	public Productos_Clientes buscarProductoCliente(String cedula_cliente) {
		List<Productos_Clientes> prods_clis = productoClienteRepositorio.findAll();
		Productos_Clientes prod_cli = null;
		
		for (Productos_Clientes productos_Clientes : prods_clis) {
			if(productos_Clientes.getCodigo_Cliente().equalsIgnoreCase(cedula_cliente)) {
				prod_cli = new Productos_Clientes();
				prod_cli.setCodigo_Cliente(productos_Clientes.getCodigo_Cliente());
				prod_cli.setCodigo_Producto(productos_Clientes.getCodigo_Producto());
			}
		}
		
		return prod_cli;
	}
}
