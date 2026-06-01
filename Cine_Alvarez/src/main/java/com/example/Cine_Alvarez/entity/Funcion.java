package com.example.Cine_Alvarez.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalTime horario;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Pelicula peliculas;

    @ManyToMany
    @JoinTable(
            name = "funcion_entrada",
            joinColumns = @JoinColumn(name = "funcion_id"),
            inverseJoinColumns = @JoinColumn(name = "entrada_id")
    )
    private List<Entrada> entradas;
}