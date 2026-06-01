package com.example.Cine_Alvarez.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {
    private Integer id;
    private Date fecha;
    private List<String> insumos;
    private List<String> proveedores;
}