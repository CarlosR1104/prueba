package com.muebles_valencia.repositorio.administrador_empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles_valencia.entidades.administrador_empleado.Administrador_Empleado;

@Repository
public interface RepositorioAdministradorEmpleado extends JpaRepository<Administrador_Empleado, Integer>{

}
