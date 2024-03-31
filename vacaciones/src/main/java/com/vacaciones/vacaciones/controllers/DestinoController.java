package com.vacaciones.vacaciones.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.vacaciones.entities.Destino;
import com.vacaciones.vacaciones.services.contracts.IDestinoService;

@RestController
@RequestMapping("/destino")
public class DestinoController {

    @Autowired
    private IDestinoService destinoService;

    @GetMapping("/listar")
    private ResponseEntity<List<Destino>> obtenerDestinos() {
        return this.destinoService.listar();
    }

    @PostMapping("/crear")
    private ResponseEntity<Destino> crearDestino(@RequestBody Destino destino) {
        return this.destinoService.crear(destino);
    }

    @PutMapping("/editar/{id}")
    private ResponseEntity<Destino> editarDestino(@PathVariable Long id, @RequestBody Destino destinoUpdated) {
        return this.destinoService.editar(id, destinoUpdated);
    }

    @DeleteMapping("/eliminar/{id}")
    private ResponseEntity<Destino> eliminarDestino(@PathVariable Long id) {
        return this.destinoService.eliminar(id);
    }

}
