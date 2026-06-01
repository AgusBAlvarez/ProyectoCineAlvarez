package com.example.Cine_Alvarez.mapper;

import com.example.Cine_Alvarez.dto.SalaDTO;
import com.example.Cine_Alvarez.entity.Sala;
import org.springframework.stereotype.Component;

@Component
public class SalaMapper {

    /**
     * Convierte una entidad Sala a SalaDTO.
     * @param s entidad sala
     * @return DTO con los datos de la sala
     */
    public SalaDTO toDTO(Sala s) {
        return new SalaDTO(s.getId(), s.getCapacidad());
    }
}