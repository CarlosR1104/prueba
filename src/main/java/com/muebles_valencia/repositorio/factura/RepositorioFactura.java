package com.muebles_valencia.repositorio.factura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles_valencia.entidades.factura.Factura;

@Repository
public interface RepositorioFactura extends JpaRepository<Factura,Integer>{

}
