package com.vacaciones.vacaciones.repositories.contracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacaciones.vacaciones.entities.Destino;

public interface IDestinoRepository extends JpaRepository<Destino, Long> {

}
