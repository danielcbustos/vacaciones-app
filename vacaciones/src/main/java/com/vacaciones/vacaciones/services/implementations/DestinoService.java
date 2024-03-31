package com.vacaciones.vacaciones.services.implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vacaciones.vacaciones.entities.Destino;
import com.vacaciones.vacaciones.repositories.contracts.IDestinoRepository;
import com.vacaciones.vacaciones.services.contracts.IDestinoService;

@Service
public class DestinoService implements IDestinoService {

    @Autowired
    private IDestinoRepository destinoRepository;

    @Override
    public ResponseEntity<List<Destino>> listar() {
        try {
            List<Destino> destinos = this.destinoRepository.findAll();
            return new ResponseEntity<List<Destino>>(destinos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("error: " + e);
            return new ResponseEntity<List<Destino>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<Destino> crear(Destino destino) {

        try {
            Destino savedDestino = this.destinoRepository.save(destino);
            return new ResponseEntity<Destino>(savedDestino, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("error: " + e);
            return new ResponseEntity<Destino>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<Destino> editar(Long id, Destino destinoUpdated) {

        try {
            Optional<Destino> existingDestino = this.destinoRepository.findById(id);
            if (existingDestino.isPresent()) {
                Destino destino = existingDestino.get();
                destino.setNombre(destinoUpdated.getNombre());
                destino.setDescripcion(destinoUpdated.getDescripcion());
                destino.setPais(destinoUpdated.getPais());
                destino.setPrecio(destinoUpdated.getPrecio());
                destino.setDisponible(destinoUpdated.getDisponible());

                Destino updateDestino = this.destinoRepository.save(destino);
                return new ResponseEntity<Destino>(updateDestino, HttpStatus.OK);
            } else {
                return new ResponseEntity<Destino>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            System.out.println("error: " + e);
            return new ResponseEntity<Destino>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<Destino> eliminar(Long id) {
        try {
            Optional<Destino> destinoToDelete = this.destinoRepository.findById(id);
            if (destinoToDelete.isPresent()) {
                Destino destino = destinoToDelete.get();
                destino.getPaquetes().clear();
                this.destinoRepository.delete(destino);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
            return new ResponseEntity<Destino>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
