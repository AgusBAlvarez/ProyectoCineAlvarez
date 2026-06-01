package com.example.Cine_Alvarez.dto;

import lombok.Data;

/**
 * DTO de entrada para crear una función.
 * Recibe los datos del front para crear una nueva función con su sala y película.
 */
@Data
public class FuncionRequestDTO {
    private String horario;
    private Integer peliculaId;
    private Integer salaId;
}