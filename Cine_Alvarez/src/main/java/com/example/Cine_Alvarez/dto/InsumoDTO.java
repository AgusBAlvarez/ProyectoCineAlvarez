package com.example.Cine_Alvarez.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsumoDTO {
    private Integer id;
    private String nombre;
    private double precio;
}