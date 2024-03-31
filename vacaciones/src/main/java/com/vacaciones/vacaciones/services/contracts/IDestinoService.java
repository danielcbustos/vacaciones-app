package com.vacaciones.vacaciones.services.contracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.vacaciones.vacaciones.entities.Destino;

public interface IDestinoService {

    public ResponseEntity<List<Destino>> listar();

    public ResponseEntity<Destino> crear(Destino destino);

    public ResponseEntity<Destino> editar(Long id, Destino destinoUpdated);

    public ResponseEntity<Destino> eliminar(Long id);

}
