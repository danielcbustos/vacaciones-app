package com.vacaciones.vacaciones.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vacaciones.vacaciones.entities.Paquete;
import com.vacaciones.vacaciones.repositories.contracts.IPaqueteRepository;
import com.vacaciones.vacaciones.services.contracts.IPaqueteService;

@Service
public class PaqueteService implements IPaqueteService {

    @Autowired
    private IPaqueteRepository paqueteRepository;

    @Override
    public ResponseEntity<List<Paquete>> listar() {
        try {
            List<Paquete> paquetes = this.paqueteRepository.findAll();
            return new ResponseEntity<List<Paquete>>(paquetes, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("error: " + e);
            return new ResponseEntity<List<Paquete>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Paquete> crear(Paquete paquete) {
        try {
            Paquete existingPaquete = paqueteRepository.findByNombreIgnoreCase(paquete.getNombre());

            if (existingPaquete != null) {
                return new ResponseEntity<Paquete>(HttpStatus.CONFLICT);
            }

            Paquete paqueteSaves = this.paqueteRepository.save(paquete);
            return new ResponseEntity<Paquete>(paqueteSaves, HttpStatus.CREATED);

        } catch (Exception e) {
            System.out.println("error: " + e);
            return new ResponseEntity<Paquete>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
