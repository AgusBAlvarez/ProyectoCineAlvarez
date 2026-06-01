package com.example.Cine_Alvarez.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Integer id;
    private String nombre;
    private String email;
    private boolean vip;
    private float descuento;
}
