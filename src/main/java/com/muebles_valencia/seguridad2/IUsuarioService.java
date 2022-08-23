package com.muebles_valencia.seguridad2;

import com.muebles_valencia.entidades.cliente.Cliente;

public interface IUsuarioService {

	public Cliente findByCorreo(String correo);
}
