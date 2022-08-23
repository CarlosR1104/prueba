package com.muebles_valencia.seguridad2;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muebles_valencia.entidades.cliente.Cliente;

@Service
public class UsuarioService implements UserDetailsService, IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("LOAD BY USERNAME " + username);
		Logger logger = LoggerFactory.getLogger(UsuarioService.class);
		Cliente usuario = usuarioDao.findByCorreo(username);
		System.out.println("USUARIO " + usuario);
		if(usuario == null) {
			logger.error("Error en el loggin: no existe el usuario '"+username +"'en el sistema");
			throw new UsernameNotFoundException("Error en el loggin: no existe el usuario '"+username +"'en el sistema");
			
		}
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> logger.info("Role" + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getCorreo(), usuario.getContraseña_cliente(), true, true, true, true, authorities);
	}

	@Override
	public Cliente findByCorreo(String correo) {
		// TODO Auto-generated method stub
		return usuarioDao.findByCorreo(correo);
	}
}
