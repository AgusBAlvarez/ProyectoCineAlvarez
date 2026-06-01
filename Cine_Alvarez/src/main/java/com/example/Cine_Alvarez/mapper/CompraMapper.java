package com.example.Cine_Alvarez.mapper;

import com.example.Cine_Alvarez.dto.CompraDTO;
import com.example.Cine_Alvarez.entity.Compra;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CompraMapper {

    /**
     * Convierte una entidad Compra a CompraDTO.
     * @param c entidad compra
     * @return DTO con los datos de la compra
     */
    public CompraDTO toDTO(Compra c) {
        List<String> insumos = c.getInsumos() != null
                ? c.getInsumos().stream().map(i -> i.getNombre() + " $" + i.getPrecio()).toList()
                : List.of();
        List<String> proveedores = c.getProveedores() != null
                ? c.getProveedores().stream().map(p -> p.getNombre()).toList()
                : List.of();
        return new CompraDTO(c.getId(), c.getFecha(), insumos, proveedores);
    }
}