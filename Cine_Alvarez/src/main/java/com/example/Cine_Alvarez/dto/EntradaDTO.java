package com.example.Cine_Alvarez.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaDTO {
    private Integer id;
    private String asiento;
    private double precio;
    private Integer funcionId;
}