package com.example.Cine_Alvarez.mapper;

import com.example.Cine_Alvarez.dto.EntradaDTO;
import com.example.Cine_Alvarez.entity.Entrada;
import org.springframework.stereotype.Component;

@Component
public class EntradaMapper {

    /**
     * Convierte una entidad Entrada a EntradaDTO.
     * @param e entidad entrada
     * @param funcionId id de la función asociada
     * @return DTO con los datos de la entrada
     */
    public EntradaDTO toDTO(Entrada e, Integer funcionId) {
        return new EntradaDTO(e.getId(), e.getAsiento(), e.getPrecio(), funcionId);
    }

    /**
     * Convierte una entidad Entrada a EntradaDTO sin función asociada.
     * @param e entidad entrada
     * @return DTO con los datos de la entrada
     */
    public EntradaDTO toDTO(Entrada e) {
        return new EntradaDTO(e.getId(), e.getAsiento(), e.getPrecio(), null);
    }
}