package com.example.Cine_Alvarez.mapper;

import com.example.Cine_Alvarez.dto.VentaDTO;
import com.example.Cine_Alvarez.entity.Venta;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entidades Venta a VentaDTO.
 */
@Component
public class VentaMapper {

    /**
     * Convierte una entidad Venta a VentaDTO con datos legibles para el front.
     * @param v entidad venta
     * @return DTO con los datos de la venta
     */
    public VentaDTO toDTO(Venta v) {
        String cliente = v.getClientes() != null && !v.getClientes().isEmpty()
                ? v.getClientes().get(0).getNombre() : "-";

        String funcion = "-";
        String pelicula = "-";
        if (v.getFunciones() != null && !v.getFunciones().isEmpty()) {
            funcion = v.getFunciones().get(0).getHorario().toString();
            pelicula = v.getFunciones().get(0).getPeliculas() != null
                    ? v.getFunciones().get(0).getPeliculas().getTitulo() : "-";
        }

        String asientos = "-";
        if (v.getFunciones() != null && !v.getFunciones().isEmpty()) {
            asientos = v.getFunciones().get(0).getEntradas().stream()
                    .map(e -> e.getAsiento())
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("-");
        }

        return new VentaDTO(v.getId(), v.getFecha(),
                v.getPago() != null ? v.getPago().getMonto() : 0,
                v.getPago() != null ? v.getPago().getTipo().toString() : "-",
                cliente, funcion, pelicula, asientos);
    }
}