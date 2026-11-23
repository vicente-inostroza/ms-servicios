package com.veterinaria.ms_servicios.repository;

import com.veterinaria.ms_servicios.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, String> {
    List<Servicio> findByCategoriaIgnoreCase(String categoria);
    List<Servicio> findByEspecieContainingIgnoreCase(String especie);
}