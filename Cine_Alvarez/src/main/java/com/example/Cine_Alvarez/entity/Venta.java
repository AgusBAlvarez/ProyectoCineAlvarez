package com.example.Cine_Alvarez.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate fecha;

    @ManyToOne
    private Pago pago;

    @ManyToMany
    @JoinTable(
            name = "venta_funcion",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "funcion_id")
    )
    private List<Funcion> funciones;

    @ManyToMany
    @JoinTable(
            name = "venta_cliente",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientes;
}