package com.vacaciones.vacaciones.repositories.contracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.vacaciones.vacaciones.entities.Paquete;

public interface IPaqueteRepository extends JpaRepository<Paquete, Long> {

    public Paquete findByNombreIgnoreCase(@Param("nombre") String nombre);
}
