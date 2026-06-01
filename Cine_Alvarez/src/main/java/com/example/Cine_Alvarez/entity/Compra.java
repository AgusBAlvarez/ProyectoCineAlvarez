package com.example.Cine_Alvarez.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fecha;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "compra_id")
    private List<Insumo> insumos = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "compra_id")
    private List<Proveedor> proveedores;
}