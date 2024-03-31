package com.vacaciones.vacaciones.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.vacaciones.entities.Paquete;
import com.vacaciones.vacaciones.services.contracts.IPaqueteService;

@RestController
@RequestMapping("/paquete")
public class PaqueteController {

    @Autowired
    private IPaqueteService paqueteService;

    @GetMapping("/listar")
    private ResponseEntity<List<Paquete>> obtenerCategorias() {
        return this.paqueteService.listar();
    }

    @PostMapping("/crear")
    private ResponseEntity<Paquete> crearPaquete(@RequestBody Paquete paquete) {
        return this.paqueteService.crear(paquete);
    }
}
