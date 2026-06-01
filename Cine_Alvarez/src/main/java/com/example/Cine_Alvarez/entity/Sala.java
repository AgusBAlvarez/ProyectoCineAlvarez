package com.example.Cine_Alvarez.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sala implements Serializable {
    @Id
    private Integer id;

    private int capacidad;

    @ManyToMany
    @JoinTable(
            name = "sala_funcion",
            joinColumns = @JoinColumn(name = "sala_id"),
            inverseJoinColumns = @JoinColumn(name = "funcion_id")
    )
    private List<Funcion> funciones = new ArrayList<>();

}