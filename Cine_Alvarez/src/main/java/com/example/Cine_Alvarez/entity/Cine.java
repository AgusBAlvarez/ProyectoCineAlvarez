package com.example.Cine_Alvarez.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String direccion;

    @ManyToMany
    @JoinTable(
            name = "cine_salaVIP",
            joinColumns = @JoinColumn(name = "cine_id"),
            inverseJoinColumns = @JoinColumn(name = "salaVIP_id")
    )
    private List<SalaVIP> salasVIP;

    @OneToMany
    @JoinColumn(name = "sala_id")
    private List<Sala> salas;

    @OneToMany
    @JoinColumn(name = "venta_id")
    private List<Venta> ventas;

    @OneToMany
    @JoinColumn(name = "pelicula")
    private List<Pelicula> peliculas = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "compra_id")
    private List<Compra> compras;

    @ManyToMany
    @JoinTable(
            name = "cine_empleado",
            joinColumns = @JoinColumn(name = "cine_id"),
            inverseJoinColumns = @JoinColumn(name = "empleado_id")
    )
    private List<Empleado> empleados;

}