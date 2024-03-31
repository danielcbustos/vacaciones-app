package com.vacaciones.vacaciones.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "destino")
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "pais", nullable = false)
    private String pais;
    @Column(name = "precio", nullable = false)
    private Integer precio;
    @Column(name = "disponible", nullable = false)
    private Boolean disponible;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "destinoPaquete", joinColumns = @JoinColumn(name = "destino_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "paquete_id", referencedColumnName = "id"))
    @JsonIgnoreProperties("destinos")
    private List<Paquete> paquetes;

}
