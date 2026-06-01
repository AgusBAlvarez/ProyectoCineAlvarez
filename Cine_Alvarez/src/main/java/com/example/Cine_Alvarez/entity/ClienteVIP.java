package com.example.Cine_Alvarez.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteVIP extends Cliente implements Serializable {
    protected float descuento;

}