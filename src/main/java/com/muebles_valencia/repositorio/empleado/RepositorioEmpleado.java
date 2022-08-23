package com.muebles_valencia.repositorio.empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles_valencia.entidades.empleado.*;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado, String>{

}
