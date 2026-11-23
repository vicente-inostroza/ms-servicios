package com.veterinaria.ms_servicios.service;

import com.veterinaria.ms_servicios.model.Servicio;
import com.veterinaria.ms_servicios.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository repository;

    public List<Servicio> listarTodos() {
        return repository.findAll();
    }

    public Optional<Servicio> buscarPorCodigo(String codigo) {
        return repository.findById(codigo);
    }

    public boolean existePorCodigo(String codigo) {
        return repository.existsById(codigo);
    }

    public Servicio guardar(Servicio servicio) {
        return repository.save(servicio);
    }

    public void eliminar(String codigo) {
        repository.deleteById(codigo);
    }
}