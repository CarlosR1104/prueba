package com.muebles_valencia.servicios.clientes_roles;
/**
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muebles_valencia.entidades.clientes_roles.ClientesRoles;
import com.muebles_valencia.repositorio.clientes_roles.RepositorioClientes_Roles;

@Service
public class ServicioClientesRolesImpl implements ServicioClientes_Roles{
	
	@Autowired
	private RepositorioClientes_Roles repoClienteRol;

	@Override
	public ClientesRoles save(ClientesRoles clientes_roles) {
		return repoClienteRol.save(clientes_roles);
	}
	
	
}
**/