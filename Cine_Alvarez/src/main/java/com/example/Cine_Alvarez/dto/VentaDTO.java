package com.example.Cine_Alvarez.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private Integer id;
    private LocalDate fecha;
    private double monto;
    private String tipoPago;
    private String cliente;
    private String funcion;
    private String pelicula;
    private String asientos;
}