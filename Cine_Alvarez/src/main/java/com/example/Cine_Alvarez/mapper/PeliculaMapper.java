package com.example.Cine_Alvarez.mapper;

import com.example.Cine_Alvarez.dto.PeliculaDTO;
import com.example.Cine_Alvarez.entity.Pelicula;
import org.springframework.stereotype.Component;

@Component
public class PeliculaMapper {

    /**
     * Convierte una entidad Pelicula a PeliculaDTO.
     * @param p entidad pelicula
     * @return DTO con los datos de la pelicula
     */
    public PeliculaDTO toDTO(Pelicula p) {
        return new PeliculaDTO(p.getId(), p.getTitulo(), p.getGenero().toString());
    }
}