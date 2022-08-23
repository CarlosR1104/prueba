package com.muebles_valencia;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.muebles_valencia.entidades.cliente.*;
import com.muebles_valencia.repositorio.administrador.RepositorioAdministrador;
import com.muebles_valencia.repositorio.cliente.RepositorioCliente;

@SpringBootTest
class MuebleriaApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RepositorioCliente repoCliente;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;
	
	@Test
	public void crearAdministradorTest() {
		Cliente cli = new Cliente();
		
		System.out.println(passwordEnconder.encode("123"));
		assertTrue(1==1);
	}
}
