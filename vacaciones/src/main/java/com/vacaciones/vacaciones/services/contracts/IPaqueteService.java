package com.vacaciones.vacaciones.services.contracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.vacaciones.vacaciones.entities.Paquete;

public interface IPaqueteService {

    public ResponseEntity<List<Paquete>> listar();

    public ResponseEntity<Paquete> crear(Paquete paquete);
}
