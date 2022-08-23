package com.muebles_valencia.servicios.administrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muebles_valencia.entidades.administrador.Administrador;
import com.muebles_valencia.repositorio.administrador.RepositorioAdministrador;

@Service
public class ServicioAdministradorImpl implements ServicioAdministrador{
	
	@Autowired
	private RepositorioAdministrador administradorRepositorio;

	@Transactional(readOnly = true)
	public Iterable<Administrador> findAll() {
		return administradorRepositorio.findAll();
	}


	@Transactional(readOnly = true)
	public Page<Administrador> findAll(Pageable pageable) {
		return administradorRepositorio.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Optional<Administrador> findById(int codigo) {
		return administradorRepositorio.findById(codigo);
	}

	
	@Transactional
	public Administrador save(Administrador admin) {
		return administradorRepositorio.save(admin);
	}

	
	@Transactional
	public void deleteById(int codigo) {
		administradorRepositorio.deleteById(codigo);
	}

	@SuppressWarnings("null")
	@Transactional
	public Administrador iniciarSesion(String correo ,String password) {
		List<Administrador> administradores = administradorRepositorio.findAll();
		Optional<Administrador> admin = null;
		Administrador adminFinal = null;
		System.out.println("ENTRA");
		for (Administrador a : administradores) {
			if(a.getCorreo_administrador().equals(correo)) {
				if(a.getContraseña_administrador().equals(password)) {
					admin =  administradorRepositorio.findById(a.getCodigo_administrador());
					if(admin.isPresent()) {
						adminFinal = new Administrador();
						adminFinal.setNombre_administrador(admin.get().getNombre_administrador());
						adminFinal.setCorreo_administrador(admin.get().getCorreo_administrador());
						adminFinal.setCodigo_administrador(null);
						adminFinal.setContraseña_administrador(password);
					}else {
						adminFinal = new Administrador();
						adminFinal.setNombre_administrador("");
						adminFinal.setCodigo_administrador(null);
						adminFinal.setCorreo_administrador("");
						adminFinal.setContraseña_administrador("");
					}
				
				}else {
					adminFinal = new Administrador();
					adminFinal.setNombre_administrador("");
					adminFinal.setCodigo_administrador(null);
					adminFinal.setCorreo_administrador("");
					adminFinal.setContraseña_administrador("");
				}
			}else {
				adminFinal = new Administrador();
				adminFinal.setNombre_administrador("");
				adminFinal.setCodigo_administrador(null);
				adminFinal.setCorreo_administrador("");
				adminFinal.setContraseña_administrador("");
			}
		}
		return adminFinal;
	}

	/**
	@SuppressWarnings("null")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<Administrador> administradores = administradorRepositorio.findAll();
		Administrador adm = null;
		
		for (Administrador administrador : administradores) {
			if(administrador.getCorreo_administrador().equalsIgnoreCase(username)) {
				adm = new Administrador();
				adm.setCorreo_administrador(administrador.getCorreo_administrador());
				adm.setContraseña_administrador(administrador.getContraseña_administrador());
			}
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails adminDetails = new User(adm.getCorreo_administrador() , adm.getContraseña_administrador() , roles);
		
		return adminDetails;
	}
	**/
}	
