package com.example.Cine_Alvarez.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionDTO {
    private Integer id;
    private String horario;
    private String pelicula;
    private String genero;
}