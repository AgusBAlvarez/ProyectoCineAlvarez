package com.example.Cine_Alvarez.mapper;

import com.example.Cine_Alvarez.dto.EmpleadoDTO;
import com.example.Cine_Alvarez.entity.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {

    /**
     * Convierte una entidad Empleado a EmpleadoDTO.
     * @param e entidad empleado
     * @return DTO con los datos del empleado
     */
    public EmpleadoDTO toDTO(Empleado e) {
        return new EmpleadoDTO(e.getId(), e.getNombre(), e.getDni());
    }
}